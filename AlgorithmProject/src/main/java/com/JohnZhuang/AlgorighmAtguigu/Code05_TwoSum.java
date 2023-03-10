package com.JohnZhuang.AlgorighmAtguigu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JohnZhuang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/10 9:24
 */
public class Code05_TwoSum {
    // 用时：0ms
    // 内存：41.7M
    public int[] twoSum_Ans(int[] nums, int target) {

        // int[] index = new int[2];
        // for(int i=0;i<nums.length;i++){
        //     for(int j = 1;j<nums.length - i; j++){
        //         if(nums[j-1]+nums[j] == target){
        //            index[0] = j-1;
        //            index[1] = j;
        //         }
        //     }
        // }
        // return index;
        int[] res = new int[2];

        Map<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            if (map.containsKey(nums[left])){
                res[0] = left;
                res[1] = map.get(nums[left]);
                if (left > map.get(nums[left])){
                    res[0] = map.get(nums[left]);
                    res[1] = left;
                }
                // 3 2 4    3 4 2
                return res;

            }else {
                map.put(target-nums[left],left); // 3 0, 4 1 ,
            }

            if (map.containsKey(nums[right])){
                res[0] = right;
                res[1] = map.get(nums[right]);
                if (left > map.get(nums[right])){
                    res[0] = map.get(nums[right]);
                    res[1] = right;
                }
                // 3 2 4    3 4 2
                return res;

            }else {
                map.put(target-nums[right],right); // 3 0, 4 1 ,
            }

            left ++;
            right --;
        }


        return res;
    }

    // 用时：34ms
    // 内存：41.7M
    int a, b;
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] == complement){
                    a = i;
                    b = j;
                }
            }
        }
        int[] result = {a,b};
        return result;
    }
}
