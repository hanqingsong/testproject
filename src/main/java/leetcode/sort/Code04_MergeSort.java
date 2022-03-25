package leetcode.sort;

import java.util.Arrays;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/16
 */
public class Code04_MergeSort {
    /**
     * 归并排序的基本思想是：
     * 先将序列一次次分成子序列，直到子序列长度为1；
     * 再将已有序的子序列合并，得到完全有序的序列。
     * 可以看出归并排序运用了 分而治之的思想 。
     * <p>
     * 时间复杂度：
     * O(N*logN)，额外空间复杂度O(N)
     * <p>
     * 稳定性：
     * 在交换元素时，可以限定元素相等时不移动，所以归并排序是可以稳定的。
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 93, 8, 2, 3, 100};
        System.out.println("arr=" + Arrays.toString(arr));

        mergeSort(arr);

        System.out.println("排序后 arr=" + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;

        // 按数值大小放入help数组
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p2++] : arr[p1++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }

}
