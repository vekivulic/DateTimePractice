package utility;

import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Singleton uility class to simplify managing and using dates and times, 
 * using the old Java Date/Time API (prior to JDK 8). Fields are
 * provided for choice of units to be returned from date/time difference
 * calculations.
 * <P>
 * Change History:
 * <UL>
 * <LI>2007-03-02 - initial version.</LI>
 * <LI>2007-03-09 - fixed bug in dateDiff method that under certain
 * circumstances produced incorrect values.</LI>
 * <LI>2007-03-30 - refactored various method names and added toDate() method.
 * <LI>2013-08-20 - removed constants for date units and replaced with enum for
 * better type safety.
 * <LI>2016-03-24 - miscellaneous documentation improvements.
 * </UL>
 *
 * (C) 2007 - James G. Lombardo dba The Byteshop.Net
 *
 * This code is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <P>
 * This code is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * @author James G. Lombardo
 * (<a href="mailto:james.g.lombardo@gmail.com">james.g.lombardo@gmail.com</a>)
 * @version 1.03
 */
public class DateUtilities {

    // singleton instance
    private static DateUtilities instance;

    /**
     * An enumeratio of time units, which includes DAY, HOUR, MINUTE and SECOND
     */
    public enum DateUnit {
        
        DAY(1000L * 60L * 60L * 24L),
        HOUR(1000L * 60L * 60L),
        MINUTE(1000L * 60L),
        SECOND(1000L);

        DateUnit(long ms) {
            milliseconds = ms;
        }

        private final long milliseconds;

        public long getMilliseconds() {
            return milliseconds;
        }
    }

    // Prohibit instantiation -- support Singleton design pattern

    private DateUtilities() {
    }

    /**
     * Singleton support.
     *
     * @return one and only one global instance
     */
    public static DateUtilities getInstance() {
        if (instance == null) {
            instance = new DateUtilities();
        }

        return instance;
    }

    /**
     * @return the current date and time.
     */
    public Date now() {
        return Calendar.getInstance().getTime();
    }

