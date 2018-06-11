package com.lzt.order.test.newfun.j8;

import com.lzt.order.test.newfun.Dto;

import java.util.Arrays;
import java.util.List;

public class LamdbaTest {

    public static void main(String args[]) {

//        Arrays.asList( "a", "b", "d" ).forEach(e -> System.out.println( e ) );
//
//        Arrays.asList( "a", "b", "d" ).forEach( ( String e ) -> System.out.println( e ) );

        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );



//        Dto dto1 = new Dto();
//        dto1.setName("Lisa");
//        dto1.setAge(28);
//
//        Dto dto2 = new Dto();
//        dto2.setName("Shaun");
//        dto2.setAge(30);
//
//        List<Dto> list = Arrays.asList(dto1, dto2);
//
//        list.forEach((Dto tmp) ->
//        {
//            System.out.print(tmp.getName());
//            System.out.println(tmp.getAge());
//        });
//
//        for (Dto tmp : list) {
//            System.out.print(tmp.getName());
//            System.out.println(tmp.getAge());
//        }




    }


}
