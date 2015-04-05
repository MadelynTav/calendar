package nyc.c4q.ac21.calendar;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.swing.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which date would you like to know more about? ");
        String dateString = scanner.nextLine();
        Calendar date = DateTools.parseDate(dateString);
        if (date == null)
            return;
        System.out.println();

        System.out.println("Date: "+ DateTools.formatDate(date));

        // FIXME: Write the rest of this method!

        // 1. Show the day of the week.
        HashMap<Integer, String> dayOfWeekNames = DateTools.getDayOfWeekNames();
        date.get(Calendar.DAY_OF_WEEK);
        System.out.print("Day of the Week: "+ dayOfWeekNames.get(date.get(Calendar.DAY_OF_WEEK))+"\n");



        // 2. Show whether this is a work day.
       HashMap<Integer, Boolean> workDays = WorkDays.getWorkDays();
        boolean isWorkDay = workDays.get(date.get(Calendar.DAY_OF_WEEK));
        System.out.println("Work Day :"+ isWorkDay);

        // ...

        // 3. Show whether this is a national holiday, and if so, which.
        HashMap<Calendar, String> holidays = Holidays.getHolidays("National holiday");
        // ...
        System.out.println("National holiday: " + holidays.get(date));
        // 4. Show whether this date is in DST.
        boolean isDST = DST.isDST(date);
        System.out.println("Is DST:            " + isDST);
        // ...
        // ...

        // 5. Show the zodiac sign.
        String zodiacSign = Zodiac.getZodiacSign(date);
        System.out.println("Zodiac sign: "+zodiacSign);
        System.out.println("\n");
        // ...

        // 6. Print out the monthly calendar.
        CalendarPrinter.printMonthCalendar(date);

    }
}
