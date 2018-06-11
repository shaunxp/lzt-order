package com.lzt.order.test.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    public static void main(String agrt[]) {
        ReentrantLock lock = new ReentrantLock();
        Condition a = lock.newCondition();
        Condition b = lock.newCondition();

        new Thread(new B(a, b, lock)).start();
        new Thread(new A(a, b, lock)).start();
    }
}
