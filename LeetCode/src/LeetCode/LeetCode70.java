package LeetCode;

public class LeetCode70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(9));
    }

    public static int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        //动态规划,达到最后一层楼梯的两种可能,一种是从n-1走到n,另一种是从n-2走到n
        int[] dp = new int[n];
        //走到第一层只有一种走法
        dp[0] = 1;
        //走到第二层有两种走法
        dp[1] = 2;
        for(int i = 2; i < n; i++){
            //在第n层有num[i-1]  + num[i-2]种走法
            dp[i] = dp[i-1]+dp[i-2];
        }
        //数组中存的每个数就代表走到该层楼的方法数量
        return dp[n-1];
    }
}