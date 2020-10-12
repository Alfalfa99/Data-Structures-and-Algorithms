package LeetCode;

import util.ListNode;
import util.TreeNode;

import java.util.*;

public class LeetCode0_Test {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2, 5, 10, 1}, 27));
    }

    public static int coinChange(int[] coins, int amount) {
        int len = coins.length;
        if (len == 0){
            return -1;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int coin : coins){
            for(int i = coin; i <= amount; i++){
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        if(dp[amount] == amount+1){
            dp[amount] = -1;
        }
        return dp[amount];
    }
}
