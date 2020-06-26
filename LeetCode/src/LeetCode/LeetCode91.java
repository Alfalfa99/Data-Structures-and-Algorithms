package LeetCode;

public class LeetCode91 {
    public static void main(String[] args) {
        System.out.println(numDecodings("231012"));
    }

    public static int numDecodings(String s) {
        int len = s.length();

        int help = 1;
        int res = 0;
        //从s的尾部开始向前遍历,如果尾部不是0则肯定有一种可能性
        if (s.charAt(len - 1) != '0') {
            res = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                help = res;
                res = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                res += help;
                //help用来存储res以前的值
                help = res-help;
            } else {
                help = res;
                //若两者都为0说明有一位为0,他的前一位大于2,既超出了26的范围,导致该0成为孤儿,所以该数肯定是错的,返回0
                if (help == 0){
                    return 0;
                }
            }

        }
        return res;
    }
}
