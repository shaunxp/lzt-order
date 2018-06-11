package com.lzt.order.test.collections;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SetTest {

    public static void main(String args[]) {
        Dto dto1 = new Dto("Shaun", 30);
        Dto dto2 = new Dto("Lisa", 28);
        Dto dto3 = new Dto("Baby", 1);
//
//        Set<Dto> set = new HashSet<>();
//        set.add(dto1);
//        set.add(dto2);
//        set.contains(dto1);

//        for (Dto tmp : set) {
//            System.out.println(tmp);
//        }

//        Iterator it = set.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

//        Set<String> set1 = new HashSet<>();
//        set1.add("1");
//        set1.add("a");
//        set1.add("2");
//        set1.add("abc");
//        set1.add("ab");
//        for (String tmp : set1) {
//            System.out.print(tmp);
//            System.out.print("      ");
//            System.out.println(tmp.hashCode());
//        }
//
//
//        Set<String> set2 = new TreeSet<>();
//        set2.add("1");
//        set2.add("a");
//        set2.add("2");
//        set2.add("abc");
//        set2.add("ab");
//        for (String tmp : set2) {
//            System.out.print(tmp);
//            System.out.print("      ");
//            System.out.println(tmp.hashCode());
//
//        }

//        Set<Dto> set3 = new TreeSet<>();
//
//        set3.add(dto1);
//        set3.add(dto2);
//        set3.add(dto3);
//        for (Dto tmp : set3) {
//            System.out.print(tmp.toString());
//            System.out.print("      ");
//            System.out.println(tmp.hashCode());
//        }


//        Set<String> hashSet = new HashSet<>();
//        hashSet.add("bb");
//        hashSet.add("c");
//        hashSet.add("10");
//        hashSet.add("0");
//        hashSet.add("abc");
//        System.out.println("hashSet:");
//        for (String tmp : hashSet){
//            System.out.print(tmp);
//            System.out.print("      ");
//            System.out.println(tmp.hashCode());
//        }
//
//
//        Set<String> linkedHashSet = new LinkedHashSet<>();
//        linkedHashSet.add("bb");
//        linkedHashSet.add("c");
//        linkedHashSet.add("10");
//        linkedHashSet.add("0");
//        linkedHashSet.add("abc");
//        System.out.println("linkedHashSet:");
//        for (String tmp : linkedHashSet){
//            System.out.print(tmp);
//            System.out.print("      ");
//            System.out.println(tmp.hashCode());
//        }
//
//        Set<String> treeSet = new TreeSet<>();
//        treeSet.add("bb");
//        treeSet.add("cc");
//        treeSet.add("aa");
//        treeSet.add("dd");
//        treeSet.add("abc");
//        System.out.println("treeSet:");
//        for (String tmp : treeSet){
//            System.out.print(tmp);
//            System.out.print("      ");
//            System.out.println(tmp.hashCode());
//        }
//
//        System.out.println(treeSet.size());


        ConcurrentHashMap<Object,Object> map = new ConcurrentHashMap<>();

        map.put(1,2);
        map.get(1);
        map.size();

        Hashtable<Object,Object> table = new Hashtable<>();
        table.put(1,2);
        table.get(1);
        table.size();

        HashMap<Object,Object> hashMap = new HashMap<>();
        hashMap.put(1,2);
        hashMap.size();





    }
}
