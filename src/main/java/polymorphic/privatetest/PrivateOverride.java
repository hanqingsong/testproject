package polymorphic.privatetest;

/**
 * Created by hanqingsong on 18/11/5.
 *
 * @author hanqingsong
 * @date 18/11/5
 */
public class PrivateOverride {
    public PrivateOverride() {
        System.out.println("PrivateOverride.PrivateOverride");
    }

    private void f(){
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Drived();
        po.f();
        // 输出 private f()
    }
}
class Drived extends PrivateOverride{
    public Drived() {
        System.out.println("Drived.Drived");
    }

    public void f(){
        System.out.println("public f()");
    }
}