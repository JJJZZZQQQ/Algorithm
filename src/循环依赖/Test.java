package 循环依赖;

import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.talk();

    }
}
