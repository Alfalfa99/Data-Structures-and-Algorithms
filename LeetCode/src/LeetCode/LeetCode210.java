package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode210 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,0},{2,1},{3,2},{3,0}};
        for (int i : findOrder(4,nums)) {

        }
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        int[] inDegrees = new int[numCourses];
        // 建立入度表
        for (int[] p : prerequisites) { // 对于有先修课的课程，计算有几门先修课
            inDegrees[p[0]]++;
        }
        // 入度为0的节点队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;  // 记录可以学完的课程数量
        int[] res = new int[numCourses];  // 可以学完的课程
        // 根据提供的先修课列表，删除入度为 0 的节点
        while (!queue.isEmpty()){
            int curr = queue.poll();
            res[count++] = curr;   // 将可以学完的课程加入结果当中
            for (int[] p : prerequisites) {
                if (p[1] == curr){
                    inDegrees[p[0]]--;
                    if (inDegrees[p[0]] == 0){
                        queue.offer(p[0]);
                    }
                }
            }
        }
        if (count == numCourses) return res;
        return new int[0];
    }


}
