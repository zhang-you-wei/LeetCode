package yowei.leetCode.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 有向图问题，查找该图是否有环
 * 使用拓扑排序：dfs+贪心算法
 * 优先找到那些只出不进的节点，从这些节点向后延伸
 */
public class No207CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }

        // 特判
        int pLen = prerequisites.length;
        if (pLen == 0) {
            return true;
        }

        //创建入度表和领接表
        int[] inDegree = new int[numCourses];
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        //遍历一次数组，得到每个起始边的入度和领接表
        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
            adj[p[1]].add(p[0]);
        }


        Queue<Integer> queue = new LinkedList<>();

        // 首先加入入度为 0 的结点
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 记录已经出队的课程数量
        int cnt = 0;

        while (!queue.isEmpty()) {
            Integer top = queue.poll();         //出队的节点
            cnt += 1;
            // 遍历当前出队结点的所有后继结点
            for (int successor : adj[top]) {
                inDegree[successor]--;              //出队节点的后继节点度数减一
                if (inDegree[successor] == 0) {         //如果度数为0则立即入队
                    queue.add(successor);
                }
            }
        }
        return cnt == numCourses;           //由结果集的数量是否等于原始输入的数量判断是否有环
    }
}
