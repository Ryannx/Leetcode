package LC_743.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_743 {
    public int networkDelayTime(int[][] times, int n, int k) {

        if (times == null || times.length == 0) {
            return 0;
        }

        List<int[]>[] graph = new List[n + 1];
        for (int[] edge : times) {
            if (graph[edge[0]] == null) {
                graph[edge[0]] = new ArrayList<>();
            }
            graph[edge[0]].add(new int[] {edge[2], edge[1]}); // [distance, id]
        }

        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int minDis = Integer.MAX_VALUE;
            int minId = -1;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && distance[j] < minDis) {
                    minDis = distance[j];
                    minId = j;
                }
            }
            if (minId == -1) break;
            visited[minId] = true;
            if (graph[minId] == null) continue;
            for (int[] edge : graph[minId]) {
                distance[edge[1]] = Math.min(distance[edge[1]], minDis + edge[0]);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, distance[i]);
        }

        return res;
    }
}
