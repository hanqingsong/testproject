package algorithm.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by hanqingsong on 18/8/27.
 * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 *
 * @author hanqingsong
 * @date 18/8/27
 */
public class InsertionSort {
    @Test
    public void teatInsertionSort() {
        List<Integer> dataArr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(dataArr);
        System.out.println(dataArr);
        System.out.println("====doSelectionSort开始=====");
        this.doInsertionSort(dataArr);
        System.out.println("====doSelectionSort结束=====");
    }

    private void doInsertionSort(List<Integer> dataArr) {
        System.out.println("当前数组：" + dataArr);
        int size = dataArr.size();
        int tmp;
        // 遍历每一个元素，从第二个元素开始，和前面已经排序好的数据比较
        for (int i = 1; i < size; i++) {
            int currentIndex = i;
            int currentData = dataArr.get(i);
            System.out.println("当前第" + (i + 1) + "位数：" + currentData);
            // 循环已排序的数据
            for (int j = i - 1; j >= 0; j--) {
                // 判断当前数和已经排序好的数比较，如果小于，位置交换，当前位置变化
                Integer preData = dataArr.get(j);
                System.out.print("比较数据，当前数据【" + currentData + "】和 【" + preData + "】比较：");
                if (currentData < preData) {
                    System.out.println(" 交换,第"+(currentIndex+1)+"位和第"+(j+1)+"位");
                    dataArr.set(currentIndex, preData);
                    dataArr.set(j, currentData);
                    currentIndex=j;
                } else {
                    System.out.println(" 不交换");
                    break;
                }
                System.out.println("当前数组：" + dataArr);
            }
        }
        System.out.println("排序后数组：" + dataArr);
    }

}
