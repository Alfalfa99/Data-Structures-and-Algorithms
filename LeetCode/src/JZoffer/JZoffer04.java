package JZoffer;

public class JZoffer04 {
    public static void main(String[] args) {

    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int height = matrix.length;
        if(height == 0){
            return false;
        }
        int width = matrix[0].length;
        if(width == 0){
            return false;
        }
        for (int i = width-1, j = 0; i >= 0 && j<height;){
            if(matrix[j][i] <target){
                j++;
                continue;
            }
            if(matrix[j][i] > target){
                i--;
                continue;
            }
            if(matrix[j][i] == target){
                return true;
            }
        }
        return false;
    }
}
