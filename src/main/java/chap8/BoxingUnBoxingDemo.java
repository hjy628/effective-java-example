package chap8;

public class BoxingUnBoxingDemo {

    //运行效率低下局部变量被声明为装箱基本类型，编译没有错误或者警告，但是变量被反复地装箱拆箱

    public static void main(String[] args) {
        Long sum = 0L;
        for (long i = 0;i<Integer.MAX_VALUE;i++){
            sum+=i;
        }

        System.out.println(sum);
    }

}
