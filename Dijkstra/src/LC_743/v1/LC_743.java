package LC_743.v1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC_743 {
    public int networkDelayTime(int[][] times, int n, int k) {

        if (times == null) {
            return -1;
        }
        if (times.length == 0) {
            return 0;
        }

        List<int[]>[] graph = new ArrayList[n + 1]; // [distance, idx]
        for (int[] t : times) {
            if (graph[t[0]] == null) {
                graph[t[0]] = new ArrayList<>();
            }
            graph[t[0]].add(new int[] {t[2], t[1]});
        }

        Comparator<int[]> comparator = (a, b) -> (a[0] - b[0]);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(comparator);
        boolean[] visited = new boolean[n + 1];
        if (graph[k] == null) {
            return -1;
        }
        int res = -1;
        priorityQueue.add(new int[] {0, k});
        while (!priorityQueue.isEmpty()) {
            int[] cur = priorityQueue.poll();
            if (visited[cur[1]]) continue;
            res = Math.max(res, cur[0]);
            visited[cur[1]] = true;
            if (graph[cur[1]] == null) continue;
            for (int[] edge : graph[cur[1]]) {
                priorityQueue.add(new int[] {cur[0] + edge[0], edge[1]});
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return -1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC_743 lc_743 = new LC_743();
        int[][] times = {{1,2,1}, {2,1,3}};
        System.out.println(lc_743.networkDelayTime(times, 2, 2));
    }
}
