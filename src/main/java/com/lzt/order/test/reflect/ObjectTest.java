package com.lzt.order.test.reflect;

public class ObjectTest {

    public static void main(String args[]) throws InterruptedException {
        Object obj = null;

        obj.equals("");
        obj.hashCode();
        obj.toString();
        obj.getClass();
        obj.notifyAll();
        obj.wait();
        obj.wait(1000);
        obj.wait(1000,1);
        obj.notify();

    }
}
