package com.lzt.order.test.fund;

public class DateUtil {


    private long aLong;

    public static long getDaySub(String beginDateStr, String endDateStr){
        long day=0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date beginDate;
        java.util.Date endDate;
        try{
            beginDate = format.parse(beginDateStr);
            endDate= format.parse(endDateStr);
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return day;
    }
}
