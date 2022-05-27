package 循环依赖;

public class Pet {


    public void talk() {
        Person person = new Person();
        person.talk();
        System.out.println("我是人的宠物");
    }
}
