package com.lzt.order.test.object;

public class PrintC implements Runnable {

    private Object objectA = null;
    private Object objectB = null;

    PrintC(Object printACon, Object printBCon) {
        objectA = printACon;
        objectB = printBCon;
    }

    @Override
    public void run() {
        try {
            // 刚开始B线程等待A线程打印完1、2、3
            System.out.println("PrintC wait......");
            synchronized (objectB) {
                objectB.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("PrintC start......");
        for (int i = 10; i < 15; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("PrintC print " + i);
        }

        synchronized (objectA) {
            objectA.notify();
            System.out.println("printC notify A");
        }
    }
}
