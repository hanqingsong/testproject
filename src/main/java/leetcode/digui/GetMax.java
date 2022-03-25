package leetcode.digui;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/16
 */
public class GetMax {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 93, 8, 2, 3, 100};

        System.out.println(getMax(arr));
    }
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        // 中点，防溢出
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
