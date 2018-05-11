package com.lzt.order.test.serial;

import java.io.Serializable;

public class Customer implements Serializable{

	private String name;
	private int age;

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "name=" + name + ", age=" + age;
	}

}
