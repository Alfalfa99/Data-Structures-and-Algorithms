public class LeetCode168 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }



    public static String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            n --;//这里稍作处理，因为它是从1开始
            stringBuilder.insert(0,(char)(n % 26 + 'A'));
            n /= 26;
        }
        return stringBuilder.toString();
    }
}