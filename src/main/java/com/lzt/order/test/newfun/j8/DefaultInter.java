package com.lzt.order.test.newfun.j8;

public interface DefaultInter {

    boolean what(int k);

    default int resutWhat(int m) {
        return m + 1;
    }


}
