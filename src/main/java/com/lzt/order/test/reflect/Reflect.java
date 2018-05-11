package com.lzt.order.test.reflect;

import javax.print.DocFlavor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect {

    public static void reflectTest(Object obj){

        Class cls = obj.getClass();

        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            String name = field.getName();
            Object value = null;
            try{
                field.get(obj);
            }catch(Exception e){

            }

            System.out.println(name);

            System.out.println(field.getType());
        }

    }

}
