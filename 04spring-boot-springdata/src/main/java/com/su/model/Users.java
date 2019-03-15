package com.su.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users") //数据库表名
public class Users {
	@Id //主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id") //数据库表的字段名
	private int id;
	@Column(name="Name")
	private String name;
	@Column(name="Age")
	private int age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
