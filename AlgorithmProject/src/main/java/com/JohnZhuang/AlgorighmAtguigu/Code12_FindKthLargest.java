package com.JohnZhuang.AlgorighmAtguigu;

import java.util.Random;

/**
 * @author JohnZhuang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/13 9:34
 */
public class Code12_FindKthLargest {
    int[] nums;

    public void swap(int a, int b) {
        int tmp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = tmp;
    }

    public int partition(int left, int right, int pivot_index) {
        int pivot = this.nums[pivot_index];
        // 1. move pivot to end
        swap(pivot_index, right);
        int store_index = left;
        // 2. move all smaller elements to the left
        for (int i = left; i <= right; i++) {
            if (this.nums[i] < pivot) {
                swap(store_index, i);
                store_index++;
            }
        }
        // 3. move pivot to its final place
        swap(store_index, right);

        return store_index;
    }

    public int quickselect(int left, int right, int k_smallest) {
         /*
         Returns the k-th smallest element of list within left..right.
         */
        if (left == right) // If the list contains only one element,
            return this.nums[left]; // return that element
        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        pivot_index = partition(left, right, pivot_index);
        // the pivot is on (N - k)th smallest position
        if (k_smallest == pivot_index) return this.nums[k_smallest];
            // go left side
        else if (k_smallest < pivot_index) return quickselect(left, pivot_index - 1, k_smallest);
        // go right side
        return quickselect(pivot_index + 1, right, k_smallest);
    }

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;

        int size = nums.length;
        // kth largest is (N - k)th smallest
        return quickselect(0, size - 1, size - k);
    }

    public static int findKthLargest_Ans(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        int[] note = new int[max - min + 1];

        for (int num : nums) {
            note[num - min]++;
        }

        for (int i = note.length - 1; i >= 0; i--) {
            k -= note[i];

            if (k <= 0) {
                return i + min;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {8,6,7,9,3,5,3,4,2};

        int kthLargest_ans = findKthLargest_Ans(a, 5);

        System.out.println(kthLargest_ans);
    }
}
