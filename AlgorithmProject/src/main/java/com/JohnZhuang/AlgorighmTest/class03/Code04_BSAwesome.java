package com.JohnZhuang.AlgorighmTest.class03;

/**
 * @Description:
 * @Author: JohnZhuang1024
 * @Date: 2023/2/17 10:29
 * @Version: 1.0
 */
public class Code04_BSAwesome {

    // arr 相邻的数不相等！！
    public static int oneMinIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int N = arr.length;
        if (N == 1) return 0;
        if (arr[0] < arr[1]) return 0;
        if (arr[N - 1] < arr[N - 2]) return N - 1;

        int L = 0;
        int R = N - 1;
        while (L < R - 1) {
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return arr[L] < arr[R] ? L : R;
    }

    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (maxLen * Math.random());
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i <= arr.length - 1; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    public static boolean check(int[] arr, int minIndex) {
        if (arr == null || arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right <= arr.length - 1 ? arr[right] > arr[minIndex] : true;

        return leftBigger && rightBigger;
    }

    public static void printArray(int[] arr){
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int testTime = 1000000;
        int maxValue = 200;
        int maxLen = 100;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = randomArray(maxLen, maxValue);
//            printArray(arr1);
            int ans = oneMinIndex(arr1);
            if(!check(arr1,ans)){
                printArray(arr1);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("测试结束!");
    }

}