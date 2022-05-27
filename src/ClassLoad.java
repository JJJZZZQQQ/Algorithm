public class ClassLoad {
    //类变量，在 链接的准备阶段初始化赋零值，在初始化阶段赋值为2
    static int a = 2;
    //常量，编译的时候初始化
    final static int b = 1;
    //编译期也会确定，代表c这个变量不可变，对象实例化的时候才会初始化，因为这还是一个实例变量
    final int  c = 2;
    //对象实例化的时候被加载到堆区
    int d = 1;

    static Object obj = new Object();

    final Object obj2 = new Object();

    final static Object obj3 = new Object();

}
