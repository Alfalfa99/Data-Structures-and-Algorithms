package LeetCode;


public class LeetCode415 {
    public String addStrings(String num1, String num2) {
        int str1Len = num1.length()-1;
        int str2Len = num2.length()-1;
        int addOne = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = str1Len,j = str2Len; i >= 0 || j>= 0; i--,j--) {
            int cur1 = 0,cur2 = 0;
            if(i >= 0 && j >= 0){
                cur1 = num1.charAt(i) - '0';
                cur2 = num2.charAt(j) - '0';
            } else if( i>= 0){
                cur1 = num1.charAt(i) - '0';
            } else if(j>=0){
                cur2 = num2.charAt(j) - '0';
            }
            int sum = addOne == 1?cur1+cur2+1:cur1+cur2;
            addOne = 0;
            if(sum >= 10){
                sum %= 10;
                addOne = 1;
            }
            sb.append(sum);
        }
        if(addOne == 1){
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
