package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode119 {
    public static void main(String[] args) {
        for (Integer list : getRow(5)) {
            System.out.println(list);
        }
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> cur = new ArrayList<>();
        if (rowIndex == 0){
            return cur;
        }
        cur.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                cur.set(j, cur.get(j - 1) + cur.get(j));
            }
            cur.add(1);//补上每层的最后一个 1
        }
        return cur;
    }
}