package LeetCode;

public class LeetCode264 {
    public static void main(String[] args) {

    }

    public int nthUglyNumber(int n) {
        int a = 0, b= 0,c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            int ac = dp[a] * 2, bc = dp[b] * 3, cc = dp[c] * 5;
            dp[i] = Math.min(Math.min(ac,bc),cc);
            if (dp[i] == ac){
                a++;
            }
            if(dp[i] == bc){
                b++;
            }
            if(dp[i] == cc){
                c++;
            }
        }
        return dp[n-1];
    }
}
