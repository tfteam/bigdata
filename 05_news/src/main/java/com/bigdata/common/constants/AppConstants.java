package com.bigdata.common.constants;

import com.bigdata.common.constants.Constants.StringDelimiter;

public interface AppConstants {
	
	interface AppConstant {
		public static String App_Key = "12246851"; // 正式
		public static String App_Secret_Key = "a0e73da1e378807d6567d545a92ac593"; // 正式
		public static String Api_Service_Url = "http://gw.api.taobao.com/router/rest"; // 正式
		//public static String Container_Url = Constants.PRODUCT_CONTAINER_URL; // 正式
		public static String Auth_Code_Url = "https://oauth.taobao.com/authorize?"; // 正式
		public static String Auth_Token_Url = "https://oauth.taobao.com/token"; // 正式
		public static String Refresh_Token_Url = "http://container.open.taobao.com/container/refresh"; // 正式
		public static String Item_Url = "http://item.taobao.com/item.htm?id="; // 正式
		public static String Web_Root_Dir_Path = "D:/isv/show/WebRoot/ROOT/"; // 正式
		public static String App_Redirect_Uri = "http://expert.henrysoftware.com/app/forward.htm"; // 正式
		
//		public static String App_Key = "1012246851"; // 沙箱
//		public static String App_Secret_Key = "sandbox1e378807d6567d545a92ac593"; // 沙箱
//		public static String Api_Service_Url = "http://gw.api.tbsandbox.com/router/rest"; // 沙箱
//		public static String CONTAINER_URL = Constants.SANDBOX_CONTAINER_URL; // 沙箱
//		public static String Auth_Code_Url = "https://oauth.tbsandbox.com/authorize?"; // 沙箱
//		public static String Auth_Token_Url = "https://oauth.tbsandbox.com/token"; // 沙箱
//		public static String Refresh_Token_Url = "http://container.open.tbsandbox.com/container/refresh"; // 沙箱
//		public static String Item_Url = "http://item.tbsandbox.com/item.htm?id="; // 沙箱
//		public static String Web_Root_Dir_Path = "F:/taobao/show/branches/show_20121015_0142/WebRoot/ROOT/"; // 沙箱
//		public static String App_Redirect_Uri = "http://expert:8080/app/forward.htm"; // 沙箱
		
		public static String Top_Session = "TOP_SESSION";
		public static String No_Pic_Url = "/images/no_pic.gif";
		public static String Validate_Code = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		
		public static String AUTH_FIELD_client_id = "client_id";
		public static String AUTH_FIELD_response_type = "response_type";
		public static String AUTH_FIELD_redirect_uri = "redirect_uri";
		public static String AUTH_FIELD_scope = "scope";
		public static String AUTH_FIELD_state = "state";
		
		public static String AUTH_FIELD_code = "code";
		public static String AUTH_FIELD_error = "error";
		public static String AUTH_FIELD_error_description = "error_description";
		public static String AUTH_FIELD_client_secret = "client_secret";
		public static String AUTH_FIELD_grant_type = "grant_type";
		
		public static String AUTH_FIELD_taobao_user_id = "taobao_user_id";
		public static String AUTH_FIELD_taobao_user_nick = "taobao_user_nick";
		public static String AUTH_FIELD_sub_taobao_user_id = "sub_taobao_user_id";
		public static String AUTH_FIELD_sub_taobao_user_nick = "sub_taobao_user_nick";
		
		public static String AUTH_FIELD_refresh_token = "refresh_token";
		public static String AUTH_FIELD_access_token = "access_token";
		public static String AUTH_FIELD_expires_in = "expires_in";
		public static String AUTH_FIELD_re_expires_in = "re_expires_in";
		public static String AUTH_FIELD_r1_expires_in = "r1_expires_in";
		public static String AUTH_FIELD_r2_expires_in = "r2_expires_in";
		public static String AUTH_FIELD_w1_expires_in = "w1_expires_in";
		public static String AUTH_FIELD_w2_expires_in = "w2_expires_in";
		
		public static String AUTH_SCOPE_R1 = "r1";
		public static String AUTH_SCOPE_R2 = "r2";
		public static String AUTH_SCOPE_W1 = "w1";
		public static String AUTH_SCOPE_W2 = "w2";
		public static String AUTH_SCOPE = AUTH_SCOPE_R1 + StringDelimiter.COMMA + AUTH_SCOPE_R2 + StringDelimiter.COMMA 
			+ AUTH_SCOPE_W1 + StringDelimiter.COMMA + AUTH_SCOPE_W2;
		
		public static String Auth_Url = Auth_Code_Url
			+ AUTH_FIELD_client_id + StringDelimiter.EQUALS + App_Key + StringDelimiter.AMPERSAND
			+ AUTH_FIELD_response_type + StringDelimiter.EQUALS + AUTH_FIELD_code + StringDelimiter.AMPERSAND
			+ AUTH_FIELD_redirect_uri + StringDelimiter.EQUALS + App_Redirect_Uri + StringDelimiter.AMPERSAND
			+ AUTH_FIELD_scope + StringDelimiter.EQUALS + AUTH_SCOPE;
		
