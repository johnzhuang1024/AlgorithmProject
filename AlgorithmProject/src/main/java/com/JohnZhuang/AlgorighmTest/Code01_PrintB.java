package com.JohnZhuang.AlgorighmTest;

/**
 * @Description:
 * @Author: JohnZhuang1024
 * @Date: 2023/2/14 9:29
 * @Version：1.0
 */
public class Code01_PrintB {
    public static void main(String[] args){
        print(8);
    }

    // 打印32位整数
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}

