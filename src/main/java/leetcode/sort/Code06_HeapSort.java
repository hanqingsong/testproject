package leetcode.sort;

import java.util.Arrays;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/16
 */
public class Code06_HeapSort {
    /**
     * 什么是堆
     * 堆首先是一个完全二叉树，堆分为大顶堆和小顶堆；
     * 大顶堆 :
     * 每个节点的值大于或等于其左右孩子节点的值，称为大顶堆。
     * 小顶堆同理就是每个节点的值小于或等于其左右孩子节点的值。
     * 注意:
     * 每个节点的左右孩子节点的大小关系并没有限定。
     * https://www.cnblogs.com/nicaicai/p/12918205.html
     * <p>
     * 排序的基本思想是：
     * 算法步骤如下：
     * 1、首先将待排序序列构建成一个大顶堆(存入数组中)，那么这时，整个序列的最大值就是堆顶的根节点；
     * 2、将堆顶元素与最后一个元素交换，那么末尾元素就存入了最大值；
     * 3、将剩余的 n - 1个元素重新构建成一个大顶堆，重复上面的操作；
     * 反复执行，就能得到一个有序序列了。
     * <p>
     * 时间复杂度：
     * O(n*logn)
     * <p>
     * 稳定性：
     * 不稳定
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 93, 8, 2, 3, 100};
        System.out.println("arr=" + Arrays.toString(arr));

        heapSort(arr);

        System.out.println("排序后 arr=" + Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 构建大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        // 交换
        swap(arr, 0, --heapSize);

        // 比较，交换
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }

    public static void heapInsert(int[] arr, int index) {
        // (index - 1) / 2 父节点
        // 如果数值大于父节点
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 大根堆
    // 某个数在index位置，能否往下移动
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1; // 左孩子的下标
        while (left < heapSize) { // 下方还有孩子的时候
            // 两个孩子中，谁的值大，把下标给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
