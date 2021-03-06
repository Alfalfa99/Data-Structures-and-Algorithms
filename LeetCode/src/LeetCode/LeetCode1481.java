package LeetCode;

/**
 * @author 15423
 */
public class LeetCode1481 {
    public static void main(String[] args) {
        for (int i : divingBoard(1, 1, 10000)) {
            System.out.println(i);
        }
    }

    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0){
            return new int[0];
        }
        if (shorter == longer){
            return new int[]{shorter*k};
        }
        int[] res = new int[k+1];
        for(int i=0;i<=k;i++) {
            res[i] =  shorter * (k-i) + longer*i;
        }
        return res;
    }
}
