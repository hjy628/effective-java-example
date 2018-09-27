package chap5;

import java.util.Arrays;
import java.util.EmptyStackException;

//Initial attempt to generify Stack = won't compile!
public class StackE<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public StackE() {
        //  elements = new E[DEFAULT_INITIAL_CAPACITY];
        elements =(E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }


    public E pop(){
        if (size==0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null;  //Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty(){
        return size==0;
    }


    private void ensureCapacity(){
        if (elements.length==size)
            elements = Arrays.copyOf(elements,2*size+1);
    }

    public static void main(String[] args) {
        StackE<String> stackE = new StackE<String>();
        for (String arg :
                args)
            stackE.push(arg);
        while (!stackE.isEmpty())
            System.out.println(stackE.pop().toUpperCase());
    }

}
