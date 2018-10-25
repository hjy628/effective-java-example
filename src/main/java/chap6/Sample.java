package chap6;

//Program containing marker annotations
public class Sample {
    @Test public static void m1(){}; //Test should pass
    public static void m2(){};
    @Test public static void m3(){ //Test should fail
        throw new RuntimeException("Boom");
    };
     public static void m4(){};
    @Test public  void m5(){}; //Invalid use : nonstatic method
     public static void m6(){};
    @Test public static void m7(){
        throw new RuntimeException("Crash"); //Test should fail
    }; //Test should pass
     public static void m8(){};

}
