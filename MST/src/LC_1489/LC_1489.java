package LC_1489;

import java.util.*;

public class LC_1489 {

    private int N;
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

        List<List<Integer>> res = new ArrayList<>();
        if (edges == null) {
            return res;
        }

        this.N = n;
        Comparator<int[]> comparator = (a, b) -> (a[2] - b[2]);
        int[][] edges2idx = new int[edges.length][4];
        for (int i = 0; i < edges.length; i++) {
            edges2idx[i] = new int[] {edges[i][0], edges[i][1], edges[i][2], i};
        }
        Arrays.sort(edges2idx, comparator);
        int minMST = kruskal(edges2idx, -1);
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < edges2idx.length; i++) {
            int curMST1 = kruskal(edges2idx, edges2idx[i][3]);
            // if does not select this edge, curMST > minMST or cannot be tree
            if (minMST != curMST1 || curMST1 == Integer.MAX_VALUE) {
                set1.add(edges2idx[i][3]);
            }
            int[][] t = insertArr(edges2idx, edges2idx[i]);
            // Answer in set2 must not in set1
            if (set1.contains(edges2idx[i][3])) continue;
            int curMST2 = kruskal(t, -1);
            if (curMST2 == Integer.MAX_VALUE) continue;
            // select or not select curEdge graph is MST, and minCost does not change
            if (curMST2 == minMST && curMST1 == minMST) {
                set2.add(edges2idx[i][3]);
            }
        }
        res.add(new ArrayList<>(set1));
        res.add(new ArrayList<>(set2));
        return res;
    }

    private int[][] insertArr(int[][] edges, int[] e) {
        int[][] res = new int[edges.length + 1][edges[0].length];
        for (int i = 1; i < res.length; i++) {
            res[i] = new int[] {edges[i - 1][0], edges[i - 1][1], edges[i - 1][2], edges[i - 1][3]};
        }
        res[0] = new int[] {e[0], e[1], e[2], e[3]};
        return res;
    }

    // (edges[i][3] == idx) does not calculate
    private int kruskal(int[][] edges, int idx) {

        // [a, b, weight, idx]
        Queue<int[]> queue = new LinkedList<>();
        for (int[] e : edges) {
            queue.add(e);
        }

        UF uf = new UF(this.N);
        int res = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[3] == idx || uf.find(cur[0], cur[1])) continue;
            uf.union(cur[0], cur[1]);
            res += cur[2];
            if (uf.getCcAmount() == 1) break;
        }

        return uf.getCcAmount() == 1 ? res : Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        LC_1489 lc_1489 = new LC_1489();
        int[][] edges = {{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}};
        System.out.println(lc_1489.findCriticalAndPseudoCriticalEdges(5, edges));
    }
}
