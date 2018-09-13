package company.info.com.weather.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        String todaysDate = formatter.format(cal.getTime());
        System.out.println("Current Date    : " + todaysDate);
        return todaysDate;
    }

    public static String getPreviousDate(int howMuch) {
         Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, howMuch);
        String previousDate = formatter.format(cal.getTime());
        System.out.println("Previous Date   : " + previousDate);
        return previousDate;
    }

    public static String getPreviousDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String previousDate = formatter.format(cal.getTime());
        System.out.println("Previous Date   : " + previousDate);
        return previousDate;
    }

}
