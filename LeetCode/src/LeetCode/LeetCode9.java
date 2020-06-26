package LeetCode;

public class LeetCode9 {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(int x) {
        int y = x;
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int res = 0;
        while (x != 0) {
            int temp = x % 10 + res * 10;
            //若发生溢出则下面该判断会为true,因为溢出后数字不确定,所以进行反操作不会活的原值
//            if((temp - x % 10) / 10 != res){
//                return 0 ;
//            }
            res = temp;
            x /= 10;
        }
        if (y == res) {
            return true;
        } else {
            return false;
        }
    }
}
