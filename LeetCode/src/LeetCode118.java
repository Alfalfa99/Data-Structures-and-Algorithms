import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode118 {
    public static void main(String[] args) {
        for (List<Integer> list : generate(5)) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> arrayList = new ArrayList<>();
        if (numRows == 0){
            return arrayList;
        }
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i == 0 || j == 0 || i == j){
                    list.add(1);
                } else {
                    list.add(arrayList.get(i-1).get(j-1)+arrayList.get(i-1).get(j));
                }
            }
            arrayList.add(list);
        }
        return arrayList;
    }
}