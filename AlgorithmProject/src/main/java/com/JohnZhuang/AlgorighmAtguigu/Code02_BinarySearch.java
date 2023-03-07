package com.JohnZhuang.AlgorighmAtguigu;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author JohnZhuang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/7 9:36
 */
public class Code02_BinarySearch {
    public static int binarySearch(int[] data, int x) {
        Code01_BubbleSort.bubbleSort(data);
        Code01_BubbleSort.printArray(data);

        int left = 0;
        int right = data.length - 1;
        int mid = (left + right) / 2;
        int index_X = -1;

        while (right >= left) {
            if (x == data[mid]) {
                index_X = mid;
                break;
            } else if (x > data[mid]) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else {
                right = mid - 1;
                mid = (left + right) / 2;
            }
        }

        return index_X;
    }

    public static ArrayList binarySearch02(int[] data, int x) {
        Code01_BubbleSort.bubbleSort(data);
        Code01_BubbleSort.printArray(data);

        int left = 0;
        int right = data.length - 1;
        int mid = (left + right) / 2;
        ArrayList<Integer> index_X = new ArrayList<Integer>();

        while (right >= left) {
            if (x == data[mid]) {
                index_X.add(mid);
                break;
            } else if (x > data[mid]) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else {
                right = mid - 1;
                mid = (left + right) / 2;
            }
        }

        for (int i = mid+1; i < data.length; i++) {
            if(data[i] == x){
                index_X.add(i);
            }
        }

        for (int i = mid-1; i >= 0; i--) {
            if(data[i] == x){
                index_X.add(i);
            }
        }

        index_X.sort(Comparator.naturalOrder());
        return index_X;
    }

    public static void main(String[] args){
        int[] data = { 9, -16, 21, 23, -30, -49, 21, 30, 30,30,30 };

        System.out.println(binarySearch02(data, 30));
    }
}
