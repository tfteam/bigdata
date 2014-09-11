package com.bigdata.common.newutil;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by log on 14-9-10.
 */
public class DateUtil {
    public static Date getDateFromText(int year, int month, int day, int hour, int min) {
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day, hour, min);
        Date date = cal.getTime();
        return date;
    }
    public static Date TimeStamp2Date(String timestampString){
        Long timestamp = Long.parseLong(timestampString)*1000;
        Date date = new Date(timestamp);
        return date;
    }
}
