package com.JohnZhuang.AlgorighmTest.class02;

/**
 * @Description:
 * @Author: JohnZhuang1024
 * @Date: 2023/2/15 12:59
 * @Version: 1.0
 */
public class Code01_PreSum {

    public static void main(String[] args){

        int[] ints = {1,2,3,4,8,6,3,4,6,8,4};

        RangeSum1 rangeSum1 = new RangeSum1(ints);
        RangeSum2 rangeSum2 = new RangeSum2(ints);

        long start1 = System.nanoTime();
        System.out.println(rangeSum1.rangeSum(1, 5));
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        System.out.println(rangeSum2.rangeSum(1, 5));
        long end2 = System.nanoTime();

        System.out.println(end1-start1);// 147100
        System.out.println(end2-start2);// 20800





    }

    public static class RangeSum1 {

        private int[] arr;

        public RangeSum1(int[] array) {
            arr = array;
        }

        public int rangeSum(int L, int R) {
            int sum = 0;
            for (int i = L; i <= R; i++) {
                sum += arr[i];
            }
            return sum;
        }

    }

    public static class RangeSum2 {

        private int[] preSum;

        public RangeSum2(int[] array) {
            int N = array.length;
            preSum = new int[N];
            preSum[0] = array[0];
            for (int i = 1; i < N; i++) {
                preSum[i] = preSum[i - 1] + array[i];
            }
        }

        public int rangeSum(int L, int R) {
            return L == 0 ? preSum[R] : preSum[R] - preSum[L - 1];
        }

    }
}
