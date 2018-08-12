package chap4;

//缺点太多
//充斥着样板代码，包括枚举声明、标签域以及条件语句。
//优于多个实现乱七八糟地挤在了单个类中，破坏了可读性。
//内存占用也增加了，因为实例承担着属于其他风格的不相关的域。域不能做成是final的，除非构造器初始化了不相关的域，产生更多的样板代码。
//构造器必须不借助编译器，来设置标签域，并初始化正确的数据域：如果初始化了错误的域，程序就会在运行时失败。无法给标签类添加风格，除非可以修改它的源文件。
//如果一定要添加风格，就必须记得给每个条件语句都添加一个条件，否则类就会在运行时失败。
//最后，实例的数据类型没有提供任何关于其风格的线索，一句话，标签类过于冗长，容易出错，并且效率低下。
public class Figure {

    enum Shape{ RECTANGLE,CIRCLE }

    final Shape shape;

    double length;
    double width;

    double radius;


    public Figure(double radius) {
        shape =Shape.CIRCLE;
        this.radius = radius;
    }

    public Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area(){
        switch (shape){
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
             default:
                 throw new AssertionError();
        }
    }



}
