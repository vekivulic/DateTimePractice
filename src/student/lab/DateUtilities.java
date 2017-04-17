
package student.lab;

import java.time.Duration;

import java.time.LocalDateTime;
import java.time.LocalTime;

import java.time.format.DateTimeFormatter;

import java.time.format.FormatStyle;
import java.time.temporal.Temporal;

/**
 * Converting formatted strings to Local Date/Time objects and performing Date/Time
 * arithmetic duration to get difference in minutes 
 *
 * @author Veki Vulic, vvulic@my.wctc.edu
 * @version 1.00
 * @since 1.8
 */
public final class DateUtilities {

    Temporal startingTemporalObject;
    Temporal endingTemporalObject;

    
    
    /**
     * default 
     */
    public DateUtilities() {
    
    }

    /**
     *A convenience constructor that allows you to 
     * set value for starting and ending TemporalObject;
     * @param startingTemporalObject the starting Temporal Object 
     * @param endingTemporalObject the ending Temporal Object 
     */
    public DateUtilities(Temporal startingTemporalObject,Temporal endingTemporalObject) {
        setStartingTemporalObject(startingTemporalObject);
        setEndingTemporalObject(endingTemporalObject);
    }

    /** 
     * Gets starting <bold> Temporal<bold> object 
     * 
     * @return starting Temporal object as current local time
     */
    public Temporal getStartingTemporalObject() {
        return startingTemporalObject = LocalTime.now();
    }

    /**
     * Modifies and sets starting <bold> Temporal </bold> object 
     * @param startingTemporalObject mandatory value for starting Temporal object 
     */
    
    public void setStartingTemporalObject(Temporal startingTemporalObject)throws IllegalArgumentException {
        if (startingTemporalObject == null ) {
            throw new IllegalArgumentException("Starting temporal object can not be null");
        } 
        this.startingTemporalObject = startingTemporalObject;
    }

     /** 
     * Gets ending <bold> Temporal<bold> object 
     * 
     * @return ending Temporal object as current local time plus additional 38 minutes
     */
     public Temporal getEndingTemporalObject() {
        return endingTemporalObject = LocalTime.now().plusMinutes(36);
    }

     
     
    /**
     * Modifies and sets ending <bold> Temporal </bold> object 
     * @param endingTemporalObject mandatory value ending Temporal object 
     */ 
    public void setEndingTemporalObject(Temporal endingTemporalObject) throws IllegalArgumentException {
        if (endingTemporalObject == null ) {
            throw new IllegalArgumentException("Ending temporal object can not be null");
        } 
        this.endingTemporalObject = endingTemporalObject;
    }

    
    /**
     * Format a Local Date and Time  according to the default date pattern for the
     * current locale
     * 
     * @param local a local date and time object 
     * @param format a date format object 
     * @return  a date and or time formatted according to the specified pattern
     * @throws IllegalArgumentException if date and time is null or empty 
     */
    
    public String toStringLocalDateAndTime(LocalDateTime local, String format) throws IllegalArgumentException {
        if (local == null || local.isAfter(local) || format.isEmpty()) {
            throw new IllegalArgumentException("Local time can not be null, and formator can not be empty");
        }
        DateTimeFormatter formator = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        return formator.format(LocalDateTime.now());

    }

    /** 
     * Calculates the difference in minutes, using Duration, for starting 
     * TemperalObject and ending TemperalObject using getters and setters  
     * 
     * @return the duration difference in minutes 
     * @throws IllegalArgumentException 
     */
    public Duration timeDifferenceInMinutes() throws IllegalArgumentException {
        if (startingTemporalObject == null || endingTemporalObject == null) {
            throw new IllegalArgumentException("Starting and ending temporal objects can not be null");
        }
        Duration difference = Duration.between(getStartingTemporalObject(), getEndingTemporalObject());
        return Duration.ofMinutes(difference.toMinutes());
    }

    /** 
     * Calculates the duration difference, for starting TemperalObject and 
     * ending TemperalObject 
     * 
     * @param startingTemporalObject representing <strong> Temporal</strong> starting object   
     * @param endingTemporalObject representing <bold> Temporal </bold> ending object 
     * @return duration difference formatted to minutes 
     * @throws IllegalArgumentException if temporal start and end object is null or empty 
     */
    
    
    public Duration timeDurationDifferenceInMinutes(Temporal startingTemporalObject, Temporal endingTemporalObject) throws
            IllegalArgumentException {
        if (startingTemporalObject == null || endingTemporalObject == null) {
            throw new IllegalArgumentException("Only valid LocalTime objects "
                    + "accepted. ");
        }
        Duration difference = Duration.between(startingTemporalObject,
                endingTemporalObject);
        return Duration.ofMinutes(difference.toMinutes());
    }

}
