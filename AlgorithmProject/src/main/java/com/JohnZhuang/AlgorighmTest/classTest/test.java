package com.JohnZhuang.AlgorighmTest.classTest;

/**
 * @Description:
 * @Author: JohnZhuang1024
 * @Date: 2023/2/16 10:59
 * @Version: 1.0
 */
public class test {
    public static void main(String[] args) {
        print(3);
        print(3<<2);
    }

    public static void test1(){

    }


    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}
