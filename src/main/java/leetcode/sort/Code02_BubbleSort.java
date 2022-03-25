package leetcode.sort;

import java.util.Arrays;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/16
 */
public class Code02_BubbleSort {
    /**
     * 冒泡排序的基本思想是：
     * 通过对待排序的序列从前向后依次比较相邻元素的值，如果发现逆序则交换。
     * 逆序的含义：如果想把序列从小到大排序，那么两个数中前面的比后面的大就是逆序。
     * 若需求是将序列从小到大排序，那么每一趟比较都会把值较大的逐渐从前面移动到后面。
     * 就像水底的泡泡一样
     *
     * 时间复杂度：
     * o(n^2)
     *
     * 稳定性：
     * 稳定排序算法
     * 每次是两个相邻元素之间交换
     */
    public static void main(String[] args) {
        //bubble01();
        bubble02();
    }


    public static void bubble01(){
        int[] arr = new int[]{2, 5, 93, 8, 2, 3, 100};
        System.out.println("arr=" + Arrays.toString(arr));

        // 将最大/最小值往后放
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 最大值往后放
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }

        System.out.println("排序后 arr=" + Arrays.toString(arr));
    }

    /**
     * 优化：如果一次没有交换，证明是有序，不用执行后面循环
     */
    public static void bubble02(){
//        int[] arr = new int[]{2, 5, 93, 8, 2, 3, 100};
        int[] arr = new int[]{566,1,4,5,7,9,22,34};
        System.out.println("arr=" + Arrays.toString(arr));
        // 将最大/最小值往后放
        boolean swapFlag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 最大值往后放
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapFlag=true;
                }
            }

            if (!swapFlag) {
                System.out.println("一次也没有交换，数据有序");
                break;
            }else{
                swapFlag = false;
            }
        }

        System.out.println("排序后 arr=" + Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
