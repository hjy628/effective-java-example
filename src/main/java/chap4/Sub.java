package chap4;

import java.util.Date;

public final class Sub extends Super{

    private final Date date;    //Blank final,set by constructor


    public Sub() {
        this.date = new Date();
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
