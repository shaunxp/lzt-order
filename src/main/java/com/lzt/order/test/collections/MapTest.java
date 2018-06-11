package com.lzt.order.test.collections;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.HashMap;

public class MapTest {

    public static void main(String args[]) {
        HashMap<A, Integer> map = new HashMap<>(4);
        map.put(new A(), 1);
        map.put(new A(), 2);
        map.put(new A(), 3);
        map.put(new A(), 4);
        map.put(new A(), 5);
        map.put(new A(), 6);
        System.out.println(map.size());
    }


}

class A {

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

}
