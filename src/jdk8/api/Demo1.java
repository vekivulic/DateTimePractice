package jdk8.api;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class Demo1 {

    public static void main(String[] args) {
        
        // old way (JDK 8 and earlier)
        Calendar calToday = Calendar.getInstance();
        Calendar calPayday = Calendar.getInstance();
        
        int lastDayOfMonth = calToday.getActualMaximum(Calendar.DATE);
        calPayday.set(Calendar.DATE, lastDayOfMonth);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = calPayday.getTime();
        System.out.println("(Java 7) Payday is on: " + sdf.format(date));
        
        // new way (JDK 8+)
        LocalDate today = LocalDate.now();
        LocalDate payday = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("(Java 8) Payday is on: " + payday.format(DateTimeFormatter.ofPattern("M/d/yy")));
    }
    
}
