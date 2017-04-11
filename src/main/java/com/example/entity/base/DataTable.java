package com.example.entity.base;

import java.util.List;

/**
 * 2017-03-30
 * @author jxq
 * 
 * DataTable分页
 * */
public class DataTable<T>{
	
	public DataTable(List<T> data,int draw,int recordsTotal){
		this.data = data;
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsTotal;
	}
	
	private List<T> data;        //集合
	
	private int draw;            //操作次数
	
	private int recordsTotal;    //总数
	 
	private int recordsFiltered; //与总数一致

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	
}
