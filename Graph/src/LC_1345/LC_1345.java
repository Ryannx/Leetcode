package LC_1345;

import java.util.*;

public class LC_1345 {
    public int minJumps(int[] arr) {

        HashMap<Integer, HashSet<Integer>> val2idx = new HashMap<>();
        int len = arr.length;
        if (len == 1) {
            return 0;
        }
        for (int i = 0; i < len; i++) {
            HashSet<Integer> idxSet = val2idx.getOrDefault(arr[i], new HashSet<>());
            idxSet.add(i);
            val2idx.put(arr[i], idxSet);
        }

        Queue<Integer> queue = new LinkedList<>(); // idx
        queue.add(0);
        boolean[] visited = new boolean[len];
        visited[0] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curIdx = queue.poll();
                // neighbor
                if (curIdx - 1 >= 0 && !visited[curIdx - 1]) {
                    queue.add(curIdx - 1);
                    visited[curIdx - 1] = true;
                }
                if (curIdx + 1 < len && !visited[curIdx + 1]) {
                    queue.add(curIdx + 1);
                    visited[curIdx + 1] = true;
                    if (curIdx + 1 == len - 1) {
                        return step + 1;
                    }
                }
                // equal val
                HashSet<Integer> idxSet = val2idx.get(arr[curIdx]);
                if (idxSet == null) {
                    continue;
                }
                if (idxSet.contains(len - 1)) {
                    return step + 1;
                }
                for (int idx : idxSet) {
                    if (!visited[idx]) {
                        queue.add(idx);
                        visited[idx] = true;
                    }
                }
                val2idx.remove(arr[curIdx]);
            }
            step++;
        }

        return -1;
    }

//    public static void main(String[] args) {
//        LC_1345 lc_1345 = new LC_1345();
//        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
//        System.out.println(lc_1345.minJumps(arr));
//    }
}
