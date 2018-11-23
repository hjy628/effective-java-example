package chap8;

public class ThreadLocalDemo {

    private ThreadLocalDemo(){} //Noninstantiable

    //Sets the current thread's value for the named variable.
    public static void set(String key,Object value){};

    //Returns the current thread's value for the named variable.
    public static Object get(String key){return null;}
}
