package LC_310;

import java.util.*;

public class LC_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 0 || edges == null) {
            return null;
        }
        if (n == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }

        int[] degree = new int[n];
        List<Integer>[] graph = new List[n];
        for (int[] edge : edges) {
            if (graph[edge[0]] == null) {
                graph[edge[0]] = new ArrayList<>();
            }
            graph[edge[0]].add(edge[1]);
            degree[edge[0]]++;
            if (graph[edge[1]] == null) {
                graph[edge[1]] = new ArrayList<>();
            }
            graph[edge[1]].add(edge[0]);
            degree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
                degree[i]--;
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (size-- > 0) {
                int cur = queue.poll();
                temp.add(cur);
                for (Integer next : graph[cur]) {
                    degree[next]--;
                    if (degree[next] == 1) {
                        queue.add(next);
                    }
                }
            }
            res = temp;
        }

        return res;
    }
}
