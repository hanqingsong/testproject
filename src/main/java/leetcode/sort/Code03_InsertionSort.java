package leetcode.sort;

import java.util.Arrays;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/16
 */
public class Code03_InsertionSort {
    /**
     * 插入排序的思想是：
     * 将待排序序列分成两个序列，前面的序列保持有序，依次选取后面的序列的元素，在前面的序列中进行插入。
     * 初始时，有序序列的长度为1。
     * <p>
     * 时间复杂度：
     * O(n^2)
     * <p>
     * 稳定性：
     * 稳定排序
     * 插入排序是在一个已经有序的小序列的基础上，一次插入一个元素。如果碰见一个和插入元素相等的，那么将会把待插入元素放在相等元素的后面。所以，相等元素的相对的前后顺序没有改变，所以插入排序是稳定的。
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 93, 8, 2, 3, 100};
        System.out.println("arr=" + Arrays.toString(arr));

        insertionSort(arr);

        System.out.println("排序后 arr=" + Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {

            // 遍历前面有序数据，如果小于前面数据则交换
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] < arr[j]) {
                    swap(arr, i, j);
                } else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
