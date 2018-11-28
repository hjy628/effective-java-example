

        并发

        66:同步访问共享的可变数据


        67:避免过度同步
                为了避免活性失败和安全性失败，在一个被同步的方法或者代码块中，永远不要放弃对客户端的控制。

         68:executor和task优先于线程

         69:并发工具优先于wait 和notify


         70:线程安全性的文档化
                    常见的线程安全的几个级别：
                            不可变的(immutable)--这个类的实例是不变的。所以，不需要外部的同步。这样的例子包括String、Long和BigInteger

                            无条件的线程安全(unconditionally thread-safe)--这个类的实例是可变的，但是这个类有着足够的内部同步，所以，它的实例可以被并发使用，
                            无需任何外部同步。其例子包括Random和ConcurrentHashMap。

                            有条件的线程安全(conditionally thread-safe)--除了有些方法为进行安全的并发使用而需要外部同步之外，这种线程安全级别与无条件的线程安全相同。这样的例子包括
                            Collections.synchronized包装返回的集合，它们的迭代器(iterator)要求外部同步。

                            非线程安全(not thread-safe)--这个类的实例是可变的。为了并发地使用它们，客户必须利用自己选择的外部同步包围每个方法调用(或者调用序列)。这样的例子包括通用的
                            集合实现。例如ArrayList和HashMap。

                            线程对立的(thread-hostile)--这个类不能安全地被多个线程并发使用，即使所有的方法调用都会被外部同步包围。线程对立的根源通常在于，没有同步地修改静态数据。
                            没有人会有意编写一个线程对立的类；这种类是因为没有考虑到并发性而产生的后果。幸运的是，在java平台类库中，线程对立的类或者方法非常少。


         71:慎用延迟初始化
                在大多数情况下，正常的初始化要优先于延迟初始化。
                如果利用延迟初始化来破坏初始化的循环，就要使用同步访问方法，因为它是最简单、最清楚的替代方法

                如果出于性能的考虑而需要对静态域使用延迟初始化，就使用lazy initialization holder class模式，这种模式保证了类要到被用到的时候才会被初始化。
                    //lazy initialization holder class idiom for static fields
                    private static class FieldHolder {
                            static final FieldType field = computeFieldValue();
                        }

                        static FieldType getField(){return FieldHolder.field;}


                如果处于性能的考虑而需要对实力域使用延迟初始化，就使用双重检查模式(double-check idiom).这种模式避免了在域被初始化之后访问这个域时的锁定开销。
                这种模式背后的思想是：两次检查域的值，第一次检查时没有锁定，看看这个域是否被初始化了；第二次检查时有锁定。只有当第二次检查时表明这个域没有被初始化
                ，才会调用computeFieldValue方法对这个域进行初始化。因为如果域已经被初始化就不会有锁定，域被声明为volatile很重要
                        //Double-check idiom for lazu initialization of instance fields
                        private volatile FieldType field;
                        FieldType getField(){
                                    FieldType result = field;
                                    if(result == null){ //First check(no locking)
                                            synchronized(this){
                                            result = field;
                                            if(result==null){   //Second check (with locking)
                                                    field = result = computeFieldValue();
                                                    }
                                             }
                                             return result;
                                        }
                                }



         72:不要依赖于线程调度器
                    任何依赖于线程调度器来达到正确性或者性能要求的程序，很有可能都是不可移植的。
                    线程优先级是java平台上最不可移植的特征了。


         73:避免使用线程组