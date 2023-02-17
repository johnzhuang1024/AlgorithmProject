package com.JohnZhuang.AlgorighmTest.class03;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description:
 * @Author: JohnZhuang1024
 * @Date: 2023/2/17 8:43
 * @Version: 1.0
 */
public class Code01_BSExist {

    // 前提arr有序
    public static boolean find(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;

        while (L <= R) {
            int mid = (R + L) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                R = mid - 1;
            } else if (arr[mid] < num) {
                L = mid + 1;
            }
        }
        return false;
    }

    // 暴力遍历算法
    // 前提arr有序
    public static boolean test(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    // 产生随机数组
    public static int[] generateArray(int maxLength, int maxValue) {
        int[] arr = new int[(int) ((maxLength + 1) * Math.random())];
        for (int i = 0; i <= arr.length-1; i++) {
//            arr[i] = (int) (maxValue * Math.random());// 全非负数
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());// 所有整数
        }
        return arr;
    }

    public static void main(String[] args) {
        int timeTest = 100000;
        int maxValue = 10;
        int maxLength = 100;
        boolean succeed = true;
        for(int i = 1; i <= timeTest;i++){
            int[] arr1 = generateArray(maxLength, maxValue);
            Arrays.sort(arr1);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if(test(arr1,value) != find(arr1,value)){
                succeed = false;
                break;
            }
        }
        System.out.println(succeed?"right!":"incorrect!");

    }

}
