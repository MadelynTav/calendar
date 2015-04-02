package nyc.c4q.ac21.calendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;


public class Holidays {

    /**
     * Loads holidays from a file.
     *
     * @param holidayType The type of holiday.  Use "National holiday" for U.S. federal holidays.
     * @return A map from date to holiday name for holidays.
     */
    public static HashMap<Calendar, String> getHolidays(String holidayType) {
        ArrayList<String> lines = FileTools.readLinesFromFile("holidays.csv");

        HashMap<Calendar, String> holidays = new HashMap<Calendar, String>();
        for (String line : lines) {
            String[] holidayLine = line.split(",");
            String date = holidayLine[0];
            String name = holidayLine[1];
            String type = holidayLine[2];

            if(type.equals(holidayType)) {
                holidays.put(DateTools.parseDate(date), name);
            }
        }
        return holidays;
    }

}



