package com.myEducation.inside.utils.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> {
	private int draw;
	private long start;
	private int length = 10;
	private long recordsTotal;
	private long recordsFiltered;
	private List<T> data = new ArrayList<T>();
	private Map<String, Object> params = new HashMap<String, Object>();
	private List<Column> columns = new ArrayList<Column>();
	private List<Order> order = new ArrayList<Order>();

	public Page() {
		super();
	}

	public Page(long start, int length) {
		super();
		this.start = start;
		this.length = length;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public int getLength() {
		return length == -1 ? 10 : this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	public String getOrderColumn(){
		return columns.get(order.get(0).getColumn()).getData();
	}
	
	public String getOrderDir(){
		return order.get(0).getDir();
	}

	@Override
	public String toString() {
		return "Page [start=" + start + ", length=" + length + ", recordsTotal=" + recordsTotal + ", recordsFiltered="
				+ recordsFiltered + "]";
	}
}
