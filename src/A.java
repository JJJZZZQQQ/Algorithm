import org.junit.Test;

import java.io.InputStream;
import java.io.Serializable;
import java.net.Socket;
import java.sql.ResultSet;

public class A implements Cloneable , Serializable {
    int x ;
    Apple apple;
    public Object clone() {
        //浅拷贝
        try {
            // 直接调用父类的clone()方法
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public A(int x,Apple apple) {
        this.x = x;
        this.apple = apple;
    }
}
