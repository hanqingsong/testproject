package leetcode.sort;

import java.util.Arrays;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/16
 */
public class Code10_RadixSort {
    /**
     *排序的基本思想是：
     *
     *
     * 时间复杂度：
     *
     * 稳定性：
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 93, 8, 2, 3, 100};
        System.out.println("arr=" + Arrays.toString(arr));



        System.out.println("排序后 arr=" + Arrays.toString(arr));
    }

    private static void smallSort(int[] arr) {

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
