package old.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Instlogin
 */
public class Example2 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = 
                new SimpleDateFormat("M/d/yyyy h:mm a");
        SimpleDateFormat sdf2 = 
                new SimpleDateFormat("M/d/yyyy h:mm a X");
        // Converting Date to String
        System.out.println(sdf.format(date));
        System.out.println(sdf2.format(calendar.getTime()));
        
        // Convert String to Date
        String s = "10/20/2014 6:19 PM";
        Date date2 = sdf.parse(s);
        System.out.println("Parsed date: " + date2);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        System.out.println("Parsed Calendar: " + cal2.getTime());
        
        Calendar startDate = Calendar.getInstance();
        startDate.set(2014, Calendar.JANUARY, 1);
        startDate.roll(Calendar.YEAR, -2);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2014, Calendar.JANUARY, 15);
        long startMsec = startDate.getTimeInMillis();
        long endMsec = endDate.getTimeInMillis();
        long diff = endMsec - startMsec;
        long days = diff/1000/60/60/24;
        System.out.println("Days between dates: " + days);
        
        // demo add() vs roll()
        calendar.set(2015, Calendar.JANUARY, 31);
        calendar.add(Calendar.MONTH, 1);
        System.out.println("\nUsing Calendar add() 1 month to 1/31/2015: " + sdf.format(calendar.getTime()));
        
        calendar.set(2015, Calendar.JANUARY, 31);
        calendar.roll(Calendar.MONTH, 1);
        System.out.println("Using Calendar roll() 1 month to 1/31/2015: " + sdf.format(calendar.getTime()));

        calendar.set(2015, Calendar.DECEMBER, 31);
        calendar.add(Calendar.MONTH, 1);
        System.out.println("\nUsing Calendar add() 1 month to 12/31/2015: " + sdf.format(calendar.getTime()));
        
        calendar.set(2015, Calendar.DECEMBER, 31);
        calendar.roll(Calendar.MONTH, 1);
        System.out.println("Using Calendar roll() 1 month to 12/31/2015: " + sdf.format(calendar.getTime()));
        
        calendar.set(2015, Calendar.JANUARY, 31);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println("\nUsing Calendar add() 1 day to 1/31/2015: " + sdf.format(calendar.getTime()));
        
        calendar.set(2015, Calendar.JANUARY, 31);
        calendar.roll(Calendar.DAY_OF_MONTH, 1);
        System.out.println("Using Calendar roll() 1 day to 1/31/2015: " + sdf.format(calendar.getTime()));

    }
}
