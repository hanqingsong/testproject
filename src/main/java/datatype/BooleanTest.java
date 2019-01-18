package datatype;

import org.junit.Test;

public class BooleanTest {

    /**
     * boolean对象，对象引用修改不能修改原来的值
     */
    @Test
    public void testBooleanEqual() {
        boolean data1 = false;
//        Boolean data2 = false;
        Boolean data2 = new Boolean(false);
        System.out.println("data1 : " + data1);
//        System.out.println("data2 : " + data2);
        changeBoolean(data1);
//        changeBoolean(data2);
        System.out.println("=================: ");
        System.out.println("data1 : " + data1);
//        System.out.println("data2 : " + data2);
    }


    public void changeBoolean(Boolean data) {
        System.out.println("BooleanTest.changeBoolean1:" + data);
//        data = true;
        data = new Boolean(true);
        System.out.println("BooleanTest.changeBoolean2:" + data);
    }

//    public void changeBoolean(Boolean data) {
//        System.out.println("BooleanTest.changeBoolean1:" + data);
//        data = true;
//        System.out.println("BooleanTest.changeBoolean2:" + data);
//    }
}
