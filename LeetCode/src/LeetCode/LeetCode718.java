package LeetCode;

public class LeetCode718 {
    public static void main(String[] args) {
        int[] A  = new int[]{0,1,1,1,1};
        int[] B  = new int[]{1,0,1,0,1};
        System.out.println(findLength(A,B));
    }

    public static int findLength(int[] A, int[] B) {
        int max = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