    /**
     * Format a <code>Date</code> according to the default date pattern for the
     * current locale
     *
     * @param date - a <code>Date</code> object
     * @return a date formatted according to the default date pattern for the
     * current locale
     * @throws IllegalArgumentException if date is null
     */
    public String toString(Date date) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Error: date argument cannot be null");
        }
        DateFormat df = DateFormat.getDateInstance();
        return df.format(date);
    }

    /**
     * Format a <code>Calendar</code> according to the default date pattern for
     * the current locale
     *
     * @param date - a <code>Calendar</code> object
     * @return a date formatted according to the default date pattern for the
     * current locale
     * @throws IllegalArgumentException if date is null
     */
    public String toString(Calendar date) throws IllegalArgumentException {
        DateFormat df = DateFormat.getDateInstance();
        return df.format(date.getTime());
    }

    /**
     * Format a <code>Calendar</code> according to a specified pattern
     *
     * @param date - a <code>Calendar</code> object
     * @param pattern - a <code>SimpleDateFormat</code> date/time pattern
     * @return a date and or time formatted according to the specified pattern
     * @throws IllegalArgumentException if pattern is not recognized
     */
    public String toString(Calendar date, String pattern) throws IllegalArgumentException {
        String strDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        strDate = sdf.format(date.getTime());

        return strDate;
    }

    /**
     * Format a <code>Calendar</code> according to a specified style for a
     * specified Locale
     *
     * @param date - a <code>Calendar</code> object
     * @param dateFormatStyle - a <code>DateFormat</code> style field
     * @param aLocale - a <code>Locale</code> field
     * @return a date and/or time formatted according to the specified style for
     * the specified Locale
     * @throws IllegalArgumentException if style or locale is not recognized
     */
    public String toString(Calendar date, int dateFormatStyle, Locale aLocale)
            throws IllegalArgumentException {
        String strDate = null;
        DateFormat df = DateFormat.getDateInstance(dateFormatStyle, aLocale);
        strDate = df.format(date.getTime());

        return strDate;
    }

    /**
     * Format a <code>Calendar</code> according to a specified date and time
     * style for a specified Locale
     *
     * @param date - a <code>Calendar</code> object
     * @param dateFormatStyle - a <code>DateFormat</code> style field
     * @param timeFormatStyle - a <code>DateFormat</code> style field
     * @param aLocale - a <code>Locale</code> field
     * @return a date and/or time formatted according to the specified style for
     * the specified Locale
     * @throws IllegalArgumentException if any style or locale is not recognized
     */
    public String toString(Calendar date, int dateFormatStyle, int timeFormatStyle, Locale aLocale)
            throws IllegalArgumentException {
        String strDate = null;
        DateFormat df = DateFormat.getDateTimeInstance(dateFormatStyle, timeFormatStyle, aLocale);
        strDate = df.format(date.getTime());

        return strDate;
    }

    /**
     * Format a <code>Date</code> according to a specified pattern
     *
     * @param date - a <code>Date</code> object
     * @param pattern - a <code>SimpleDateFormat</code> date/time pattern
     * @return a date and/or time formatted according to the specified pattern
     * @throws IllegalArgumentException if pattern is not recognized
     */
    public String toString(Date date, String pattern) throws IllegalArgumentException {
        String strDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        strDate = sdf.format(date);

        return strDate;
    }

    /**
     * Format the current date/time according to the specified pattern.
     *
     * @param pattern - a <code>SimpleDateFormat</code> date/time pattern
     * @return a date and or time formatted according to the specified pattern
     * @throws IllegalArgumentException if pattern is not recognized
     */
    public String format(String pattern) throws IllegalArgumentException {
        String strDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        strDate = sdf.format(new Date());
        return strDate;
    }

    /**
     * Format a date and/or time string according to the specified pattern.
     *
     * @param dateString - a <code>String</code> representation of a date and/or
     * time
     * @param pattern - a <code>SimpleDateFormat</code> date/time pattern
     * @return a date and/or time formatted according to the specified pattern
     * @throws IllegalArgumentException if pattern is not recognized
     * @throws ParseException if date string cannot be parsed as a date
     */
    public String format(String dateString, String pattern)
            throws ParseException, IllegalArgumentException {

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(dateString);
        String strDate = sdf.format(date);

        return strDate;
    }

    /**
     * Attempts to convert a String representation of a date to a java.util.Date
     * object. Conversion rules are based on parse definitions in the
     * java.text.DateFormat class.
     *
     * @param dateString - a string representation of a date and/or time
     * @return a java.util.Date object
     * @throws IllegalArgumentException if the date string cannot be parsed.
     */
    public Date toDate(String dateString)
            throws IllegalArgumentException {
        Date date = null;
        DateFormat df = DateFormat.getDateInstance();
        try {
            df = DateFormat.getDateInstance(DateFormat.SHORT);
            date = df.parse(dateString);
        } catch (Exception e) {
            try {
                df = DateFormat.getDateInstance(DateFormat.MEDIUM);
                date = df.parse(dateString);
            } catch (Exception e2) {
                try {
                    df = DateFormat.getDateInstance(DateFormat.LONG);
                    date = df.parse(dateString);
                } catch (Exception e3) {
                    try {
                        df = DateFormat.getDateInstance(DateFormat.FULL);
                        date = df.parse(dateString);
                    } catch (Exception e4) {
                        throw new IllegalArgumentException(e4.getMessage());
                    }
                }
            }
        }
        return date;
    }

    /**
     * Calculate the difference, in DateUtilitities field units, for any two
     * <code>Calendar</code> objects
     *
     * @param dateUnit - an enum representing a unit of measure in milliseconds
     * (e.g., a day is 1000L * 60L * 60L * 24L ms, etc.)
     * @param firstDate - a <code>Calendar</code> object
     * @param secondDate - a <code>Calendar</code> object
     * @return the difference in DateUtilities units as a positive whole number
     * @throws IllegalArgumentException if any argument is invalid
     */
    public int dateDiff(DateUnit dateUnit, Calendar firstDate, Calendar secondDate)
            throws IllegalArgumentException {
        long diff = Math.abs(firstDate.getTimeInMillis() - secondDate.getTimeInMillis());
        double diffAmt = (double) diff / dateUnit.getMilliseconds();

        return (int) Math.round(diffAmt);
    }

    /**
     * Calculate the difference, in DateUtilitities field units, for any two
     * <code>Calendar</code> objects using JDK8+ Date/Time API.
     *
     * @param dateUnit - an enum representing a unit of measure in milliseconds
     * (e.g., a day is 1000L * 60L * 60L * 24L ms, etc.)
     * @param firstDate - a <code>Calendar</code> object
     * @param secondDate - a <code>Calendar</code> object
     * @return the difference in DateUtilities units as a positive whole number
     * @throws IllegalArgumentException if any argument is invalid
     */
    public int dateDiff8(DateUnit dateUnit, Calendar firstDate, Calendar secondDate)
            throws IllegalArgumentException {

        // Convert Calendars to LocalDateTime objects
        LocalDateTime startDate = LocalDateTime.ofInstant(firstDate.toInstant(), ZoneId.systemDefault());
        LocalDateTime endDate = LocalDateTime.ofInstant(secondDate.toInstant(), ZoneId.systemDefault());
        Duration diff = Duration.between(startDate, endDate);
        int value;

        switch (dateUnit) {
            case DAY:
                value = (int) diff.toDays();
                break;

            case HOUR:
                value = (int) diff.toHours();
                break;

            case MINUTE:
                value = (int) diff.toMinutes();
                break;

            case SECOND:
                value = (int) (diff.toMillis() / 1000L);
                break;

            default:
                value = (int) diff.toHours();
        }

        return value;
    }

    /**
     * Convenience method that chooses the best API (JDK8+ or earlier) for doing
     * Date difference calculations.
     *
     * @param dateUnit - an enum representing a unit of measure in milliseconds
     * (e.g., a day is 1000L * 60L * 60L * 24L ms, etc.)
     * @param startDate - a date representing the start of a time period
     * @param endDate - a date representing the end of a time period
     * @return the difference in DateUtilities units as a positive whole number
     * @throws IllegalArgumentException if any argument is invalid
     */
    public int getDateDiff(Calendar startDate, Calendar endDate, DateUnit dateUnit)
            throws IllegalArgumentException {
        // Should look something like 1.8.0_45
        String javaVersion = System.getProperty("java.version");
        String majorVersion = "" + javaVersion.charAt(2);
        int result;

        if (Integer.parseInt(majorVersion) >= 8) {
            result = this.dateDiff8(dateUnit, startDate, endDate);
        } else {
            result = this.dateDiff(dateUnit, startDate, endDate);
        }

        return result;
    }

    /*
     * Test harness -- comment out in production
     * @param args - not used
     */
