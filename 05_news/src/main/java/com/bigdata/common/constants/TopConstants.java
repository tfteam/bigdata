package com.bigdata.common.constants;

import com.bigdata.common.constants.Constants.StringDelimiter;

public interface TopConstants {
	
	interface SearchConstant {
		public static String NO_RELATED_RESULT = "KISSY.Suggest.callback({\"result\": []})";
		public static String HOT_SEARCH_RELATED_URL = "http://suggest.taobao.com/sug?code=utf-8&extras=1&callback=KISSY.Suggest.callback&q=";
		public static String HOT_SEARCH_CATEGORY_URL = "http://shuju.taobao.com/keyTop.htm?categoryId=";
		public static String HOT_SEARCH_TYPE_RELATED = "1";
		public static String HOT_SEARCH_TYPE_CATEGORY = "2";
		public static long[] HOT_SEARCH_CIDS = new long[]{16, 21, 27, 30, 1512, 1625, 1801, 50008165,
				50006843, 50006842, 50010388, 50013864, 50008090, 50002766, 50010404};
		public static String[] HOT_SEARCH_CATEGORIES = new String[]{
				"女装/女士精品",
				"居家日用/收纳/礼品",
				"装潢/灯具/五金/安防/卫浴",
				"男装",
				"手机",
				"女士内衣/男士内衣/家居服",
				"美容护肤/美体/精油",
				"童装/童鞋/孕妇装",
				"女鞋",
				"箱包皮具/热销女包/男包",
				"运动鞋",
				"饰品/流行首饰/时尚饰品新",
				"3C数码配件市场",
				"零食/坚果/茶叶/特产",
				"服饰配件/皮带/帽子/围巾"};
		public static String TAOBAO_SEARCH = "http://s.taobao.com/search?q=";
		public static int KEYWORDS_COUNT = 10;
	}
	
	/**
	 * 淘宝会员VIP对应常量
	 * c(普通会员)
	 * asso_vip(荣誉会员)
	 * exp_vip1, exp_vip2, exp_vip3, exp_vip4(四个等级的体验vip会员)
	 * vip1, vip2, vip3, vip4(四个等级的正式vip会员)
	 * 
	 * @author Administrator
	 */
	interface TaobaoVipConstant {
		String VIP_c = "c";
		String VIP_asso_vip = "asso_vip";
		String VIP_exp_vip1 = "exp_vip1";
		String VIP_exp_vip2 = "exp_vip2";
		String VIP_exp_vip3 = "exp_vip3";
		String VIP_exp_vip4 = "exp_vip4";
		String VIP_vip1 = "vip1";
		String VIP_vip2 = "vip2";
		String VIP_vip3 = "vip3";
		String VIP_vip4 = "vip4";
		
		String VIP_c_NAME = "普通会员";
		String VIP_asso_vip_NAME = "荣誉会员";
		String VIP_exp_vip1_NAME = "体验黄金会员";
		String VIP_exp_vip2_NAME = "体验白金会员";
		String VIP_exp_vip3_NAME = "体验钻石会员";
		String VIP_exp_vip4_NAME = "体验至尊会员";
		String VIP_vip1_NAME = "黄金会员";
		String VIP_vip2_NAME = "白金会员";
		String VIP_vip3_NAME = "钻石会员";
		String VIP_vip4_NAME = "至尊会员";
	}

	/**
	 * TOP开放平台短授权的范围
	 * taobao.marketing.promotion.add        设置商品定向优惠策略           更新营销活动（promotion） 
	 * taobao.marketing.promotion.update     更新商品定向优惠策略           更新营销活动（promotion） 
	 * taobao.promotion.coupon.add           创建店铺优惠券接口                更新营销活动（promotion） 
	 * taobao.ump.activity.add               新增优惠活动                               更新营销活动（promotion）
	 * taobao.ump.activity.update            修改活动信息                               更新营销活动（promotion）
	 * taobao.ump.detail.add                 新增活动详情                               更新营销活动（promotion） 
	 * taobao.ump.detail.list.add            营销详情添加                               更新营销活动（promotion） 
	 * taobao.ump.detail.update              修改活动详情                               更新营销活动（promotion） 
	 * taobao.ump.range.add                  添加活动范围                               更新营销活动（promotion） 
	 * taobao.crm.grade.set                  卖家设置等级规则                     更新店铺会员等级规则（usergrade）
	 * taobao.item.price.update              修改商品价格                               更新商品信息（item） 
	 * taobao.item.sku.price.update          修改商品sku价格                       更新商品信息（item）
	 */
	interface TopShortAuthScope {
		String SHORT_AUTH_URL = "short_auth_url";
		
		String SESS_PROMOTION_CRM = "sess_promotion_usergrade";
		String SESS_PROMOTION = "sess_promotion";
		String SESS_CRM = "sess_usergrade";
		
		String PROMOTION_CRM = TopShortAuthScope.PROMOTION 
			+ StringDelimiter.COMMA + TopShortAuthScope.CRM;
		String PROMOTION = "promotion";
		String CRM = "usergrade";
	}
	
	/**
	 * 宝贝在仓库中的状态
	 * @author Administrator
	 */
	interface ItemInvertoryStatus {
		String FOR_SHELVED = "for_shelved"; // 等待所有上架的
		String REGULAR_SHELVED = "regular_shelved"; // 定时上架
		String NEVER_ON_SHELF = "never_on_shelf"; // 从未上架
		String SOLD_OUT = "sold_out"; // 全部卖完
		String OFF_SHELF = "off_shelf"; // 我下架的
		String VIOLATION_OFF_SHELF = "violation_off_shelf"; // 违规下架的
	}
}
