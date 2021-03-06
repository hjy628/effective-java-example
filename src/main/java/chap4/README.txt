类和接口

13:使类和成员的可访问性最小化

    第一规则：尽可能地使每个类和成员不被外界访问

    对于成员(域、方法、嵌套类和嵌套接口)有四种可能的访问级别：
            私有的(private) --只有在声明该成员的顶层类内部才可以访问这个成员
            包级私有的(package-private)--声明该成员的包内部的任何类都可以访问这个成员。从技术上讲，它被称为"缺省(default)访问级别"，如果没有为成员指定访问修饰符，
            就采用这个访问级别
            受保护的(protected)--声明该成员的类的子类可以访问这个成员(但有一些限制)，并且，声明该成员的包内部的任何类也可以访问这个成员
            公有的(public)--在任何地方都可以访问该成员




     实例域绝不能是公有的，如果域是非final的，或者是一个指向可变对象的final引用，那么一旦使这个域成为公有的，就放弃了对存储在
     这个域中的值进行限制的能力；这意味着，你也放弃了强制这个域不可变的能力。
     包含公有可变域的类并不是线程安全的。即使域是final的，并且引用不可变的对象。


     长度非零的数组总是可变的，所以，类具有公有的静态final数组域。或者返回这种域的访问方法，这几乎总是错误的。如果类具有这样的域或者访问方法，客户端能够修改数组中的内容，
     这是安全漏洞的一个常见根源。



14:在公有类中使用访问方法而非公有域

            如果类可以在它所在的包的外部进行访问，就提供访问方法。
            如果类是包级私有的，或者是私有的嵌套类，直接暴露它的数据域并没有本质的错误。

15:使可变性最小化
    不可变类只是其实例不能被修改的类。每个实例中包含的所有信息都必须在创建该实例的时候就提供，并在对续航的整个生命周期内固定不变。

        不可变类需要遵循下面五条规则:
        1:不要提供任何会修改对象状态的方法。
        2:保证类不会被扩展。
        3:使所有的域都是final的。
        4:使所有的域都成为私有的。
        5:确保对于任何可变组件的互斥访问。



16:复合优先于继承

17:要么为继承而设计，并提供文档说明，要么就禁止继承


18:接口优于抽象类

            现有的类可以很容易被更新，以实现新的接口

            接口是定义mixin(混合类型)的理想选择

            接口允许我们构造非层次结构的类型框架



            通过对你导出的每个重要接口都提供一个丑娘的骨架实现(skeletal implementation)类，把接口和抽象类的优点结合起来。
            按照惯例，骨架实现被成为AbstractInterface,这里的Interface是指所实现的接口的名字。


           骨架实现类的美妙之处在于，他们为抽象类提供了实现上的帮助，但又不强加"抽象类被用作类型定义时"所特有的严格限制。
           对于接口的大多数实现来讲，扩展骨架实现类是个很显然的选择，但并不是必须的。
           如果预置的类无法扩展骨架实现类，这个类始终可以手工实现这个接口。
           此外，骨架实现类仍然能够有助于接口的实现，实现了这个接口的类可以把对于接口方法的调用，转发到一个内部私有类的实例上。
           这个内部私有类扩展了骨架实现类。这种方法被称作模拟多重继承。

            如果设计得当，骨架实现可以使程序员很容易地提供他们自己的接口实现。eg: IntArrayAsList



19:接口只用于定义类型

            当类实现接口时，接口就充当可以引用这个类的实例的类型(type)。因此，类实现了接口，就表明客户端可以对这个类的实例实施某些动作。为了任何其他目的而定义接口是不恰当的。
            有一种接口被称为常量接口(constant interface),这种接口没有包含任何方法，它只包含静态的final域，每个域都导出一个常量。使用这些常量的类实现这个接口，
            以避免用类名来修饰常量名，eg:PhysicalConstants
            常量接口模式是对接口的不良使用。

20:类层次优于标签类



21:用函数对象表示策略
        有些语言支持函数指针(function pointer)、代理(delegate)、lambda表达式(lambda expression),或者支持类似的机制，允许程序把“调用特殊函数的能力”存储起来并传递这种能力。

        函数指针的主要用途就是实现策略模式，为了在java中实现这种模式，要声明一个接口来表示该策略，并且为每个具体策略声明一个实现了该接口的类。
        当一个具体策略只被使用一次时，通常使用匿名类来声明和实例化这个具体策略类。
        当一个具体策略是设计用来重复使用的时候，它的类通常就要被实现为私有的静态成员类，并通过公有的静态final域被导出，其类型为该策略接口。

22:优先考虑静态成员类
        嵌套类(nested class)是指被定义在另一个类的内部的类。
        嵌套类存在的目的应该只是为了它的外围类(enclosing class)提供服务。如果嵌套类将来可能用于其他的某个环境中，它就应该是顶层类(top-level class)
       嵌套类有四种:
       静态成员类(static member class)、非静态成员类(nonstatic member class)、匿名类(anonymous class)和局部类(local class)。