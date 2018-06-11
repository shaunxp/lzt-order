package com.lzt.order.test.collections;

import sun.tools.jstat.Literal;

import java.util.*;

public class ListTest {

    public static void main(String args[]) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("a");
        arrayList.add("2");
        arrayList.add("abc");
        arrayList.add("ab");




        arrayList.contains("ab");

        List<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            linkedList.add(String.valueOf(i));
        }


        List<String> list = new ArrayList<>(arrayList);
        list.addAll(linkedList);



        Vector<String> vector = new Vector<>();
        vector.add("1");




        Map<Object,Object> map = null;


        ListIterator<String> lit = arrayList.listIterator();

        for (String tmp : arrayList){
            System.out.print(tmp);
            System.out.print("      ");
            System.out.println(tmp.hashCode());
        }


    }
}
