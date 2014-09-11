package com.bigdata.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * 将时间类型转换为字符串
	 * 
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static String formatDate(Object date, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	}

    /**
     * 获取当前时间
     * 不显示毫秒
     * @return
     * */
    public static Timestamp getCurrentData(){
        String str = formatDate(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss");
        Timestamp now = strToTimestamp(str);
        return now;
    }


	/**
	 * 将字符串转换为Timestamp类型
	 * @param dateStr
	 * @return
	 */
	public static Timestamp strToTimestamp(String dateStr) {
		DateFormat format = new SimpleDateFormat(com.bigdata.common.constants.Constants.DateFormat.yyyyMMdd);
		Timestamp ts = null;
		try {
			ts = new Timestamp(format.parse(dateStr).getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ts;
	}
	
	/**
	 * 获得离当前时间相隔多少天的时间
	 * @param diff
	 * @return
	 */
	public static Date getDate(int diff) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, diff);
		return c.getTime();
	}

    public static Timestamp getTimestamp(int diff) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, diff);
        Timestamp time = new Timestamp(calendar.getTimeInMillis());
        return time;
    }
	
	/**
	 * 计算start与 end的时间差距
	 * @param start
	 * @param end
	 * @return
	 */
	public static String diff(long start, long end) {
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		long ns = 1000;
		long diff = end - start;
		if (diff >= nd) { // 天
			return (diff / nd) + "天";
		} else if (diff >= nh) { // 小时
			return (diff % nd / nh) + "小时";
		} else if (diff >= nm) { // 分钟
			return (diff % nd % nh / nm) + "分钟";
		} else {
			return (diff % nd % nh % nm / ns) + "秒";
		}
	}
	
	/**
	 * 计算start与 end的时间差距字符串
	 * @param start
	 * @param end
	 * @return
	 */
	public static String diffStr(long start, long end) {
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		long ns = 1000;
		long diff = end - start;
		
		long day = diff / nd;
		long hour = diff / nh - day * 24;
		long min = diff / nm - day * 24 * 60 - hour * 60;
		long sec = diff / ns - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60;
		
		if (diff >= nd) { // 天
			return day + "天" + hour + "小时" + min + "分钟" + sec + "秒";
		} else if (diff >= nh) { // 小时
			return hour + "小时" + min + "分钟" + sec + "秒";
		} else if (diff >= nm) { // 分钟
			return min + "分钟" + sec + "秒";
		} else {
			return sec + "秒";
		}
	}
	
	/**
	 * 将数字转换成汉字
	 * @param num
	 * @return
	 */
	public static String numberToCh(int num) {
		String numCh = "";
		switch (num) {
			case 1: numCh = "一"; break;
			case 2: numCh = "二"; break;
			case 3: numCh = "三"; break;
			case 4: numCh = "四"; break;
			case 5: numCh = "五"; break;
			case 6: numCh = "六"; break;
			case 7: numCh = "日"; break;
		}
		return numCh;
	}
}
