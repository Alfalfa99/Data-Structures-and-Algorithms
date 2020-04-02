public class LeetCode67 {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        int ca = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i > 0 && j > 0; i--, j--) {
            int sum = ca;
            sum += i > 0 ? a.charAt(i) - '0' : 0;   //如果串a读完了就自动补0
            sum += j > 0 ? b.charAt(j) - '0' : 0;   //如果串b读完了就自动补0;
            sb.append(sum % 2);                     //当前位置的数是否超过1,如果超过就取余
            ca = sum / 2;                           //把超过1的数作为余数放入下一位的运算
        }
        sb.append(ca == 1 ? ca : "");   //循环结束后还有进位数则最后填1
        return sb.reverse().toString(); //将字符串反转获得目标串,因为我们是从小位开始填充的
    }
}