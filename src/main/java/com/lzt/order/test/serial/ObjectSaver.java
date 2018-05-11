package com.lzt.order.test.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectSaver {

	public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException {

		// 序列化
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/xupeng/Desktop/objectFile.obj"));
		List<Customer> list = new ArrayList<>();
		Customer costomer = new Customer("xupeng", 29);
		Customer costomer1 = new Customer("lisa", 27);
		list.add(costomer);
		list.add(costomer1);
		out.writeObject("hello");
		out.writeObject(new Date());
		CusList cusList = new CusList(list);
		out.writeObject(list); // costomer必须Serializable，才能被writeObject。否则会抛出异常java.io.NotSerializableException
		out.close();

		// 反序列化
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/xupeng/Desktop/objectFile.obj"));
		System.out.println("obj1 " + (String) in.readObject()); // 读取字面值常量
		System.out.println("obj2 " + (Date) in.readObject()); // 读取匿名Date对象
//		Customer obj3 = (Customer) in.readObject(); // 读取customer对象
		System.out.println("obj3 " + in.readObject());
		in.close();
	}

}
