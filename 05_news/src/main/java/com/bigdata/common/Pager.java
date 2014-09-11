package com.bigdata.common;

public class Pager {
	/**
	 * 创建分页导航Html标签
	 * @param currentPage 索引页码,从1开始
	 * @param totalPageNum 总页数
	 * @param showPageCount 显示分页个数(奇数)
	 * @return
	 */
	public static String html(int currentPage, int totalPageNum, int showPageCount) {
		if (totalPageNum == 1)
			return "";
		
		StringBuilder sb = new StringBuilder();
		int span = showPageCount / 2; // 前后对称的个数
		int from, to;
		if (totalPageNum > showPageCount + 1) { // 导航中出现省略号
			if (currentPage <= span + 1) { // 省略号出现在右边
				from = 1;
				to = showPageCount;
				if (currentPage != 1)
					sb.append("<a href='javascript:void(0);' onclick='turnToPage("+(currentPage - 1)+");'>上一页</a>");
				sb.append(showPageNavigation(currentPage, from, to));
				sb.append("...");
				sb.append("<a href='javascript:void(0);' onclick='turnToPage("+totalPageNum+");'>"+totalPageNum+"</a>");
				sb.append("<a href='javascript:void(0);' onclick='turnToPage("+(currentPage + 1)+");'>下一页</a>");
			} else if (currentPage >= totalPageNum - span) { // 省略号出现在左边
				from = totalPageNum + 1 - showPageCount;
				to = totalPageNum;
				sb.append("<a href='javascript:void(0);' onclick='turnToPage("+(currentPage - 1)+");'>上一页</a>");
				sb.append("<a href='javascript:void(0);' onclick='turnToPage(1);'></a>");
				sb.append("...");
				sb.append(showPageNavigation(currentPage, from, to));
				if (currentPage != totalPageNum)
					sb.append("<a href='javascript:void(0);' onclick='turnToPage("+(currentPage + 1)+");'>下一页</a>");
			} else { // 省略号出现在两边
				from = currentPage - span;
				to = currentPage + span;
				sb.append("<a href='javascript:void(0);' onclick='turnToPage("+(currentPage - 1)+");'>上一页</a>");
				sb.append("<a href='javascript:void(0);' onclick='turnToPage(1);'>1</a>");
				sb.append("...");
				sb.append(showPageNavigation(currentPage, from, to));
				sb.append("...");
				sb.append("<a href='javascript:void(0);' onclick='turnToPage("+totalPageNum+");'>"+totalPageNum+"</a>");
				sb.append("<a href='javascript:void(0);' onclick='turnToPage("+(currentPage + 1)+");'>下一页</a>");
			}
		} else { // 导航中不出现省略号
			from = 1;
			to = totalPageNum;
			if (currentPage != 1)
				sb.append("<a href='javascript:void(0);' onclick='turnToPage("+(currentPage - 1)+");'>上一页</a>");
			sb.append(showPageNavigation(currentPage, from, to));
			if (currentPage != totalPageNum)
				sb.append("<a href='javascript:void(0);' onclick='turnToPage("+(currentPage + 1)+");'>下一页</a>");
		}
		return sb.toString();
	}

	private static String showPageNavigation(int currentPage, int from, int to) {
		StringBuilder sb = new StringBuilder();
		for (int i = from; i <= to; i++) {
			if (i == currentPage) {
				sb.append("<span class='current'>"+i+"</span>");
			} else {
				sb.append("<a href='javascript:void(0);' onclick='turnToPage("+i+");'>"+i+"</a>");
			}
		}
		return sb.toString();
	}
}
