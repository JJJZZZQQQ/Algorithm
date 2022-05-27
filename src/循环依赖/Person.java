package 循环依赖;

public class Person {

    public void talk() {
        Pet pet = new Pet();
        pet.talk();
        System.out.println("我是人");
    }
}
