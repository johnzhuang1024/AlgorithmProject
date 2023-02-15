package com.JohnZhuang.AlgorighmTest.class01;

/**
 * @Description:
 * @Author: JohnZhuang1024
 * @Date: 2023/2/15 9:30
 * @Version: 1.0
 */
public class Code05_InsertSort1 {

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

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0~0 完成
        // 0~1
        // 1~2
        // 2~3
        // ...
        // n-2~n-1
        int n = arr.length;
        for (int i = 1; i <= n - 1; i++) {
            int endNumindex = i;
            while(endNumindex-1 >= 0 && arr[endNumindex-1] > arr[endNumindex]){
                swap(arr,endNumindex-1,endNumindex);
                endNumindex--;
            }
        }


    }

    public static void main(String[] args) {
        int[] arg = {8, 5, 6, 1, 9, 6, 8, 1, 18, 17};
        printArray(arg);
        insertSort(arg);
        printArray(arg);
    }
}
