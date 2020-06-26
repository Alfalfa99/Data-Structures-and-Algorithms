package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode974 {
    public static void main(String[] args) {
        int[] A = new int[]{4,5,0,-2,-3,1};
        System.out.println(subarraysDivByK(A,5));
    }

    public static int subarraysDivByK(int[] A, int K) {
        //Map中的每个value想加即为逆序对个数
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }
}
