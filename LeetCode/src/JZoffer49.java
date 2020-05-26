public class JZoffer49 {
    public static void main(String[] args) {

    }

    public static int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        //1是丑数
        dp[0] = 1;
        // 从1开始
        for (int i = 1; i < n; i++) {
            //从小到大计算出每个丑数
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            //将较小的丑数先放进dp数组
            dp[i] = Math.min(Math.min(n2,n3),n5);
            //每个条件都必须独立判断,因为可能有一个数同时满足两个丑数的方式,如6,又会被n2计算一次,又会被n3计算一次,所以要判断
            if (dp[i] == n2){
                a++;
            }
            if (dp[i] == n3){
                b++;
            }
            if (dp[i] == n5){
                c++;
            }
        }
        return dp[n-1];
    }

}