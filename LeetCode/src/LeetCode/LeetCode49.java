package LeetCode;


import java.util.*;

public class LeetCode49 {
    public static void main(String[] args) {
        String[] strs = new String[]{"stop","pots","reed","","tops","deer","opts",""};
        Solution solution = new Solution();
        List<List<String>> lists = solution.groupAnagrams(strs);
        List<String> r = new ArrayList<>();

        System.out.println(lists);
        for (String str : strs) {
            r.add(str);
        }
        System.out.println(r);
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] array = str.toCharArray();
                Arrays.sort(array);
                String key = new String(array);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<>(map.values());
        }
    }
}

