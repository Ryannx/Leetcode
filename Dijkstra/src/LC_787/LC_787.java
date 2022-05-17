package LC_787;

import java.util.*;

public class LC_787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        if (flights == null) {
            return -1;
        }

        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f : flights) {
            List list = graph.getOrDefault(f[0], new ArrayList<>());
            list.add(new int[] {f[1], f[2]}); // [end, weight]
            graph.put(f[0], list);
        }

        if (graph.get(src) == null || graph.get(src).size() == 0) {
            return -1;
        }
        Comparator<int[]> comparator = (a, b) -> (a[1] - b[1]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(comparator);
        HashSet<Integer> visited = new HashSet<>();
        minHeap.add(new int[] {src, 0, 0}); // [end, weight, step]
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            if (visited.contains(Objects.hash(cur[0], cur[2]))) continue;
            if (cur[0] == dst && cur[2] <= k + 1) {
                return cur[1];
            }
            if (cur[2] >= k + 1) continue;
            visited.add(Objects.hash(cur[0], cur[2]));
            if (graph.get(cur[0]) == null) continue;
            for (int[] edge : graph.get(cur[0])) {
                minHeap.add(new int[] {edge[0], cur[1] + edge[1], cur[2] + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC_787 lc_787 = new LC_787();
        int[][] flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int src = 0;
        int dst = 2;
        int k = 2;
        int n = 5;
        System.out.println(lc_787.findCheapestPrice(n, flights, src, dst, k));
    }
}