		public static String AUTH_ERROR_DESCRIPTION_authorize_reject = "authorize reject";
		public static String AUTH_ERROR_DESCRIPTION_need_purchase = "Application " + App_Key + " need purchase";
		
		public static String App_Title = "行情专家";
		public static String App_Permission_Name = "行情专家";
		public static String User_Detail_DO = "USER_DETAIL_DO";
		public static String VIPS = "VIPS";
		public static String My_Time = "2000-01-01 00:00:00";
		public static int Lately_User_Count = 8;
		public static int Batch_Operation_Count = 500;
		
		public static int DISCOUNT_TYPE_price = 1;
		public static int DISCOUNT_TYPE_discount = 2;
		
		public static int Pagination_Count = 3;
		public static int Count_One_Page = 20;
		public static int Top_First_Page = 1;
		public static int Top_Default_Count = 40;
		public static int Top_Max_Count = 200;
		public static int Query_Time = 2;
		public static int Accept_Error_Num = 5;
		public static String App_Service_Id = "9616";
		
		public static int UserType_Main = 0;
		public static int UserType_Sub = 1;
	}
	
	interface AppStatus {
		public static int XUDING = 0;
		public static int DINGGOU = 1;
		public static int DETAIL = 2;
		public static int LOGIN = 3;
		public static int NEED_UPGRADE = 4;
		public static int NO_PERMISSION = 5;
	}
	
	/**
	 * 订购常量 itemCode:ts-11336-4xx,cycleNum:3,cycleUnit:2;
	 * SubscribeConstant.SUBSCRIBE_URL + SubscribeConstant.SUBPARAMS_itemCode + StringDelimiter.COLON + AppVersionCode.STANDARD_EXT
	 * + StringDelimiter.COMMA + SubscribeConstant.SUBPARAMS_cycleNum + StringDelimiter.COLON + SubscribeConstant.SUBSCRIBE_MONTH_12
	 * + StringDelimiter.COMMA + SubscribeConstant.SUBPARAMS_cycleUnit + StringDelimiter.COLON + SubscribeConstant.SUBSCRIBE_cycleUnit
	 * + StringDelimiter.SEMICOLON;
	 */
	interface SubscribeConstant {
		String SUBSCRIBE_URL = "http://fuwu.taobao.com/ser/assembleParam.htm?activityCode=&promIds=&subParams=";
		String SUBPARAMS_itemCode = "itemCode";
		String SUBPARAMS_cycleNum = "cycleNum";
		String SUBPARAMS_cycleUnit = "cycleUnit";

		String SUBSCRIBE_MONTH_1 = "1";
		String SUBSCRIBE_MONTH_3 = "3";
		String SUBSCRIBE_MONTH_6 = "6";
		String SUBSCRIBE_MONTH_12 = "12";
		String SUBSCRIBE_cycleUnit = "2";
	}
	
	/**
	 * 应用版本代码
	 * @author Administrator
	 *
	 */
	interface AppVersionCode {
		int SUBSCRIBE_FAIL_FREE_DAY = 3; // 订购失败，第一次登录时当前时间+3天
		String ALL = "ts-9616";
		String FREE = "ts-9616-1"; // 免费
		String STANDARD = "ts-9616-4"; // 标准
		String ADVANCED = "advanced"; // 高级
		String FREE_TO_STANDARD = "f-to-s"; // 免费 TO 高级
		String MODULE_RECOMMEND = "ts-9616-3"; // 推荐模块
		String STANDARD_EXT = "ts-9616-4xx"; // 标准扩展，跟中级一样
		
		String FREE_NAME = "初级版";
		String STANDARD_NAME = "标准版";
		String ADVANCED_NAME = "高级版";
		String MODULE_NAME_RECOMMEND = "关联推荐模块";
		String STANDARD_EXT_NAME = "标准版";
	}
	
	/**
	 * TOP相关常量
	 * @author Administrator
	 *
	 */
	interface TopConstant {
		int TOP_FIRST_PAGE = 1;
		int TOP_COUNT_10 = 10;
		int TOP_COUNT_20 = 20;
		int TOP_DEFAULT_COUNT = 40;
		int TOP_MAX_COUNT_100 = 100;
		int TOP_MAX_COUNT_200 = 200;
		int TOP_USER_COUNT = 40;
		
		int API_CALL_LIMIT_COUNT_20 = 20;
		int API_CALL_LIMIT_COUNT_50 = 50;
		int API_CALL_LIMIT_COUNT_100 = 100;
		int QUERY_TIME = 2;
		int ACCEPT_ERROR_NUM = 5;
		
		String TAG_FIELDS = "tag_id,tag_name";
		String USER_FIELDS = "user_id,nick,sex,buyer_credit.level,location,vip_info";
		String ITEM_FIELDS = "num_iid,detail_url,title,price,num,pic_url,seller_cids";
		String ITEM_FIELDS_ITEM_ID = "num_iid,title,nick";
		String ITEM_LIST_FIELDS = "num_iid,detail_url,title,price,num,pic_url";
	}
	
	/**
	 * 淘宝相关常量
	 * @author Administrator
	 *
	 */
	interface TaobaoConstant {
		int TAOBAO_ITEM_TITLE_MAX_LEN = 60;
	}
}
