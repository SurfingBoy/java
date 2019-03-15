package com.su.model;

public class Flower {
	private int id;
	private String name;
	private double price;
	private String desc;
	public Flower(int id, String name, double price, String desc) {
		// TODO Auto-generated constructor stub
		super();
		this.id=id;
		this.name=name;
		this.price=price;
		this.desc=desc;
	}
	public Flower() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
