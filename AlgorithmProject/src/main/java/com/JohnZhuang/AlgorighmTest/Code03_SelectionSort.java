package com.JohnZhuang.AlgorighmTest;

/**
 * @Description:
 * @Author: JohnZhuang1024
 * @Date: 2023/2/14 11:49
 * @Version: 1.0
 */
public class Code03_SelectionSort {

    // 选择排序方法
    public static void selectionSort(int[] arr) {
        if(arr == null || arr.length < 2){
            return;
        }
        int N = arr.length;
        for(int i = 0;i < N;i++){
            int minValueIndex = i;
            for(int j = i+1;j<N;j++){
                minValueIndex = arr[j]< arr[minValueIndex] ? j:minValueIndex;
            }
            swap(arr,i,minValueIndex);
        }

    }

    // 交换位置
    public static void swap(int[] arr,int x,int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    // 打印数组
    public static void printArray(int[] arr){
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arg = {8, 5, 6, 1, 9, 6, 8, 1, 18, 17};
        printArray(arg);
        selectionSort(arg);
        printArray(arg);
    }


}
