package com.lzt.order.test.object;

public class PrintB implements Runnable {

    private Object objectA = null;
    private Object objectB = null;

    PrintB(Object printACon, Object printBCon) {
        objectA = printACon;
        objectB = printBCon;
    }

    @Override
    public void run() {
        try {
            // 刚开始B线程等待A线程打印完1、2、3
            System.out.println("PrintB wait......");
            synchronized (objectB) {
                objectB.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("PrintB start......");
        for (int i = 4; i < 7; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("printB print " + i);
        }

        // B线程打印完了4、5、6后就通知A线程继续打印
        synchronized (objectA) {
            objectA.notify();
            System.out.println("printB notify A");
        }
    }
}
