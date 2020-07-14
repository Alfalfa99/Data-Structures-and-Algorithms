package LeetCode;

import java.util.*;

public class LeetCode0_Test {
    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        if (height == 0){
            return 0;
        }
        for (int i = height-2; i >= 0 ; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j,triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
