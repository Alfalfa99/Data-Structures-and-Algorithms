package LeetCode;

import util.TreeNode;

import java.util.*;

public class LeetCode0_Test {
    public static void main(String[] args) {
        System.out.println(strStr("mississippi","issip"));

    }
    public static int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        if(nLen == 0){
            return 0;
        }
        int res = -2;
        char[] hay = haystack.toCharArray();
        char[] nel = needle.toCharArray();
        for(int i = 0,j = 0; i< hLen; i++){
            if(hay[i] == nel[j]){
                j++;
                if(res == -2){
                    res = i;
                }
            } else{
                j = 0;
                res = -2;
            }
            if(j == nLen){
                return res;
            }
        }
        return -1;
    }
}
