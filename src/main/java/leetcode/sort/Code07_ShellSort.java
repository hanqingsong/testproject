package leetcode.sort;

import java.util.Arrays;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/16
 */
public class Code07_ShellSort {
    /**
     * 当待插入元素是一个很小(当需求是从小到大排序时，从大到小排序时此处为很大)直接插入排序需要移动较多次数，性能会很差。希尔排序解决了这一问题。
     *排序的基本思想是：
     * 把序列按下标的一定增量分组，对每组使用直接插入排序算法排序；
     * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
     * 如果对直接插入排序不了解的朋友，可以看我的这篇文章：
     * https://www.cnblogs.com/nicaicai/p/12651457.html
     *
     * 时间复杂度：
     *
     * 稳定性：
     * 在不同的插入排序过程中，相等的元素可能在各自的插入排序中发生移动，最后其前后相对位置会发生改变，所以希尔排序是不稳定的。
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
