package com.JohnZhuang.AlgorighmTest.class03;

import java.util.Arrays;

/**
 * @Description:
 * @Author: JohnZhuang1024
 * @Date: 2023/2/17 9:42
 * @Version: 1.0
 */
public class Code03_BSNearRight {
    public static int mostRightNoLessNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int L = 0;
        int R = arr.length - 1;
        int t = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] <= num) {
                t = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        return t;
    }

    public static int test(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= num) {
                return i;
            }
        }

        return -1;
    }

    // 产生随机数组
    public static int[] generateArray(int maxLength, int maxValue) {
        int[] arr = new int[(int) ((maxLength + 1) * Math.random())];
        for (int i = 0; i <= arr.length - 1; i++) {
//            arr[i] = (int) (maxValue * Math.random());// 全非负数
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());// 所有整数
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int timeTest = 100000;
        int maxValue = 10;
        int maxLength = 100;
        boolean succeed = true;
        for (int i = 1; i <= timeTest; i++) {
            int[] arr1 = generateArray(maxLength, maxValue);
            Arrays.sort(arr1);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr1, value) != mostRightNoLessNumIndex(arr1, value)) {
                printArray(arr1);
                System.out.println(value);
                System.out.println(mostRightNoLessNumIndex(arr1, value));
                System.out.println(test(arr1, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "right!" : "incorrect!");

    }
}
