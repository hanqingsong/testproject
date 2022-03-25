package leetcode.sort;

import java.util.Arrays;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/16
 */
public class Code01_SelectionSort {
    /**
     * 选择排序的思想是：
     * 给定一个数组arr,其长度为n;
     * 第一次从 arr[0] 到 arr[n-1] 中选取一个最值（按照需求，可以是最大值，可以是最小值，下同）与arr[0]进行交换;
     * 第二次从arr[1] 到 arr[n-1] 中选取一个最值与arr[1]进行交换；
     * 以此类推，直到arr[n-2]到arr[n-1]中选出最值交换后即完成排序。（只剩下一个元素，前面的都是比它小（或者大）的）。
     *
     * 时间复杂度：
     * o(n^2)
     *
     * 稳定性：
     * 选择排序是不稳定的排序算法
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 93, 8, 2, 3, 100};
        System.out.println("arr=" + Arrays.toString(arr));

        int maxIndex; // 最大值索引
        for (int i = 0; i < arr.length; i++) {
            maxIndex= i;
            // 找到后面最大值的索引
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            // 判断交换数据
            if (arr[i] != arr[maxIndex]) {
                swap(arr, i, maxIndex);
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
