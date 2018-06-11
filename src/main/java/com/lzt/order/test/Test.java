package com.lzt.order.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Test {

    public static void main(String a[]){

        Integer int1 = 1;
        Integer int2 = 1;
        Integer int3 = new Integer(1);
        Integer int4 = new Integer("1");
        System.out.println(int1 == int2);
        System.out.println(int1 == int3);


    }


    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }


    static String getToken() {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int length = chars.length() - 1;
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < 32; i++) {
                Random rd = new Random();
                sb = sb.append(chars.charAt(rd.nextInt(length)));
        }
        return sb.toString();
    }

}
