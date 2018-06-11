package com.lzt.order.test.newfun.j8;

public class DefaultInterImpl implements DefaultInter {

    @Override
    public boolean what(int k) {
        if (k == 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int resutWhat(int m) {
        return 0;
    }
}
