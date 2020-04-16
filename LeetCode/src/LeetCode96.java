import java.util.ArrayList;
import java.util.List;

public class LeetCode96 {
    public static void main(String[] args) {
        System.out.println(numTrees(6));
    }

    public static int numTrees(int n) {
        //卡特兰数 Cn = 2(2n+1)*Cn-1/(n+2)
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1)/(i + 2);
        }
        return (int)C;
    }
}
