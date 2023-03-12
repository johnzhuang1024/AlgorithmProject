package com.JohnZhuang.AlgorighmAtguigu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author JohnZhuang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/12 10:14
 */
public class Code10_LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    int start = 0;
    int end = 0;

    public String longestPalindrome_Ans(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] c = s.toCharArray();
        longestPalindromeAt(c, 0);
        return s.substring(start, end + 1);
    }

    private void longestPalindromeAt(char[] c, int p) {
        int a = p;
        int b = p;
        int n = c.length;
        if (p == (n - 1) || (n - p) < (end - start + 1) / 2) return;
        while (b < n - 1 && c[b] == c[b + 1]) b++;
        p = b;
        while (a > 0 && b < n - 1 && c[a - 1] == c[b + 1]) {
            a--;
            b++;
        }
        if ((end - start) < (b - a)) {
            end = b;
            start = a;
        }
        longestPalindromeAt(c, ++p);
    }
}
