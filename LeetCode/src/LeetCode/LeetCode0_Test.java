package LeetCode;

import java.util.*;

public class LeetCode0_Test {
    public static void main(String[] args) {

    }
    public static int height;
    public static int width;
    public static int[][] matri = null;
    public static int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        matri = matrix;
        height = matrix.length;
        width = matrix[0].length;
        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                max = Math.max(dfs(0,i,j,Integer.MIN_VALUE),max);
            }
        }
        return max;
    }
    public static int dfs(int maxLen,int i, int j, int lastVal){
        if (i < 0 || i >= height || j < 0 || j >= width){
            return maxLen;
        }
        int curVal = matri[i][j];
        if (curVal <= lastVal){
            return maxLen;
        }
        return Math.max(dfs(maxLen+1, i+1, j, curVal),
                Math.max(dfs(maxLen+1, i-1, j, curVal),
                        Math.max(dfs(maxLen+1, i, j+1, curVal),
                                dfs(maxLen+1, i, j-1, curVal))));
    }
}
