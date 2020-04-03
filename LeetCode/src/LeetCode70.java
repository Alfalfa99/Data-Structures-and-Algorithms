public class LeetCode70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(9));
    }

    public static int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        //动态规划,达到最后一层楼梯的两种可能,一种是从n-1走到n,另一种是从n-2走到n
        int[] num = new int[n+1];   //num[0]不使用
        num[1] = 1; //走到第一层只有一种走法
        num[2] = 2; //走到第二层有两种走法
        for (int i = 3; i < n + 1; i++) {
            num[i] = num[i-1]+num[i-2]; //在第n层有num[i-1]  + num[i-2]种走法
        }
        return num[n];//数组中存的每个数就代表走到该层楼的方法数量
    }
}