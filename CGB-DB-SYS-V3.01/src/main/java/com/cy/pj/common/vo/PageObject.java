package com.cy.pj.common.vo;

import java.io.Serializable;
import java.util.List;

public class PageObject<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1536631092048817285L;

	private Integer pageCurrent=1;
	private Integer pageSize=3;
	private Integer rowCount=0;
	private Integer pageCount=0;
	private List<T>  records;

	
   public PageObject(Integer pageCurrent, Integer pageSize, Integer rowCount, Integer pageCount, List<T> records) {
		super();
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.pageCount = (rowCount-1)/pageSize+1;
		this.records = records;
	}
	public PageObject() {
		super();
	}
	public Integer getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	} 














}
