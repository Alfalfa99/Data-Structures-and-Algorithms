package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode207 {
    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            //一共有numCourses门课,所以有numCourses个ArrayList
            adjacency.add(new ArrayList<>());
        }
        //备忘录,用来判断当前节点是否被访问过
        // flag[i] = 0 说明没被访问过,将flag[i] = 1 继续dfs
        // flag[i] = -1 说明被非本次DFS访问过,说明无需重复搜索,直接返回True
        // flag[i] = 1 说明被本次DFS访问过,说明有环,直接返回false
        int[] flags = new int[numCourses];

        for (int[] cp : prerequisites) {
            adjacency.get(cp[1]).add(cp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        //本次dfs访问过该节点,有环!快撤!
        if (flags[i] == 1) {
            return false;
        }//非本次dfs访问过该节点,直接返回true
        if (flags[i] == -1) {
            return true;
        }
        //该节点没被访问过,将该节点标记
        flags[i] = 1;
        //将该节点的全部前置节点丢到dfs中
        for (Integer j : adjacency.get(i)) {
            if (!dfs(adjacency, flags, j)) {
                return false;
            }
        }
        //将所有前置节点递归完毕后将自身设置为-1,因为对于下一次个dfs而言这次dfs已经是上次dfs了
        flags[i] = -1;
        return true;
    }
}
