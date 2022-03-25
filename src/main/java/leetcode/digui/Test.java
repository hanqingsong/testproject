package leetcode.digui;

/**
 *
 * 成员变量和局部变量区别
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/17
 */

public  class Test {
    String name ;
    int age;
    public Test(){

    }
    public Test(String name){
        this.name=name;
    }

    public Test(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //    public Test(String name ,int age){
//        this(name);
////        this.name=name;
//        this.age=age;
//    }
    public static void test2(){
        int ccc=111;

    }
}
