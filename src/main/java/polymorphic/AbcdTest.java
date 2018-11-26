package polymorphic;

/**
 * Created by hanqingsong on 18/11/5.
 *
 * @author hanqingsong
 * @date 18/11/5
 */
public class AbcdTest {


    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        // 实例对象为A，参数为对象B，B为A的子类。执行A.class中show(A obj)
        System.out.println(a1.show(b));
        // 实例对象为A，参数为对象C，C为A的子类。执行A.class中show(A obj)
        System.out.println(a1.show(c));
        // 实例对象为A，参数为对象D，执行A.class中show(D obj)
        System.out.println(a1.show(d));
        // 对象为A，参数为B，本应执行A and A ,但是B.class 重写了show(A obj) ，所以B.class show(A obj) B and A
        System.out.println(a2.show(b));
        // 同上
        System.out.println(a2.show(c));
        // 执行A.class show(D obj) B中并没有重写
        System.out.println(a2.show(d));
        // 找对象B的方法（包括父类）的直接类型，如果没有向上转型
        // B and B
        System.out.println(b.show(b));
        // B and B
        System.out.println(b.show(c));
        // A and D
        System.out.println(b.show(d));
    }

}

class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }
}

class B extends A {
    public String show(B obj) {
        return ("B and B");
    }

    public String show(A obj) {
        return ("B and A");
    }
}

class C extends B {
}

class D extends B {
}
