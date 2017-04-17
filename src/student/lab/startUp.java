/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.lab;


import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;


/**
 *
 * @author vekivulic
 */
public class startUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // DateUtilities date=new DateUtilities();
       // date.setEndingTemporalObject(LocalDateTime.now());
        
        DateTimeFormatter format= DateTimeFormatter.ISO_DATE;
   
 
    ZonedDateTime zone=ZonedDateTime.now();
    zone=zone.withZoneSameInstant(ZoneId.of("Europe/Belgrade"));
    ZoneId currentZone = ZoneId.systemDefault();
    System.out.println("CurrentZone: " + currentZone);
    System.out.println("Current date and time in Belgrade, Serbia is " + zone.format(format));
 
    
    
    LocalDate now= LocalDate.now();
    LocalDate fourMonthFuture=now.plusMonths(4);
    LocalDate fourMonthPast=now.minusMonths(4);
         Chronology chrono=null;
    
         System.out.println(now.format(format)+fourMonthFuture.format(format.withChronology(chrono))
                 +fourMonthPast.format(format.withChronology(chrono)));
    
 
         
         
         Period period=Period.between(LocalDate.now(), LocalDate.now().plusWeeks(67));
         System.out.println(period);
         
         
       DateTimeFormatter format1= DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
       LocalDate today = LocalDate.now();
       LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
       LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
       LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
       LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
       LocalDate nextNext=today.plus(1,ChronoUnit.CENTURIES);
        
         System.out.println("Current Date: " + today.format(format1) + "\nNext Week: " + nextWeek.format(format1)
                 + "\nNext Month: " + nextMonth.format(format1) + "\nNext Year: " + nextYear.format(format1) + 
                 "\nNext Decade: " + nextDecade.format(format1) + "\nNext Century: " + nextNext.format(format1));

    
        
        
        
        
        
        
      
    }
    
}
