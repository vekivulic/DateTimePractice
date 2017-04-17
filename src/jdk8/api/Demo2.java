package jdk8.api;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class Demo2 {
    public static void main(String[] args) {
        // Get current date and time
        LocalDateTime date = LocalDateTime.now();
        System.out.println("Current date/time with built-in LocalDateTime class format: " + date);
        
        // Now use new DateTimeFormatter class
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");
        String strDate = date.format(format);
        System.out.println("Current date/time with custom format provided by DateTimeFormatter: " + strDate);

        // Just get Dates without time values and calculate payday
        format = DateTimeFormatter.ofPattern("MMM d yyyy");
        LocalDate today = LocalDate.now();
        LocalDate payday1 = today.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate payday2 = today.with(TemporalAdjusters.lastDayOfMonth()).minusDays(2);
        System.out.println("Pretend Payday is at the end of this month: " + payday1.format(format));
        System.out.println("Pretend Payday is at the end of this month, less two days: " + payday2.format(format));
        
        // What else can you do? Do some research and share with class. You have one hour!
        
        // Find the difference between two dates in hours
       
        LocalDateTime startDate = LocalDateTime.now();
        
         // Solution #1
        LocalDateTime endDate = startDate.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println(startDate.until(endDate, ChronoUnit.HOURS));
        
        // Solution #2
        Duration diff = Duration.between(startDate, endDate);
        System.out.println(diff.toHours());
        
        // Find the last business day numerical value (e.g., 30) of the month given a known
        // value for the last business day String value of the week (e.g., "Friday")
        
        // Solution #1
        LocalDate today2 = LocalDate.now();
        LocalDate lastBusDay = today2.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
        System.out.println(lastBusDay.getDayOfMonth());
        
        // Find the difference between two dates, resulting in hours plus 
        // leftover minutes. So, e.g., 90 minutes is 1 hours and 30 minutes
        LocalDateTime curDate = LocalDateTime.now();
        
        // Solution #1
        LocalDateTime endDate2 = curDate.with(TemporalAdjusters.lastDayOfMonth()).minusMinutes(500);
        long minutes = curDate.until(endDate2, ChronoUnit.MINUTES) % 60;
        long hours = curDate.until(endDate2, ChronoUnit.HOURS);
        System.out.println(hours + " hours, " + minutes + " minutes");
        
        // Solution #2
        Duration diff2 = Duration.between(startDate, endDate2);
        long hrs = diff2.toHours();
        long min = diff2.toMinutes() % 60;
        System.out.println("Hours: " + hrs + ", Minutes: " + min);
        
        // Based on the current, local date and time, calculate the current
        // date and time right now in Berlin, Germany
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd  hh:mm a");
        
        ZonedDateTime local = ZonedDateTime.now();
        local = local.withZoneSameInstant(ZoneId.of("Europe/Berlin"));
        
        System.out.println(local.format(fmt));
        
        // Calculate a due date that is 15 days from now
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dueDate = now.plusDays(15);
        System.out.println(dueDate);
        
        // On what year will the next leap year happen?
        int year = LocalDate.now().getYear();
        while(!Year.isLeap(year)) {
            year++;
        }
        System.out.println("The next leap year is: " + year);
    }
}
