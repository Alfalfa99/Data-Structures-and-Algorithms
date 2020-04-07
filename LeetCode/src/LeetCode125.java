public class LeetCode125 {
    public static void main(String[] args) {
        String s = "";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if (s == null){
            return true;
        }
        if (s.length() == 0){
            return true;
        }
        s = s.toLowerCase();
        for (int i = 0,j = s.length()-1; i != j;) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i)<= '9')){
                if (s.charAt(j) >= 'a' && s.charAt(j) <= 'z' || s.charAt(j) >= '0' && s.charAt(j)<= '9'){
                    if (s.charAt(i) == s.charAt(j)){
                        j--;
                        i++;
                        continue;
                    }
                    return false;
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }
        return true;
    }
}