package LeetCode;

public class LeetCode58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("b   a    "));
    }

    public static int lengthOfLastWord(String s) {
        char[] chars = s.trim().toCharArray();  //调用.trim()方法删除字符串首末的空格
        if(chars.length == 0){  //如果删除了空格之后的字符串长度为空则返回
            return 0;
        }
        for(int i = chars.length -1; i >=0; i --){
            if(chars[i] == ' ' ){   //从尾往前,如果遇到空格则说明最后一个字符串找完了
                return chars.length-1-i;    //返回长度-空格的位置-1
            }
            if(i == 0){ //没有找到空格,说明全都是一个单词
                return chars.length;    //返回长度
            }
        }
        return 0;
    }
}
