import java.util.Arrays;

public class JZoffer46 {
    public static void main(String[] args) {
        System.out.println(translateNum(506));
    }

    public static int translateNum(int num) {
        //help记录前一个result的值
        int result = 1, pre, help = 1;
        pre = num % 10;
        num /= 10;
        while (num != 0) {
            int cur = num % 10;
            num /= 10;
            //分两种情况,如果cur = 0,那么 cur*10 + pre <= 10,不增加可能性,如果cur*10+pre >= 25,也不增加可能性
            int c = (cur * 10 + pre >= 10 && cur * 10 + pre <= 25)? result+help:result;
            help = result;
            result = c;
            //将pre更新为cur
            pre = cur;
        }
        return result;
    }
}