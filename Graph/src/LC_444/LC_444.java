package LC_444;

import java.util.*;

public class LC_444 {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        int n = nums.length;
        if (n == 1) {
            return true;
        }
        List<Integer>[] graph = new List[n + 1];
        int[] indegree = new int[n + 1];
        for (List<Integer> list : sequences) {
            for (int i = 1; i < list.size(); i++) {
                if (graph[list.get(i - 1)] == null) {
                    graph[list.get(i - 1)] = new ArrayList<>();
                }
                if (graph[list.get(i)] == null) {
                    graph[list.get(i)] = new ArrayList<>();
                }
                graph[list.get(i - 1)].add(list.get(i));
                indegree[list.get(i)]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            if (queue.size() != 1) {
                return false;
            }
            int cur = queue.poll();
            if (cur != nums[i]) {
                return false;
            }
            for (Integer next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
            i++;
        }
        if (i != n) {
            return false;
        }

        return true;
    }
}
