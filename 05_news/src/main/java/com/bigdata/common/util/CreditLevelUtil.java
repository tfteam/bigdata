package com.bigdata.common.util;

public class CreditLevelUtil {
	public static String getCreditLevel(int level) {
		switch (level) {
		case 0:
			return "1心";
		case 1:
			return "1心";
		case 2:
			return "2心";
		case 3:
			return "3心";
		case 4:
			return "4心";
		case 5:
			return "5心";
		case 6:
			return "1钻";
		case 7:
			return "2钻";
		case 8:
			return "3钻";
		case 9:
			return "4钻";
		case 10:
			return "5钻";
		case 11:
			return "1冠";
		case 12:
			return "2冠";
		case 13:
			return "3冠";
		case 14:
			return "4冠";
		case 15:
			return "5冠";
		case 16:
			return "1金冠";
		case 17:
			return "2金冠";
		case 18:
			return "3金冠";
		case 19:
			return "4金冠";
		case 20:
			return "5金冠";
		default:
			break;
		}
		return null;
	}
}
