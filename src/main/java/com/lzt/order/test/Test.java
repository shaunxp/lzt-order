package com.lzt.order.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Test {

    public static void main(String a[]){

        for (int i = 0; i < 1; i++){
            String uuid = getUUID();
            System.out.println(uuid);
            String token = getToken();
            System.out.println(token);
        }

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
