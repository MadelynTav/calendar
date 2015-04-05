package nyc.c4q.ac21.calendar;

import java.util.Calendar;
import java.util.HashMap;

public class CalendarPrinter
{

    /**
     * Prints a calendar for a month.
     * <p/>
     * Prints the calendar in the traditional format with one week per line.
     * Each week starts on Sunday and shows the days of month for days in
     * that week.  The current date is marked with an asterisk.
     * <p/>
     * For example, for 2015-04-03, prints this:
     * <p/>
     * April 2015
     * 1   2   3*  4
     * 5   6   7   8   9  10  11
     * 12  13  14  15  16  17  18
     * 19  20  21  22  23  24  25
     * 26  27  28  29  30
     *
     * @param date The date containing the month to print.
     */
    public static void printMonthCalendar(Calendar date)
    {
        // FIXME: Write this.
        // Use these methods to help you:
        //   DateTools.getMonthNames()
        //   DateTools.getNextDay() to loop through days in the month.
        HashMap<Integer, String> getMonthNames = DateTools.getMonthNames();
       // int day = date.get(Calendar.DAY_OF_MONTH);
        String monthName = getMonthNames.get(date.get(Calendar.MONTH));
        int todayDate = date.get(Calendar.DATE);
        int year = date.get(Calendar.YEAR);
        int numDayInMonth = date.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println(monthName + " " + year);

        //Start calender at the first date and day of month
        date.set(Calendar.DAY_OF_MONTH, 1);
        int startDay = date.get(Calendar.DAY_OF_WEEK);

        //use for loops to space out dates accordingly
        for(int i = 1; i < startDay; i++)
        {
            System.out.print("    ");
        }

        for(int j = 1; j <= numDayInMonth; j++)
        {
            int currDate = date.get(Calendar.DATE);
            int stDay = date.get(Calendar.DAY_OF_WEEK);
            String calDay = String.valueOf(currDate);

            //if the date is a single digit use TWO whitespaces to be aligned
            if(currDate < 10)
            {
                calDay = " " + currDate;
            }

            if(currDate == todayDate)
            {   System.out.print(calDay + "* ");
                if(stDay == 7)//if current date is saturday, print on next line
                {
                    System.out.print("\n");
                }
            }  // if its a saturday, end line and print on the next line
            else if(stDay == 7)
            {
                System.out.print(calDay + "   \n");
            }
            else
            {
                System.out.print(calDay + "  ");
            }
            date.add(Calendar.DATE, 1);

        }


    }

}