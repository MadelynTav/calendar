package nyc.c4q.ac21.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Daylight Savings Time (DST) computations.
 */
public class DST {

    /**
     * Populates hash maps with the start and end time for DST in each year.
     * @param startDates
     *   A hash map of the start date of DST in each year.
     * @param endDates
     *   A hash map of the end date of DST in each year.
     */
    public static void getDSTDates(HashMap<Integer, Calendar> startDates, HashMap<Integer, Calendar> endDates) {
        ArrayList<String> lines = FileTools.readLinesFromFile("dst.csv");
        // FIXME: Write this code!
        // Each line in the file is of the form "start,end", where both dates
        // are in the same year.  This represents the dates DST starts and
        // ends in this year.
        //
        // Use DateTools.parseDate.
        int beginYear = 1980;
        for (String line: lines) {
            int comma = line.indexOf(',');
            String startDate = line.substring(0, comma);
            String endDate = line.substring(comma + 1);
            startDates.put(beginYear, DateTools.parseDate(startDate));
            endDates.put(beginYear, DateTools.parseDate(endDate));
            beginYear += 1;
        }

    }

    /**
     * Returns true if 'date' is during Daylight Savings Time.
     * @param date
     *   The date to check.
     * @return
     *   True if DST is in effect on this date.
     */
    public static boolean isDST(Calendar date) {
        // Create hash maps to contain the start and end dates for DST in each year.
        HashMap<Integer, Calendar> dstStartDates = new HashMap<Integer, Calendar>();
        HashMap<Integer, Calendar> dstEndDates = new HashMap<Integer, Calendar>();
        // Populate them.
        DST.getDSTDates(dstStartDates, dstEndDates);

        // FIXME: Write this code!
        int year = date.get(Calendar.YEAR);
        if (date.after(dstStartDates.get(year)) && date.before(dstEndDates.get(year))) {
            return true;
        } else if (date.equals(dstStartDates.get(year)) || date.equals(dstEndDates.get(year))) {
            return true;
        }
        return false;  // Change this!
    }

}

