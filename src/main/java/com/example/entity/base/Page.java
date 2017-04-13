package com.example.entity.base;

import java.io.Serializable;

/**
 * 2017-03-30
 * @author jxq
 * 
 * DataTable分页
 * */
public class Page implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8341411062708269031L;

	private int pageStart;               //条数位置
	
	private int pageLength;              //查询数量
	
	private int pageDraw;                //查询次数
	
	private String pageSearch;           //筛选关键字
	
	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageLength() {
		return pageLength;
	}

	public void setPageLength(int pageLength) {
		this.pageLength = pageLength;
	}

	public int getPageDraw() {
		return pageDraw;
	}

	public void setPageDraw(int pageDraw) {
		this.pageDraw = pageDraw;
	}

	public String getPageSearch() {
		return pageSearch;
	}

	public void setPageSearch(String pageSearch) {
		this.pageSearch = pageSearch;
	}

}
