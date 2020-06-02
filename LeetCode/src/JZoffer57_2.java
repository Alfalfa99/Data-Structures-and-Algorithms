import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JZoffer57_2 {
    public static void main(String[] args) {

    }

    public static int[][] findContinuousSequence(int target) {
        int left = 1,right = 1;
        int sum = 0;
        List<int[]> list = new ArrayList<>();
        while (left <= target/2){
            if (sum < target){
                sum+=right;
                right++;
            } else if (sum > target){
                sum-=left;
                left++;
            } else {
                int[] arr = new int[right-left];
                for (int i = right; i < left; i++) {
                    arr[i-right] = right;
                }
                list.add(arr);
                sum-=right;
                left++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
