package LeetCode;


import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {
    public static void main(String[] args) {

    }

    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if(matrix.length == 0 || matrix[0].length == 0){
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<>();
            int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
            while(true){
                for(int i = left; i <= right; i++){
                    res.add(matrix[top][i]);
                }
                if(++top > bottom){
                    break;
                }
                for(int i = top; i <= bottom; i++){
                    res.add(matrix[i][right]);
                }
                if(--right < left){
                    break;
                }
                for(int i = right; i >= left; i--){
                    res.add(matrix[bottom][i]);
                }
                if(--bottom < top){
                    break;
                }
                for(int i = bottom; i >= top; i--){
                    res.add(matrix[i][left]);
                }
                if(++left > right){
                    break;
                }
            }
            return res;
        }
    }
}

