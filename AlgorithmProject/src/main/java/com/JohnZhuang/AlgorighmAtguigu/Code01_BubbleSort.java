package com.JohnZhuang.AlgorighmAtguigu;

/**
 * @author JohnZhuang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/7 9:11
 */
public class Code01_BubbleSort {

    public static void bubbleSort(int[] data) {
        if (data == null || data.length < 2) {
            System.out.println("数组输入有误！");
            return;
        }


        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);

                }
            }

//            printArray(data);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = { 9, -16, 21, 23, -30, -49, 21, 30, 30 };

        System.out.println("排序之前：");
        printArray(data);

        bubbleSort(data);

        System.out.println("排序之后：");
        printArray(data);
    }
}
