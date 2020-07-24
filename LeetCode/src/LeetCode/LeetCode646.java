package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode646 {
    public static void main(String[] args) {

    }

    public int findLongestChain(int[][] pairs) {
        // 贪心
        // 转换为求：最多的不重叠区间的个数
        // 核心思想：尽可能多的有不重叠的区间，所以取end小的区间,这样后边才有位置放其他的区间(其实也就是有更多的数对)
        // 1.定义排序：按照每个数对的end从小到大排序
        // 2.遍历：pre_end < cur_start 才可以进行数对连接
        Arrays.sort(pairs,(a, b)->a[1]-b[1]);
        int preEnd = Integer.MIN_VALUE;
        int count=0;
        for(int[] curPair : pairs){
            if(preEnd < curPair[0]){
                count++;
                preEnd = curPair[1];
            }
        }
        return count;



        // 动规
        // 1.定义排序：按照每个数对的start从小到大排序
//         Arrays.sort(pairs,(a,b)->a[0]-b[0]);
//         // dp[i],以第i个数对结尾的链的最大长度
//         int[] dp = new int[pairs.length];
//         // 2.初始状态
//         Arrays.fill(dp,1);
//         for(int i=0;i<pairs.length;i++){
//             for(int j=0;j<i;j++){
//                 if(pairs[j][1] <  pairs[i][0]){
//                     // 3.转移方程
//                     // 若dp[j]+1较大 ,则说明在dp[j]之后接上一个dp[i]数对能使得链更长
//                     // 若dp[i]较大,这说明在dp[j]之后接上一个dp[i]数对反而使数对更短
//                     dp[i] = Math.max(dp[i],dp[j]+1);
//                 }
//             }
//         }
//         // 4.取dp数组中长度最大的
//         int max = 0;
//         for(int len : dp){
//             max = Math.max(len,max);
//         }
//         return max;
    }
}
