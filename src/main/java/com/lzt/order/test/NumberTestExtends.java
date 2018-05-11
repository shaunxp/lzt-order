package com.lzt.order.test;

public class NumberTestExtends extends NumberTest{

    public static void main(String args[]){
        NumberTest numberTest = new NumberTestExtends();
        numberTest.stringTest("1");
        numberTest.stringTest(1);
    }


    public void stringTest(String str){
        System.out.println(str + 1);
    }


}
