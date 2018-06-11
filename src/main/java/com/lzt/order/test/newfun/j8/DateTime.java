package com.lzt.order.test.newfun.j8;

import java.time.Clock;
import java.time.ZoneId;

public class DateTime {


    public static void main(String args[]){

        final Clock clock = Clock.systemUTC();

        ZoneId zone = ZoneId.of("Z");
        final Clock clock1 =  Clock.system(zone);

        System.out.println( clock1.instant());
        System.out.println( clock1.millis() );
    }
}
