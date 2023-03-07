package com.JohnZhuang.AlgorighmAtguigu;

/**
 * @author JohnZhuang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/7 10:55
 */
public class Code03_QuickSort {
    public static void quick_sort(int[] data, int l, int r) {
        if (l < r) {
            int i = l, j = r, x = data[l];
            while (i < j) {
                while (i < j && data[j] >= x) {
                    j--;
                }
                if (i < j) {
                    data[i++] = data[j];
                }

                while (i < j && data[i] <= x) {
                    i++;
                }
                if (i < j) {
                    data[j--] = data[i];
                }
            }

            data[i] = x;
            quick_sort(data, l, i - 1);
            quick_sort(data, i + 1, r);
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {9, -16, 21, 23, -30, -49, 21, 30, 30, 30, 30};

        quick_sort(data, 0, data.length - 1);

        printArray(data);
    }
}
