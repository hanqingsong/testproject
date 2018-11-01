package javap;

public class TestFinally {
    public int foo() {
        int x;
        try {
            x = 2;
            // x = x/0;
            return x;
        } catch (Exception e) {
            x = 3;
            return x;
        } finally {
            x = 4;
        }
    }

    public static void main(String[] args) {
        int foo = new TestFinally().foo();
        System.out.println(foo);
    }
}
