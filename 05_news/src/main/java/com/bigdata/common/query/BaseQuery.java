package com.bigdata.common.query;

import java.io.Serializable;

/**
 * Created by log on 14-3-30.
 */
public class BaseQuery implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3279377158559658097L;

    /** 缺省页大小 */
    public static final int DEFAULT_PAGE_SIZE = 20;

    /** 最大页大小 **/
    public static final int MAX_PAGE_SIZE     = 1000;

    /**
     * 是否以分页形式返回结果
     */
    private boolean			pagingMode = true;

    /**
     * 页大小
     */
    protected int           pageSize;
    /**
     * 总数
     */
    private int             totalRecord;
    /**
     * 当前页  pageIndex从1开始
     */
    private int             pageIndex;

    /**
     * 总页数
     */
    private int             totalPage;

    public int getPageSize() {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    /**
     * 总条目数
     *
     * @param totalRecord
     */
    public void setTotalRecord(int totalRecord) {
        this.totalPage = (totalRecord + getPageSize() - 1) / getPageSize();
        this.totalRecord = totalRecord;
    }

    /**
     * 当前页
     *
     * @return
     */
    public int getPageIndex() {
        if (pageIndex < 1) {
            pageIndex = 1;
        } else if (pageIndex > getTotalPage()) {
            pageIndex = getTotalPage();
        }

        return pageIndex;
    }

    /**
     * 获取原始当前页
     *
     * @author niejing.zhangnj 2012-12-26上午11:17:32
     * @return
     */
    public int getOriginPageIndex() {
        return pageIndex;
    }

    public boolean hasNextPage() {
        if (pageIndex <= getTotalPage()) {
            return true;
        } else {
            return false;
        }
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * oracleDB开始位置
     *
     * @return
     */
    public int getStartPosForOracle() {
        int cPage = getPageIndex();

        if (cPage <= 1) {
            return 1;
        }

        cPage--;

        int pgSize = getPageSize();

        return (pgSize * cPage) + 1;
    }

    /**
     * mysqlDB开始位置
     *
     * @return
     */
    public int getStartPos() {
        int cPage = getPageIndex();

        if (cPage <= 1) {
            return 0;
        }

        cPage--;

        int pgSize = getPageSize();

        return (pgSize * cPage);
    }

    /**
     * 结束位置
     *
     * @return
     */
    public int getEndPos() {
        if (getPageIndex() * getPageSize() < getTotalRecord()) {
            return getPageIndex() * getPageSize();
        } else {
            return getTotalRecord();
        }
    }

    /**
     * 总页数
     *
     * @return
     */
    public int getTotalPage() {
        return totalPage;
    }

    public boolean isPagingMode() {
        return pagingMode;
    }

    public void setPagingMode(boolean pagingMode) {
        this.pagingMode = pagingMode;
    }

}