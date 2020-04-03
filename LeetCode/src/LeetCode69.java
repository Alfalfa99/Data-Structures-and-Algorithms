public class LeetCode69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
        System.out.println(Math.sqrt(2147483647));
    }

    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        long num;
        int pos, left = 2, right = x / 2;
        while (left <= right) {
            pos = (left + right) / 2;
            num = (long) pos * pos;
            if (num < x) {
                left = pos + 1;
            } else if (num > x) {
                right = pos - 1;
            } else {
                return pos;
            }
        }
        return right;
    }
}