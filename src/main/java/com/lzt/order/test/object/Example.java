package com.lzt.order.test.object;

public class Example {

    public static void main(String[] args) {
        Object printACon = new Object();
        Object printBCon = new Object();
        new Thread(new PrintA(printACon, printBCon)).start();

        new Thread(new PrintC(printACon, printBCon)).start();

        new Thread(new PrintB(printACon, printBCon)).start();
    }
}
