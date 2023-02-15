package com.JohnZhuang.AlgorighmTest;

/**
 * @Description:
 * @Author: JohnZhuang1024
 * @Date: 2023/2/15 9:08
 * @Version:1.0
 */
public class Code04_BubbleSort {
    // 打印数组
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 交换位置
    public static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void bubbleSort(int[] arr) {
        //0~n-1 0~n-2 0~n-3
        int n = arr.length;
        for (int i = n - 1; n > 0; n--) {
            //0~1 1~2 2~3 n-1~n
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }


    }

    public static void main(String[] args) {
        int[] arg = {8, 5, 6, 1, 8, 6, 8, 1, 9, 18};
        printArray(arg);
        bubbleSort(arg);
        printArray(arg);
    }
}
