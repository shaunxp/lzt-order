package com.lzt.order.test.collections;

import net.sf.json.util.JSONUtils;

import java.util.*;

public class SetSortTest {

    public static void main(String args[]){
        Dto dto = new Dto("jack",12);
        String body = JSONUtils.valueToString(dto);

        Map<String, String> orderParam = new HashMap<String, String>();
        orderParam.put("appid", "1000110021");
        orderParam.put("mch_id", "300029391030");
        orderParam.put("nonce_str", "ksfjasfjasfjasjdfljsadfjalsj");
        orderParam.put("body", body);
        orderParam.put("out_trade_no", "201805172312320001");
        orderParam.put("total_fee", "12000");
        orderParam.put("spbill_create_ip", "127.0.0.1");
        orderParam.put("notify_url", "https://tuniu.com/cashier/wechatpay/notice");
        orderParam.put("trade_type", "APP");

        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            String signData = getSignDataIgnoreNull(orderParam);
//            System.out.println(signData);
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("settime:" + (timeEnd - timeStart));
    }

    public static String getSignDataIgnoreNull(Map<String, String> orderParam) {
        StringBuffer content = new StringBuffer();
        Set<String> keys = new TreeSet<>(orderParam.keySet());
//        int count = 0;
//        for (String key : keys){
//            if ("sign".equals(key) || "sign_method".equals(key)) {
//                continue;
//            }
//            String value = (String) orderParam.get(key);
//            if (value != null && !"".equals(value)) {
//                content.append((count == 0 ? "" : "&") + key + "=" + value);
//                count++;
//            }
//        }
        return content.toString();
    }
}
