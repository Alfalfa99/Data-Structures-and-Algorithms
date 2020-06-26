package LeetCode;

import java.util.HashMap;

public class LeetCode136 {
    public static void main(String[] args) {
        int[] s = {5,2,3,4,5,2,3,4,6};
        System.out.println(singleNumber(s));
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}