package chap3;

import java.util.HashMap;
import java.util.Map;

public final  class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;


    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode,999,"area code");
        rangeCheck(prefix,999,"prefix code");
        rangeCheck(lineNumber,999,"line number");
        this.areaCode = (short)areaCode;
        this.prefix = (short)prefix;
        this.lineNumber = (short)lineNumber;
    }


    private static void rangeCheck(int arg,int max, String name){
        if (arg<0 || arg > max)
            throw new IllegalArgumentException(name+": "+arg);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj==this)
            return true;
        if (! (obj instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)obj;
        return pn.lineNumber == lineNumber
                && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    private void test(){
        Map<PhoneNumber,String> m = new HashMap<PhoneNumber,String>();
        m.put(new PhoneNumber(707,867,5309),"Jenny");


        //这时m.get(new PhoneNumber(new 707,867,5309))不会返回"jenny"而是返回null
        //这里涉及两个PhoneNumber实例，第一个被用于插入到HashMap中，第二个实例与第一个相等，被用于获取，
        //由于PhoneNumber类没有覆盖hashCode方法，从而导致两个相等的实例具有不相等的散列码，违反了hashCode的约定。
    }




}
