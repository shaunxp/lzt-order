package com.lzt.order.test.serial;

import java.io.Serializable;
import java.util.List;

public class CusList implements Serializable{
	
	List<Customer> list;

	public CusList(List<Customer> list) {
		super();
		this.list = list;
	}

	@Override
	public String toString() {
		return "CusList [list=" + list + "]";
	}
}
