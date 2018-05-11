package com.lzt.order.test.fund;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalculateRate {

    public static void main(String args[]){
//       BigDecimal a = cal("005503");
       BigDecimal b = cal("000330");
       BigDecimal baseValue = new BigDecimal("30");
//       System.out.println(baseValue.multiply(a.subtract(b)).multiply(new BigDecimal("60")));
        System.out.println(baseValue.multiply(b).multiply(new BigDecimal("30")));
    }

    public static BigDecimal cal(String fundCode){
        // read file
        List<Fund> list =  readFileByLines("/Users/xupeng/Documents/workspace-git/repository/lzt-order/content/"+fundCode);

        BigDecimal values = new BigDecimal("0");
        int size = list.size();
        long dates = DateUtil.getDaySub(list.get(size - 1).getDate(), list.get(0).getDate()) + 1;
        for(Fund tmp : list){
            values = values.add(tmp.getValue());
        }
        System.out.println("005503:" + values.divide(BigDecimal.valueOf(dates), 4, BigDecimal.ROUND_HALF_DOWN));
        return values.divide(BigDecimal.valueOf(dates), 4, BigDecimal.ROUND_HALF_DOWN);
    }

    public static List<Fund> readFileByLines(String fileName) {

        List<Fund> list = new ArrayList<>();

        File file = new File(fileName);

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null){
                String[] tmp = tempString.split("\t");
                Fund fund = new Fund();
                fund.setDate(tmp[0]);
                fund.setValue(new BigDecimal(tmp[1]));
                list.add(fund);
            }
            reader.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
