package com.bigdata.common.util;

import java.io.File;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Util {
	/**
	 * 动态获得对象的字段类型
	 * 
	 * @param object
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public static String getFieldType(Object object, String field)
			throws Exception {
		return object.getClass().getDeclaredField(field).getType()
				.getSimpleName();
	}
	
	/**
	 * 获得数据库表在对象里的映射字段名
	 * @param column
	 * @return
	 */
	public static String getColumn2Field(String column) {
		String[] words = column.split("_");
		int length = words.length;
		String field = words[0];
		for (int i = 1; i < length; i++) {
			field += words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
		}
		return field;
	}

	/**
	 * 动态获得对象里面的字段值
	 * 
	 * @param object
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public static Object getObjectField(Object object, String field)
			throws Exception {
		String methodName = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
		Method method = object.getClass().getDeclaredMethod(methodName);
		return method.invoke(object);
	}
	
	public static void setObjectField(Object object, String field, Object value)
		throws Exception {
		String methodName = "set" + getColumn2Field(field);
		Class<?>[] argsClasses = new Class<?>[] {Object.class};
		Method method = object.getClass().getDeclaredMethod(methodName, argsClasses);
		method.invoke(object, new Object[]{value});
	}
	
	/**
	 * 把字节单位转换成KB 或 MB
	 * 
	 * @param smallUnit
	 * @return
	 */
	public static String byteToBigUnit(long smallUnit) {
		String bigUtilStr = "";
		if (smallUnit < 1024) {
			bigUtilStr = smallUnit + "B";
		} else if ((smallUnit >= 1024) && (smallUnit < 1048576)) {
			BigDecimal bdTmp = new BigDecimal(smallUnit / 1024).setScale(2,
					BigDecimal.ROUND_HALF_UP);
			bigUtilStr = bdTmp.floatValue() + "KB";
		} else if (smallUnit >= 1048576) {
			BigDecimal bdTmp = new BigDecimal(smallUnit / 1048576).setScale(2,
					BigDecimal.ROUND_HALF_UP);
			bigUtilStr = bdTmp.floatValue() + "MB";
		}
		return bigUtilStr;
	}

	/**
	 * 获得文件夹大小
	 * 
	 * @param file
	 * @return
	 */
	public static long recursionFileList(File file) {
		long size = 0;
		if (file.isFile()) {
			size = file.length();
		} else if (file.isDirectory()) {
			File files[] = file.listFiles();
			if (files == null) {
				return size;
			}
			for (int i = 0; i < files.length; i++) {
				size += recursionFileList(files[i]);
			}
		}
		return size;
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
	 * 获得NUM % mod后的字符串format格式
	 * @param num
	 * @param mod
	 * @return
	 */
	public static String getModNum(String format, long num, int mod) {
		DecimalFormat df = new DecimalFormat(format);
		return df.format(num % mod);
	}
}
