package com.bigdata.common.constants;

public interface Constants {
	/**
	 * 数据库常量
	 * @author Administrator
	 */
	interface DBConstant {
		int LATELY_USER_COUNT = 8;
		int BATCH_OPERATION_COUNT = 1000;
		int COUNT_ONE_PAGE = 20;
		int SQL_RESULT = 1;
		
		String ORDER_ASC = "ASC";
		String ORDER_DESC = "DESC";
	}
	
	/**
	 * 字符串分隔符
	 * @author Administrator
	 */
	interface StringDelimiter {
		String COMMA = ","; // 逗号
		String SEMICOLON = ";"; // 分号
		String COLON = ":"; // 冒号
		String UNDERLINE = "_"; // 下划线
		String HYPHEN = "-"; // 中划线
		String AMPERSAND = "&";
		String POUND = "#";
		String EQUALS = "=";
		String STAR = "*";
		String DOT = "."; // 点号
		String QUESTION = "?"; // 问号
		String SPACE = " "; // 空格
		String AND = "&"; // &
		String AT = "@"; // @
		
		String SLASH = "/"; // 斜杠
		String BACK_SLASH = "\\"; // 反斜杠
	}

	/**
	 * 公用状态
	 * @author Administrator
	 */
	interface CommonStatus {
		int ALL = 100;
		int BLACKLIST = -2;
		int DELETED = -1;
		int NORMAL = 1;
		
		int SUCCESS = 1;
		int FAIL = 0;
		
		int YES = 1;
		int NO = 0;
	}
	
	/**
	 * 日期格式
	 * @author Administrator
	 */
	interface DateFormat {
		String yyyyMMdd_CH = "yyyy年MM月dd日";
		String yyyyMMdd_EN = "yyyy-MM-dd";
		String MMddHHmm_CH = "MM月dd日HH点mm分";
		String yyyyMMdd_HHmm = "yyyy-MM-dd HH:mm";
		String yyyyMMdd_HHmm00 = "yyyy-MM-dd HH:mm:00";
		String yyyyMMdd_000000 = "yyyy-MM-dd 00:00:00";
		String yyyyMMdd_HHmmss = "yyyy-MM-dd HH:mm:ss";
		String yyyyMMddHHmmss = "yyyyMMddHHmmss";
        String yyyyMMdd = "yyyy-MM-dd";
	}
	
	/**
	 * 取模常量
	 */
	interface ModConstant {
		int MOD_8 = 8;
		int MOD_24 = 24;
		int MOD_32 = 32;
		int MOD_64 = 64;
		int MOD_128 = 128;
		int MOD_256 = 256;
		int MOD_512 = 512;
		int MOD_1024 = 1024;
		
		String MOD_FORMAT_00 = "00";
		String MOD_FORMAT_0000 = "0000";
	}
	
	/**
	 * 日志常量
	 * @author Administrator
	 */
	interface LogConstant {
		int LOG_TYPE_BATCH_MODIFY_TITLE = 1;
		int LOG_TYPE_DESC_INSTALL = 2;
		int LOG_TYPE_DESC_UNINSTALL = 3;
		
		String LOG_FIELDS_ONSALE = "出售中的所有宝贝";
		String LOG_FIELDS_INSTOCK = "仓库中的所有宝贝";
		String LOG_FIELDS_SELF = "自己指定宝贝";
	}
	
	/**
	 * 批量操作常量
	 * @author Administrator
	 */
	interface BatchConstant {
		// 修改名称
		String TITLE_PREFIX = "prefix";
		String TITLE_SUFFIX = "suffix";
		String TITLE_REPLACE_FROM = "replaceFrom";
		String TITLE_REPLACE_TO = "replaceTo";
		String TITLE_MODIFY_LIST = "modifyTitleList";
		
		int TITLE_MODIFY_PRE_ITEM_COUNT = 100;
		String TITLE_MODIFY_FIELDS_ONSALE = "onsale";
		String TITLE_MODIFY_FIELDS_INSTOCK = "instock";
		String TITLE_MODIFY_FIELDS_SELFDEF = "self_def";
	
		String TitleError_OUT_OF_MAX_LENGTH = "超出标题最大长度60个字符。";
	}
}
