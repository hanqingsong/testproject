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
        // System.out.println("return value of test(): " + test3());
    }

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

    public static int test3() {
        int i = 1;
        try {
            return i;
        }finally {
            ++i;
            // i++;
        }
    }

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
}
