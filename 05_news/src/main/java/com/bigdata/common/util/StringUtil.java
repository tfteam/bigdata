package com.bigdata.common.util;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.regex.Pattern;

public class StringUtil {
	/**
	 * 形成短字符串
	 * @param content
	 * @param count
	 * @return
	 */
	public static String genShortStr(String content, int count) {
		if (content.length() > count) {
			return content.substring(0, count) + "...";
		} else {
			return content;
		}
	}
	
	/**
	 * 判断字符串中是否含有中文
	 * @param str
	 * @return
	 */
	public static boolean hasChinese(String str) {
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			String test = str.substring(i, i + 1);
			if (test.matches("[\\u4E00-\\u9FA5]+")) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * 将UTF-8编码的字符串转换成ISO-8859-1
	 * @param input
	 * @return
	 * @throws java.io.UnsupportedEncodingException
	 */
	public static String utf8ToISO8859(String input)
			throws UnsupportedEncodingException {
		return new String(input.getBytes("UTF-8"), "ISO-8859-1");
	}

	/**
	 * 生成32位的唯一随机数
	 * @return
	 */
	public String getUuidString() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 将小时的数字形式转换成字符串类型（09：00）
	 * @param num
	 * @return
	 */
	public static String numTransStr(int num) {
		int numTmp = num % 24;
		return ((numTmp < 10) ? "0" : "") + String.valueOf(numTmp) + ":00";
	}
	
	/**
	 * 判断字符串数字是否浮点类型
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isFloatNum(String num) {
		Pattern pattern = Pattern.compile("[0-9]*(\\.?)[0-9]*");
		return pattern.matcher(num).matches();
	}

	/**
	 * 判断字符串数字是否非负整数
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isIntegerNum(String num) {
		Pattern pattern = Pattern.compile("^\\d+$");
		return pattern.matcher(num).matches();
	}

    /**
     * 把HashMap转换成String
     */
    public static String hashMapToString(HashMap map){
        StringBuffer string = new StringBuffer("{");
        for (Iterator its = map.entrySet().iterator(); its.hasNext(); ) {
            Entry e = (Entry) its.next();
            string.append("'");
            string.append(e.getKey());
            string.append(":");
            string.append("'");
            string.append(e.getValue());
            string.append("',");
        }
        return string.substring(0, string.lastIndexOf(",")) + "}";
    }
}
