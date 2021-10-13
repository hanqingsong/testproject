package finallytest;

/**
 * Created by hanqingsong on 18/9/17.
 *
 * @author hanqingsong
 * @date 18/9/17
 */
public class FinallyTest {
    public static void main(String[] args) {
        System.out.println("return value of test(): " + test());
        System.out.println("return value of test3(): " + test3());
        System.out.println("return value of test2(): " + test2());
        System.out.println("return value of test4(): " + test4());
        // System.out.println("return value of test(): " + test3());
    }
    /**
     * 会先将try或catch中的返回值储存在局部变量表中，最后执行返回是加载到操作数栈返回
     *
     * @return int 1
     * @author hanqingsong
     * @date 2021-05-23
     */
    public static int test() {
        int i = 1;
// 		 if(i == 1)
// 			 return 0;
        System.out.println("the previous statement of try block");
        // i = i / 0;

        try {
            System.out.println("try block");
            return i;
        }finally {
            // ++i;
            // i++;
            i=2;
            System.out.println("finally block");
        }
    }
    /**
     * 会先将try或catch中的返回值储存在局部变量表中，最后执行返回是加载到操作数栈返回
     *
     * @return int 1
     * @author hanqingsong
     * @date 2021-05-23
     */
    public static int test3() {
        int i = 1;
        try {
            return i;
        }finally {
            ++i;
            // i++;
        }
    }
    /**
     * 抛异常执行catch中异常，将catch中的返回值储存在局部变量表中，最后执行返回是加载到操作数栈返回
     *
     * @return int 2
     * @author hanqingsong
     * @date 2021-05-23
     */
    public static int test2() {
        int i = 1;
// 		 if(i == 1)
// 			 return 0;
        System.out.println("the previous statement of try block");
        // i = i / 0;

        try {
            System.out.println("try block");
            i = i / 0;
            return i;
        }catch (Exception e){
            System.out.println("exception block");
            return 2;
        } finally {

            System.out.println("finally block");
            // return 3;
        }
    }
    /**
     * finally中含有return其中finally中return会覆盖try和catch中的return
     *
     * @return int 3
     * @author hanqingsong
     * @date 2021-05-23
     */
    public static int test4() {
        int i = 1;
        System.out.println("the previous statement of try block");

        try {
            System.out.println("try block");
            i = i / 0;
            return i;
        }catch (Exception e){
            System.out.println("exception block");
            return 2;
        } finally {

            System.out.println("finally block");
            return 3;
        }
    }
}
