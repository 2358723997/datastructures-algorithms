package com.gupaoedu.vip.algorithms.sort;

import com.alibaba.fastjson.JSON;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Sort类
 *
 * 时间复杂度为：O(n^2)排序算法：冒泡排序、插入排序、选择排序，其中前两者是原地排序算法。
 * @author wangjixue
 * @date 4/15/21 8:59 AM
 */
public class Sort {
    public static int DEFAULT_LENGTH = 10000;

    public static void main(String[] args) {

        int[] randomArray = new int[DEFAULT_LENGTH];

        //for (int i = 0; i < DEFAULT_LENGTH; i++) {
        //    randomArray[i] = (int)(Math.random() * DEFAULT_LENGTH);
        //}
        //System.err.println("originArray=" + JSON.toJSONString(randomArray));
        //System.out.println("-------------------------");

        //冒泡排序
        System.err.println("Bubble Sort->");
        long start = System.currentTimeMillis();
        for (int k = 0; k < 10; k++) {
            for (int j = 0; j < randomArray.length; j++) {
                randomArray[j] =(int)(Math.random() * DEFAULT_LENGTH);
            }
            bubbleSort(randomArray);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        //插入排序
        System.err.println("Insert Sort->");
        long start1 = System.currentTimeMillis();
        for (int k = 0; k < 10; k++) {
            for (int j = 0; j < randomArray.length; j++) {
                randomArray[j] =(int)(Math.random() * DEFAULT_LENGTH);
            }
            insertSort(randomArray);
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);


        //选择排序
        System.err.println("Select Sort->");
        long start2 = System.currentTimeMillis();
        for (int k = 0; k < 10; k++) {
            for (int j = 0; j < randomArray.length; j++) {
                randomArray[j] =(int)(Math.random() * DEFAULT_LENGTH);
            }
            selectSort(randomArray);
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);

    }


    /**
     * 冒泡排序 原理：比较两个相邻元素，如果前面的元素大于后面的元素则交互两者的顺序，直到整个数组全部有序。
     *
     * @param randomArray
     * @return
     */
    private static int[] bubbleSort(int[] randomArray) {
        for (int i = 0; i < DEFAULT_LENGTH; i++) {

            for (int j = 1; j < DEFAULT_LENGTH; j++) {
                //前面的元素大于后面的元素
                if(randomArray[j-1] > randomArray[j]){
                    int tempData = randomArray[j-1];
                    randomArray[j-1] = randomArray[j];
                    randomArray[j] = tempData;
                }
            }

        }
        return randomArray;
    }

    /**
     * 插入排序 原理：将待排序数组分为已排序区间和未排序区间，每次将未排序区间的第一位元素与已排序区间元素进行比对，并插入到已排序区间，循环操作直到全部有序。
     *
     * @param randomArray
     * @return
     */
    private static int[] insertSort(int[] randomArray) {
        //未排序区间的第一位元素
        int index = 1;

        //从已排序区间尾部开始比较
        while (index < DEFAULT_LENGTH) {
            int current = randomArray[index];
            for (int i = index - 1; i > 0; i--) {
                if (randomArray[i] <= current) {
                    break;
                }
                int tempData = randomArray[i];
                randomArray[i] = current;
                randomArray[i + 1] = tempData;
            }
            index++;
        }
        return randomArray;
    }

    /**
     * 选择排序 原理：将待排序数组分为已排序区间和未排序区间，每次将未排序区间的最小元素与已排序区间元素进行比对，并插入到已排序区间，循环操作直到全部有序。
     *
     * @param randomArray
     * @return
     */
    private static int[] selectSort(int[] randomArray) {
        for (int i = 0; i < DEFAULT_LENGTH; i++) {
            //查找未排序区间最小值下标
            int minIndex = i;
            for (int j = i+1; j < DEFAULT_LENGTH; j++) {
                if(randomArray[j] < randomArray[minIndex]){
                    minIndex = j;
                }
            }
            int tempData = randomArray[i];
            randomArray[i] = randomArray[minIndex];
            randomArray[minIndex] = tempData;

        }
        return randomArray;
    }
}
