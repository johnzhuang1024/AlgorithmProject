package com.JohnZhuang.AlgorighmAtguigu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author JohnZhuang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/9 9:01
 */
public class Code04_MergeSort {
    public static int[] sort(int[] data) {
        if (data.length < 2) {
            return data;
        }

        int[] tmp_data = Arrays.copyOf(data, data.length);

        int mid = tmp_data.length / 2;

        int[] left_data = Arrays.copyOfRange(tmp_data, 0, mid);
        int[] right_data = Arrays.copyOfRange(tmp_data, mid, data.length);

        return merge(sort(left_data), sort(right_data));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result_data = new int[left.length + right.length];
        int i = 0;

        while (left.length > 0 & right.length > 0) {
            if (left[0] <= right[0]) {
                result_data[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result_data[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result_data[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result_data[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result_data;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        int[] data = {9, -16, 21, 23, -30, -49, 21, 30, 30, 30, 30, -49};

        int[] sort = sort(data);

        printArray(sort);
    }
}