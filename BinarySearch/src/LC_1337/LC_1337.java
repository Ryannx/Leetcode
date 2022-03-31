package LC_1337;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_1337 {
    public int[] kWeakestRows(int[][] mat, int k) {

        if (mat == null || mat.length == 0 || mat[0].length == 0 || k <= 0) {
            return null;
        }

        Comparator<int[]> comparator = (a, b) -> (a[0] - b[0] == 0 ? a[1] - b[1] : (a[0] - b[0])); // [amount, idx]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(comparator.reversed());
        for (int i = 0; i < mat.length; i++) {
            int one_amount = getFirstZeroIdx(mat[i]);
            minHeap.add(new int[] {one_amount, i});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        int i = k - 1;
        while (!minHeap.isEmpty()) {
            res[i] = minHeap.poll()[1];
            i--;
        }

        return res;
    }

    private int getFirstZeroIdx(int[] row) {

        int start = 0;
        int end = row.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (row[mid] >= 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        LC_1337 lc_1337 = new LC_1337();
        int[][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        lc_1337.kWeakestRows(mat, 3);
    }
}
