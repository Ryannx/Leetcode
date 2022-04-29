package LC_785;

import java.util.LinkedList;
import java.util.Queue;

public class LC_785 {
    public boolean isBipartite(int[][] graph) {

        if (graph == null || graph.length == 0) {
            return false;
        }

        int n = graph.length;
        int[] status = new int[n];
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            if (status[i] != 0) continue;
            queue.add(i);
            status[i] = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int cur = queue.poll();
                    for (int j = 0; j < graph[cur].length; j++) {
                        if (status[cur] == status[graph[cur][j]]) return false;
                        if (status[graph[cur][j]] == 0) {
                            status[graph[cur][j]] = -status[cur];
                            queue.add(graph[cur][j]);
                        }
                    }
                }
            }
        }

        return true;
    }
}
