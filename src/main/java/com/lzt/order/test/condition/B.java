package com.lzt.order.test.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class B implements Runnable {

    private Condition conditionA = null;
    private Condition conditionB = null;
    private ReentrantLock lock = null;

    public B(Condition conditionA, Condition conditionB, ReentrantLock lock) {
        this.conditionA = conditionA;
        this.conditionB = conditionB;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            System.out.println("B await......");
            lock.lock();
            conditionB.await();
            System.out.println("B start......");
            lock.unlock();
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (int i = 4; i < 7; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B print " + i);
        }

        lock.lock();
        conditionA.signal();
        lock.unlock();
    }
}
