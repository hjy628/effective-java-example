package chap8;

//报空指针错误，Integer和int 混合使用时，装箱基本类型会自动拆箱,
public class Unbelievable {
    static Integer i;

    public static void main(String[] args) {

        if (i==42)
            System.out.println("Unbelievable");

    }




}
