package chap2;

import java.util.Arrays;
import java.util.EmptyStackException;

/*
*  这段程序没有明显的错误，但是有一个“内存泄露”，随着垃圾回收器活动的增加，或者由于内存占用的不断增加，程序性能的降低会逐渐表现出来
*
*  发生泄漏的地方:  如果一个栈先是增长，然后再收缩，那么，从栈中弹出来的对象将不会被当做垃圾祸首，即使使用栈的程序不再引用这些对象，他们也不会被回收
*  这是因为，栈内部维护着对这些对象的过期引用(obsolete reference),所谓的过期引用，是指永远不会再被解除的引用。
*  凡是在elements数组的“活动部分(active portion)”之外的任何引用都是过期的。活动部分是指elements中下标小于size的那些元素.
*
* 修复:　一旦对象引用已经过期，只需清空这些引用即可
* 清空过期引用的另一个好处是:如果它们以后又被错误地解除引用，程序会立即抛出NullPointerException异常，而不是悄悄地错误运行下去。尽快地检测出程序中的错误总是有益的
*
*
* */

//Cab you spot the "memory leak"
public class StackGood {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackGood() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public  void push(Object e){
        ensureCapacity();
        elements[size++]=  e;
    }

    public Object pop(){
        if (size==0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;  //Eliminate obsolete reference
        return result;

    }



    /**
     * Ensure space for at least one more element,roughly
     * doubling the capacity each time the array needs to grow
     */
    private void ensureCapacity(){
        if (elements.length==size)
            elements = Arrays.copyOf(elements,2*size+1);
    }

}
