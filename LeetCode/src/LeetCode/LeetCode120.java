package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        list.add(-1);
        triangle.add(0,list);
        list = new LinkedList<>();
        list.add(2);
        list.add(3);
        triangle.add(1,list);
        list = new LinkedList<>();
        list.add(1);
        list.add(-1);
        list.add(-3);
        triangle.add(2,list);
        list = new LinkedList<>();
//        list.add(4);
//        list.add(1);
//        list.add(8);
//        list.add(3);
//        triangle.add(3,list);
        for (List<Integer> integers : triangle) {
            System.out.println(integers);
        }
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];
        if (triangle == null || size == 0){
            return 0;
        }
        //初始化
        for (int i = 0; i < triangle.get(size-1).size(); i++) {
            dp[size-1][i] = triangle.get(size-1).get(i);
        }
        //自底向上,第i行第j个数加上第i+1行的(第j个数和第j+1个数的最小值)即为当前位置的最短路径
        for (int i = size-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}
