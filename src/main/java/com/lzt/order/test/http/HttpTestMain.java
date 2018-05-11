package com.lzt.order.test.http;

import java.util.HashMap;
import java.util.Map;

public class HttpTestMain {

    public static void main(String args[]){

        Map<String, String> map = new HashMap<>();
        map.put("payCurrency", "USD");

        String A = RestClientUtils.executeRestClient("{}", "http://localhost:18096/mbs/base/currency/rate", "POST");
        System.out.println(A);
    }

}
