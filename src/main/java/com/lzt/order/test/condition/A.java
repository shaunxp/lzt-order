package com.lzt.order.test.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class A implements Runnable {

    private Condition conditionA = null;
    private Condition conditionB = null;
    private ReentrantLock lock = null;

    public A(Condition conditionA, Condition conditionB, ReentrantLock lock) {
        this.conditionA = conditionA;
        this.conditionB = conditionB;
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("A start......");
        for (int i = 1; i < 4; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A print " + i);
        }

        try {
            lock.lock();
            conditionB.signal();
            System.out.println("A wait......");
            conditionA.await();
            System.out.println("A reStart......");
            lock.unlock();
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (int i = 7; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A print " + i);
        }
    }
}
