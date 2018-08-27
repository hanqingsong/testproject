package algorithm.sort;

import org.junit.Test;
import org.testng.collections.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by hanqingsong on 18/8/27.
 * 冒泡排序:它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
 * @author hanqingsong
 * @date 18/8/27
 */
public class BubbleSort {
    @Test
    public void testBubbleSort(){
        List<Integer> dataArr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(dataArr);
        System.out.println(dataArr);
        System.out.println("====基础版开始=====");
        this.doBubbleSort1(dataArr);
        System.out.println("====基础版结束=====");

        System.out.println("====flag版开始=====");
        this.doBubbleSort2(dataArr);
        System.out.println("====flag版结束=====");
    }

    /**
     * 基础版冒泡排序
     * 问题：如果数据在第一轮的时候就已经排好续，那么还会进行后面的比较，后面的比较没有意义了
     * 方案：设置flag，如果第一轮就没有交换，证明顺序已经排好了
     * @param dataArr
     */
    private void doBubbleSort1(List<Integer> dataArr) {
        List<Integer> copyList= Lists.newArrayList();
        copyList.addAll(dataArr);
        System.out.println(copyList);
        int arrSize = copyList.size();
        // arrSize-1 最后一轮已经排好续了
        for (int i = 0; i < arrSize-1; i++) {
            System.out.println("第 " +(i+1)+" 轮");
            for (int j = 0; j < arrSize - i-1; j++) {
                Integer integer1 = copyList.get(j);
                Integer integer2 = copyList.get(j+1);
                Integer temp = null;
                System.out.print("数值：【"+integer1+"】和【"+integer2+"】比较");
                // 升序排序
                if (integer1 > integer2) {
                    temp=integer1;
                    copyList.set(j, integer2);
                    copyList.set(j+1, temp);
                    System.out.println("，交换顺序");
                }else {
                    System.out.println("，不交换顺序");
                }
                System.out.println(copyList);
            }

        }
        System.out.println("=======排序结果======");
        System.out.println("原始数组"+dataArr);
        System.out.println("排序后数组"+copyList);
    }

    /**
     * flag版冒泡排序
     * @param dataArr
     */
    private void doBubbleSort2(List<Integer> dataArr) {
        List<Integer> copyList= Lists.newArrayList();
        copyList.addAll(dataArr);
        System.out.println(copyList);
        int arrSize = copyList.size();

        for (int i = 0; i < arrSize; i++) {
            System.out.println("第 " +(i+1)+" 轮");
            // 设置本轮默认没有交换
            boolean hasChange = false;
            for (int j = 0; j < arrSize - i-1; j++) {
                Integer integer1 = copyList.get(j);
                Integer integer2 = copyList.get(j+1);
                Integer temp = null;
                System.out.print("数值：【"+integer1+"】和【"+integer2+"】比较");
                // 升序排序
                if (integer1 > integer2) {
                    temp=integer1;
                    copyList.set(j, integer2);
                    copyList.set(j+1, temp);
                    System.out.println("，交换顺序");
                    hasChange=true;
                }else {
                    System.out.println("，不交换顺序");
                }
                System.out.println(copyList);
            }
            //如果没有交换，跳出轮询比较
            if (!hasChange) {
                System.out.println("第 " +(i+1)+" 轮，跳出排序");
                break;
            }

        }
        System.out.println("=======排序结果======");
        System.out.println("原始数组"+dataArr);
        System.out.println("排序后数组"+copyList);
    }

}
