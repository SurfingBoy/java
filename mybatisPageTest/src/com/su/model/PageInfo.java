package com.su.model;

import java.util.List;

public class PageInfo {
	private int pagenum;
	private int pagesize;
	private int pagetotal;//总页数
	private String name;
	private double price;
	private List<?> infoList;
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPagetotal() {
		return pagetotal;
	}
	public void setPagetotal(int pagetotal) {
		this.pagetotal = pagetotal;
	}
	public List<?> getInfoList() {
		return infoList;
	}
	public void setInfoList(List<?> infoList) {
		this.infoList = infoList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
