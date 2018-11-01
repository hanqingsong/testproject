package extendstest;

/**
 * Created by hanqingsong on 18/10/24.
 * 方法静态分派
 * @author hanqingsong
 * @date 18/10/24
 */
public class StaticDispach {
    static abstract class Human{

    }
    static class Man extends Human{

    }
    static class Woman extends Human{

    }

    public void sayHello(Human human) {
        System.out.println("hello guy");
    }


    public void sayHello(Man man) {
        System.out.println("hello man");
    }

    public void sayHello(Woman woman) {
        System.out.println("hello woman");

    }

    public static void main(String[] args) {
        StaticDispach staticDispach = new StaticDispach();
        Human man = new Man();
        staticDispach.sayHello(man);
        Human woman = new Woman();
        staticDispach.sayHello(woman);
    }
}
