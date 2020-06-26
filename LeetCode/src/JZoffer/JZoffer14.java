package JZoffer;

public class JZoffer14 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(120));
    }

    /**
     * 从底向上,每一个数的最大乘积都来源于之前的某一个数或当前的两数相乘
     *
     */
    public static int cuttingRope1(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(Math.max(j*(i-j),dp[i-j]*j),dp[i]);
            }
        }
        return dp[n];
    }

    public static int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        long res=1L;
        int p=(int)1e9+7;
        //贪心算法，优先切三，其次切二
        while(n>4){
            res=res*3%p;
            n-=3;
        }
        //出来循环只有三种情况，分别是n=2、3、4
        return (int)(res*n%p);
    }
}
