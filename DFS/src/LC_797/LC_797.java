package LC_797;

import java.util.*;

public class LC_797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();
        if (graph == null || graph.length == 0 || graph[0].length == 0) {
            return res;
        }

        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(res, path, graph, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int[][] graph, int idx) {

        int n = graph.length;
        if (idx == n - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < graph[idx].length; i++) {
            path.add(graph[idx][i]);
            dfs(res, path, graph, graph[idx][i]);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC_797 lc_797 = new LC_797();
        int[][] graph = {{1,2}, {3}, {3}, {}};
        System.out.println(lc_797.allPathsSourceTarget(graph));
    }
}
