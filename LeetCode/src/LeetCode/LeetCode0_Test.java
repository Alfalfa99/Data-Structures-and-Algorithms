package LeetCode;

import util.TreeNode;

import java.util.*;

public class LeetCode0_Test {
    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        s = s.toLowerCase();
        while(left < right){
            char l = s.charAt(left);
            if((l > 'z' || l < 'a') && (l < '0' || l > '9')){
                left++;
                continue;
            }
            char r = s.charAt(right);
            if((r > 'z' || r < 'a') && (r < '0' || r > '9')){
                right--;
                continue;
            }
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            } else{
                return false;
            }
        }
        return true;
    }
}
