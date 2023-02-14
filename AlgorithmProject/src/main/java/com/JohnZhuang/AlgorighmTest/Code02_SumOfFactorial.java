package com.JohnZhuang.AlgorighmTest;

/**
 * @Description:
 * @Author: JohnZhuang1024
 * @Date: 2023/2/14 11:18
 * @Version：1.0
 */
public class Code02_SumOfFactorial {
    public static void main(String[] args){
        System.out.println(factorial(5));
        System.out.println(f1(3));
        System.out.println(f2(3));

    }

    // 阶乘
    public static long factorial(int num){
        long x = 1;
        for(int i = 1; i <= num ; i++){

            x *= i;
        }
        return x;
    }

    // f1方法
    public static long f1(int num){
        long x = 0;
        for (int i = 1; i <= num; i++){
            x += factorial(i);
        }
        return x;
    }

    public static long f2(int num){
        long x = 0;
        long y = 1;
        for(int i = 1; i <= num; i++){
            y = i*y;
            x += y;
        }
        return x;
    }
}
