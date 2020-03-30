public class LeetCode14 {
    public static void main(String[] args) {
    }

    public String longestCommonPrefix(String[] strs) {
        //数组长度为0直接返回
        if (strs.length == 0) {
            return "";
        }
        //初始化公共前缀
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //如果当前串与公共前缀不相等,进入while
            while(strs[i].indexOf(prefix) != 0) {
                //将公共前缀的最后一位删除
                prefix = prefix.substring(0, prefix.length() - 1);
                //如果公共前缀删除完毕仍未找到相同部分则返回
                if (prefix.equals("")) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
