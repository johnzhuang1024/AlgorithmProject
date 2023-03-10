package com.JohnZhuang.AlgorighmAtguigu;

import java.util.ArrayList;

/**
 * @author JohnZhuang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/10 9:53
 */
public class Code06_ClimbStairs {
    // 用时：0ms
    // 内存：38.2M
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }

        int[] pace = new int[n];
        pace[1-1] = 1;
        pace[2-1] = 2;

        for(int i = 3; i <= n; i++){
            pace[i-1] = pace[i-1-1] + pace[i-2-1];
        }

        ArrayList<Integer> ints = new ArrayList<Integer>();



        return pace[n-1];
    }

    // 用时：0ms
    // 内存：38.4M
    public int climbStairs_Ans(int n) {
        if (n<=2){
            return n;
        }
        int i1=1;
        int i2=2;
        for (int i=3;i<=n;i++){
            int temp=i2;
            i2=i1+i2;
            i1=temp;
        }
        return i2;
    }
}
