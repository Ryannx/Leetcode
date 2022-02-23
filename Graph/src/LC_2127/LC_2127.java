package LC_2127;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC_2127 {
    public int maximumInvitations(int[] favorite) {

        if (favorite == null || favorite.length == 0) {
            return 0;
        }

        int n = favorite.length;
        int[] indegree = new int[n];
        int[] depth = new int[n];
        Arrays.fill(depth, 1);
        for (int i = 0; i < n; i++) {
            indegree[favorite[i]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                visited[i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            indegree[favorite[cur]]--;
            if (indegree[favorite[cur]] == 0) {
                queue.add(favorite[cur]);
                visited[favorite[cur]] = true;
            }
            // update depth
            depth[favorite[cur]] = depth[cur] + 1;
        }

        int multiNodesCycle = 0;
        int doubleNodesCycle = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            int j = i;
            int count = 0;
            while (!visited[j]) {
                visited[j] = true;
                j = favorite[j];
                count++;
            }
            if (count > 2) {
                multiNodesCycle = Math.max(multiNodesCycle, count);
            } else if (count == 2) {
                doubleNodesCycle += (depth[i] + depth[favorite[i]]);
            }
        }

        return Math.max(multiNodesCycle, doubleNodesCycle);
    }

    public static void main(String[] args) {
        LC_2127 lc_2127 = new LC_2127();
        int[] favorite = {1,2,0};
        System.out.println(lc_2127.maximumInvitations(favorite));
    }
}
