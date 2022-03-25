package leetcode.yihuo;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/15
 */
public class ayihuob {
    /**
     * 异或运算
     * @param args
     */
    public static void main(String[] args) {
//        swap();
//        printOddTimesNum1();
        printOddTimesNum2();
    }

    /**
     * 有一批整数数值，一种数出现奇数次，其它数出现偶数次
     * 1.找出出现奇数次的数
     * 2.两种数出现奇数次，其它数出现偶数次
     *
     * 解题思路：
     * 使用异或运算
     * 0^n=n, n^n=0
     *
     */
    public static void printOddTimesNum1(){
        int[] arr = new int[]{2,3,4,5,4,3,2};
        int r =0;
        for (int i = 0; i < arr.length; i++) {
            r = arr[i]^r;
        }
        System.out.println("奇数次的数值是："+r);
    }

    /**
     * 2.两种数出现奇数次，其它数出现偶数次
     *
     */
    public static void printOddTimesNum2(){
        int[] arr = new int[]{2,3,4,5,4,7,3,2};
        int r =0;
        for (int i = 0; i < arr.length; i++) {
            r = arr[i]^r;
        }
        // r = a^b
        // r!=0，r必然有一个位置上是1，提取出最右的1
        int rightOne = r & (~r + 1);

        int onlyOne = 0;
        for (int item : arr) {
            if ((item & rightOne) == 0) {
                onlyOne^=item;
            }
        }


        System.out.println(onlyOne + " " + (r ^ onlyOne));
    }


    public static void swap() {
        int a= 1;
        int b= 2;
        System.out.println("a="+a);
        System.out.println("b="+b);
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("---------------");
        System.out.println("a="+a);
        System.out.println("b="+b);
    }
}
