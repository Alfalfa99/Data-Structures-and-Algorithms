import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new ArrayList<>();
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        List<Integer> res = new ArrayList<>();
        while(true) {
            for(int i = l; i <= r; i++) res.add(matrix[t][i]); // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res.add(matrix[i][r]); // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res.add(matrix[b][i]); // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res.add(matrix[i][l]); // bottom to top.
            if(++l > r) break;
        }
        return res;
    }
}