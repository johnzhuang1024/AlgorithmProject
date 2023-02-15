package com.JohnZhuang.AlgorighmTest.class01;

/**
 * @Description:
 * @Author: JohnZhuang1024
 * @Date: 2023/2/14 9:29
 * @Version: 1.0
 */
public class Code01_PrintB {
    public static void main(String[] args){

        print(8);        // 00000000000000000000000000001000

        // 最大整形2^31-1
        // 最高位留给符号
        print(Integer.MAX_VALUE);        // 01111111111111111111111111111111
        System.out.println(Integer.MAX_VALUE);        // 2147483647

        // 负数的时候，后面31位全取反+1
        print(-1);        // 11111111111111111111111111111111

        // 最小整形-2^31
        print(Integer.MIN_VALUE);        // 10000000000000000000000000000000
        System.out.println(Integer.MIN_VALUE);        // -2147483648

        // 取反
        int b = 32156416;
        int c = ~b;
        System.out.println(b);        // 32156416
        System.out.println(c);        // -32156417
        print(b);      //00000001111010101010101100000000
        print(c);      //11111110000101010101010011111111

        // 玩法
        int d = 515613;
        int e = 846513515;
        print(d);// 00000000000001111101111000011101
        print(e);// 00110010011101001100010101101011
        System.out.println("==========");
        print(d | e);// 00110010011101111101111101111111(两数有1的取1，否则取0)
        print(d & e);// 00000000000001001100010000001001(两数都为1的取1，否则取0)
        print(d ^ e);// 00110010011100110001101101110110(两数不同取1，相同取0)

        // 右移
        int f = Integer.MIN_VALUE;
        print(f);// 10000000000000000000000000000000
        print(f >> 1 );// 11000000000000000000000000000000(带符号右移)
        print(f >>> 1 );// 01000000000000000000000000000000(不带符号右移)

        // 相反数
        int g = 5;
        System.out.println(g);
        int h = -g;
        System.out.println(h);
        h = (~g + 1);
        System.out.println(h);

        // 系统最小取反还是本身
        int i = Integer.MIN_VALUE;
        print(i);//
        print(-i);// 10000000000000000000000000000000 = 01111111111111111111111111111111 + 1
        System.out.println(i);
        System.out.println(-i);






    }

    // 打印32位整数
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }





}

