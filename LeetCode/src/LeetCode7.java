import java.util.HashMap;

public class LeetCode7 {
    public static void main(String[] args) {
    }

    public int reverse(int x) {
        int res = 0 ;
        while(x != 0){
            int temp = x % 10 + res * 10;
            if((temp - x % 10) / 10 != res){ //最关键的一步
                return 0 ;
            }
            res = temp ;
            x /= 10 ;
        }
        return res ;
    }
}
