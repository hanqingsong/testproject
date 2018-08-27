package algorithm.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by hanqingsong on 18/8/27.
 * 选择排序(Selection-sort)是一种简单直观的排序算法。
 * 它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * @author hanqingsong
 * @date 18/8/27
 */
public class SelectionSort {
    @Test
    public void testSelectionSort(){
        List<Integer> dataArr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(dataArr);
        System.out.println(dataArr);
        System.out.println("====doSelectionSort开始=====");
        this.doSelectionSort(dataArr);
        System.out.println("====doSelectionSort结束=====");
    }

    /**
     *
     * @param dataArr
     */
    public void doSelectionSort(List<Integer> dataArr) {
        int size = dataArr.size();
        int minIndex ;
        int temp ;
        for (int i = 0; i < size-1; i++) {
            System.out.println("第 "+ (i+1) +"次选择");
            // 当前位置
            minIndex=i;
            // 找出比当前位置小的数
            for (int j = i; j < size; j++) {
                if (dataArr.get(j) < dataArr.get(minIndex)) {
                    minIndex = j;
                }
            }

            temp = dataArr.get(i);
            Integer minData = dataArr.get(minIndex);
            System.out.print("最小数：【" + minData + "】和【" + temp + "】交换");

            dataArr.set(i, minData);
            dataArr.set(minIndex, temp);

            System.out.println(" 交换之后数组 " + dataArr);
        }
        System.out.println("排序后数组："+ dataArr);
    }
}
