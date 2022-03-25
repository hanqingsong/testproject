package leetcode.sort;

import java.util.Arrays;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/16
 */
public class Code05_QuickSort {
    /**
     * 排序的基本思想是：
     * 快速排序的基本思想是任取待排序序列的一个元素作为中心元素(可以用第一个，最后一个，也可以是中间任何一个)，习惯将其称为pivot，枢轴元素；
     * 将所有比枢轴元素小的放在其左边；
     * 将所有比它大的放在其右边；
     * 形成左右两个子表；
     * 然后对左右两个子表再按照前面的算法进行排序，直到每个子表的元素只剩下一个。
     * <p>
     * 可见快速排序用到了分而治之的思想。
     * 将一个数组分成两个数组的方法为：
     * 先从数组右边找到一个比枢轴元素小的元素，将数组的第一个位置赋值为该元素；
     * 再从数组的左边找到一个比枢轴元素大的元素，将从上面取元素的位置赋值为该值；
     * 依次进行，直到左右相遇，把枢轴元素赋值到相遇位置。
     * <p>
     * 时间复杂度：
     * O(n*logn)，空间复杂度O(logN)
     * 稳定性：
     * 不稳定
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 93, 8, 2, 3, 100};
        System.out.println("arr=" + Arrays.toString(arr));

        quickSort(arr);

        System.out.println("排序后 arr=" + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            // 等概率随机选个位置数和最右位置数进行交换
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    // 返回等于区域的左右边界，饭好友一个长度为2的数组， <p  ==p  >p
    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1; // <区右边界
        int more = R; // >区左边界
        while (L < more) { // L表示当前数的位置，相当于指针
            if (arr[L] < arr[R]) { // 当前值<划分值，小于区域右移，交换连个数，指针右移
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) { // 当前值>划分值
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        // 确定R位置数
        swap(arr, more, R);
        return new int[]{less + 1, more};

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
