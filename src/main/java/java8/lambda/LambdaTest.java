package java8.lambda;

import org.junit.Test;

/**
 * Created by hanqingsong on 18/10/19.
 * 语法：parameter -> expression body
 * @author hanqingsong
 * @date 18/10/19
 */
public class LambdaTest {


    /**
     * parameter -> expression body
     */
    @Test
    public void test1(){
        FirstInterface firstInterfacePrint =(s)-> System.out.println(s);
        firstInterfacePrint.myPrint("aaa");

        String salutation = "Hello,";
        GreetingService greetService1 = message ->
                System.out.println(salutation + message);
        greetService1.sayMessage("Mahesh");

        MyMath addMath = (int a,int b)->a+b;
        int m =addMath.add(10, 20);
        System.out.println(m);
    }

    /**
     * 可以看作功能性函数
     * 功能性函数一般使用注解@FunctionInterface，只能有一个方法
     */
    interface  FirstInterface{
        void myPrint(String str);
    }
    interface  MyMath{
        int add(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}
