package com.lzt.order.test.reflect;

public class ReflectMain {

    public static void main(String args[]){
        Student student = new Student();
        student.setId("080506220");
        student.setName("徐鹏");

        Reflect.reflectTest(student);

    }
}
