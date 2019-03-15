package com.su.model;

public class PeopleFactory {
	public static People newInstance() {
		return new People(3, 28, "王五");
	}
}
