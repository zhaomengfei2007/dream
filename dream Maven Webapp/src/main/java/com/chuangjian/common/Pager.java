package com.chuangjian.common;
/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: Pager.java
 * 
 * Description: Raw data file for paging query.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-16	 Create
 */
import java.util.ArrayList;
import java.util.List;
/**
 * 用于分页查询的数据定义文件。
 * @author	zhaomengfei
 * @version	1.0
 */
public class Pager<T> {
	/**
	 * The number of current page size.
	 * 当前页。
	 */
    private int currentPage;
    /**
	 * The number of records in one page.
	 * 每页记录数。
	 */
    private int pageSize;
    /**
	 * The total number of records in DB.
	 * 总记录数。
	 */
    private int total;
    /**
	 * The total number of page.
	 * 总页数。
	 */
    private int pageCount;
    /**
	 * The number where we begin to get record.
	 * 每页开始的记录数。
	 */
    private int startRecord;
    /**
	 * Whether it has previous page.
	 * 如果有上一页。
	 */
    private boolean hasPreviousPage;
    /**
	 * Whether it has next page.
	 * 如果有下一页。
	 */
    private boolean hasNextPage;
    /**
	 * Whether it has only one page.
	 * 如果只有一页。
	 */
    private boolean onlyOnePage;
    /**
	 * The records of page designed.
	 * 每页的记录内容。
	 */
    private List<T> pageRecords;

    public int getCurrentPage() {
        return currentPage;
    }
    
    /**
     * 用于初始化当前页、总页数、每页记录数和每页内容。
     */
	public Pager() {
    	this(1, 0, 10, new ArrayList());
    }
    
    /**
	 * 构造方法，只构造空页。
	 * @param currentPage 当前页
	 * @param pageSize 每页记录数
	 */
	public Pager(int currentPage,int pageSize) {
		this(currentPage, 0, pageSize, new ArrayList());
	}
	
	/**
	 * 默认构造方法.
	 * 
	 * @param start 本页数据在数据库中的起始位置。
	 * @param totalSize 数据库中总记录条数。
	 * @param pageSize 每页记录数。
	 * @param data 本页内容。
	 */
	public Pager(int currentPage, int totalSize, int pageSize, List data) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.total = totalSize;
		this.pageRecords = data;
	}

    /**
     * make sure the page is in the range of the total pages
     * 
     * @param currentPage
     *            current page
     */
    public void setCurrentPage(int currentPage) {
        if (currentPage < 1) {
            this.currentPage = 1;
            return;
        }
        this.currentPage = currentPage;
    }

    /**
     * get page size
     * 
     * @return page size number
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * set page size
     * 
     * @param pageSize
     *            page size number
     */
    public void setPageSize(int pageSize) {
        if (pageSize <= 0) {
            this.pageSize = 1;
        } else {
            this.pageSize = pageSize;
        }
    }

    /**
     * get total records
     * 
     * @return total record's number
     */
    public int getTotal() {
        return total;
    }

    /**
     * set total records
     * 
     * @param totalRecords
     *            total record number
     */
    public void setTotal(int totalRecords) {
        this.total = totalRecords;
    }

    /**
     * Get the total count of the page
     * 
     * @return count number
     */
    public int getPageCount() {
        // If there is no data in database.
        if (total == 0) {
            pageCount = 1;
            return pageCount;
        }
        boolean isZero = total % pageSize == 0;
        pageCount = total / pageSize;
        pageCount = isZero ? pageCount : pageCount + 1;
        return pageCount;
    }

    /**
     * First record of one page
     * 
     * @return start records
     */
    public int getStartRecord() {
        startRecord = ((currentPage - 1) * pageSize);
        return startRecord;
    }

    /**
     * Whether has previous page
     * 
     * @return if previous page's is exist,return true else not
     */
    public boolean isHasPreviousPage() {
        hasPreviousPage = (currentPage == 1) ? false : true;
        return hasPreviousPage;
    }

    /**
     * Whether has next page
     * 
     * @return if next page's is exist,return true else not
     */
    public boolean isHasNextPage() {
        hasNextPage = (currentPage == getPageCount()) ? false : true;
        return hasNextPage;
    }

    /**
     * Whether is only one page
     * 
     * @return if only one page,return true else not
     */
    public boolean isOnlyOnePage() {
        onlyOnePage = ((getPageCount() == 1) ? true : false);
        return onlyOnePage;
    }

    
    /**
     * 获取页面包含的对象集合
     * @return the pageRecords
     */
    public List<T> getPageRecords() {
        return pageRecords;
    }

	public void setPageRecords(List<T> pageRecords) {
		this.pageRecords = pageRecords;
	}
}
