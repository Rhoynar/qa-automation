package com.rhoynar.qa.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Harsh on 9/14/16.
 */
public class DateTime {

    public static String getTodaysDate()
    {
        //Calendar today = Calendar.getInstance();
        Date today = new Date();
        SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy");
        return fmt.format(today);
    }

    public static String getPastDate(int input)
    {
        Calendar past = Calendar.getInstance();
        past.add(Calendar.DAY_OF_YEAR, -input);
        SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy");
        Date pastDate = past.getTime();
        return fmt.format(pastDate);
    }

    public static String getFutureDate(int input)
    {
        Calendar past = Calendar.getInstance();
        past.add(Calendar.DAY_OF_YEAR, input);
        SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy");
        Date pastDate = past.getTime();
        return fmt.format(pastDate);
    }
}
