package modifiers;

/**
 * Created by hanqingsong on 18/12/8.
 *
 * @author hanqingsong
 * @date 18/12/8
 */
public class Person2 {
    public void sayHello(){
        Person person = new Person();
        person.sayHello();
    }

    public static void main(String[] args) {
        Person2 person2 = new Person2();
        person2.sayHello();
    }
}