//    public static void main(String[] args) throws ParseException, IllegalArgumentException {
//        // Get Singleton instance
//        DateUtilities dateUtilities = DateUtilities.getInstance();
//
//        Date date = new Date();
//        Calendar firstDate = Calendar.getInstance();
//        Calendar secondDate = Calendar.getInstance();
//        secondDate.add(Calendar.MONDAY, 2);
//
//        System.out.println("First Date: " + dateUtilities.toString(firstDate));
//        System.out.println("Second Date: " + dateUtilities.toString(secondDate));
//
//        // Old Date/Time API
//        System.out.println("Difference in Hours: "
//                + dateUtilities.dateDiff(DateUnit.HOUR, firstDate, secondDate));
//        System.out.println("Difference in Days: "
//                + dateUtilities.dateDiff(DateUnit.DAY, firstDate, secondDate));
//
//        // New (JDK8+) Date/Time API
//        System.out.println("\nDifference in Hours: "
//                + dateUtilities.dateDiff8(DateUnit.HOUR, firstDate, secondDate));
//        System.out.println("Difference in Days: "
//                + dateUtilities.dateDiff8(DateUnit.DAY, firstDate, secondDate));
//
//        // Universal Date/Time API
//        System.out.println("\nDifference in Hours: "
//                + dateUtilities.getDateDiff(firstDate, secondDate, DateUnit.HOUR));
//        System.out.println("Difference in Days: "
//                + dateUtilities.getDateDiff(firstDate, secondDate, DateUnit.DAY));
//
//    }

}
