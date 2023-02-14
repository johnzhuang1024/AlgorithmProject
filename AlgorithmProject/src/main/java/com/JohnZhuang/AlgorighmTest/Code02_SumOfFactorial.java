package com.JohnZhuang.AlgorighmTest;

import sun.util.calendar.BaseCalendar;

import java.util.Date;

/**
 * @Description:
 * @Author: JohnZhuang1024
 * @Date: 2023/2/14 11:18
 * @Version:1.0
 */
public class Code02_SumOfFactorial {
    public static void main(String[] args){
//        System.out.println(factorial(5));
        long time_f1_start = System.nanoTime();
        System.out.println(f1(10));
        long time_f1_end = System.nanoTime();
        System.out.println("f1的运行时间是：" + (time_f1_end-time_f1_start));

        long time_f2_start = System.nanoTime();
        System.out.println(f2(10));
        long time_f2_end = System.nanoTime();
        System.out.println("f2的运行时间是：" + (time_f2_end-time_f2_start));

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
