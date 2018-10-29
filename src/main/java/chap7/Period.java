package chap7;

import java.util.Date;

// Broken "immutable" time period class
public  final  class Period {
    private final Date start;
    private final Date end;
/*
*//**
*   @param start the beginning of the period
*   @param end  the end of the period; must not precede start
 * @throws IllegalArgumentException if start is after end
 * @throws NullPointerException if start or end is null
 *
* *//*
    public Period(Date start, Date end) {
        if (start.compareTo(end)>0)
            throw new IllegalArgumentException(start + " after " + end);
        this.start = start;
        this.end = end;
    }*/


    /**
     *   @param start the beginning of the period
     *   @param end  the end of the period; must not precede start
     * @throws IllegalArgumentException if start is after end
     * @throws NullPointerException if start or end is null
     *
     * */
    //Repaired constructor -make defensive copies of parameters 保护性拷贝
    //保护性拷贝是在检查参数的有效性之前进行的，并且有效性检查是针对拷贝之后的对象，而不是针对原始的对象，
    //这样做看起来有点不自然却很有必要，可以避免在“危险阶段”期间从另一个线程改变类的参数，这里的危险阶段是指从检查参数开始，
    //直到拷贝参数之间的时间段。
    //同时，也没有用Date的clone方法来进行保护性拷贝，因为Date是非final的，不能保证clone方法一定返回类为java.util.date的对象：
    //它有可能返回专门出于恶意的目的而设计的不可信子类的实例
    //例如：这样的子类可以在每个实例被创建的时候，把指向该实例的引用记录到一个私有的静态列表中并且允许攻击者访问这个列表，这将使得攻击者可以自由地控制所有的实例
    //为了阻止这种攻击，对于参数类型可以被不信任方子类化的参数，请不要使用clone方法进行保护性拷贝

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end)>0)
            throw new IllegalArgumentException(start + " after " + end);
    }


    public Date start(){
        return start;
    }

    public Date end(){
        return end;
    }


    public static void main(String[] args) {

        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start,end);

        end.setYear(2020);      //Modifies internals of p

    }


}
