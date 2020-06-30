package LeetCode;

public class LeetCode771 {
    public static void main(String[] args) {

    }

    public int numJewelsInStones(String J, String S) {
        char[] chars = S.toCharArray();
        char[] chars1 = J.toCharArray();
        char[] charchar = new char[128];
        int count = 0;
        for (char aChar : chars) {
            charchar[aChar]++;
        }
        for (char c : chars1) {
            count += charchar[c];
        }
        return count;
    }
}
