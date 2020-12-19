package LeetCode;


public class LeetCode48 {
    public static void main(String[] args) {

    }

    static class Solution {
        public void rotate(int[][] matrix) {
            if (matrix.length == 0) {
                return;
            }
            int pos1 = 0, pos2 = matrix.length - 1;
            while (pos1 < pos2) {
                int add = 0, tmp;
                while (add < pos2 - pos1) {
                    tmp = matrix[pos1][pos1 + add];
                    matrix[pos1][pos1 + add] = matrix[pos2 - add][pos1];
                    matrix[pos2 - add][pos1] = matrix[pos2][pos2 - add];
                    matrix[pos2][pos2 - add] = matrix[pos1 + add][pos2];
                    matrix[pos1 + add][pos2] = tmp;
                    add++;
                }
                pos1++;
                pos2--;
            }
        }
    }
}

