package com.bigdata.common.util;

import java.math.BigDecimal;

public class NumberUtil {
	/**
	 * 将double类型转换为float类型
	 * @param number
	 * @return
	 */
	public static float double2Float(double number) {
		BigDecimal bd = new BigDecimal(number).setScale(2,
				BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}
	
	/**
	 * 判断是否是整形字符串
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {
		return str.matches("[\\d]+");
	}
}
