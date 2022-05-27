import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Apple {

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) throws Exception{
        //正常的调用
        Apple apple = new Apple();
        apple.setPrice(5);
        System.out.println("Apple Price:" + apple.getPrice());
        //使用类名获取Class对象
        Class clz = Class.forName("Apple");

        //调用构造器方法获取一个对象
        Constructor appleConstructor = clz.getConstructor();
        Apple appleObj = (Apple) appleConstructor.newInstance();

        //方法调用
        Method setPrice = clz.getMethod("setPrice", int.class);
        setPrice.invoke(appleObj, 14);

        //方法调用
        Method getPriceMethod = clz.getMethod("getPrice");
        System.out.println("Apple Price:" + getPriceMethod.invoke(appleObj));
    }
}
