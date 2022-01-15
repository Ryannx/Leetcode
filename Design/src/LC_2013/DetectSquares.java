package LC_2013;

import java.util.TreeMap;

public class DetectSquares {

    private TreeMap<Integer, Integer> idx2amount;
    private int N;
    public DetectSquares() {
        this.idx2amount = new TreeMap<>();
        this.N = 1001;
    }

    public void add(int[] point) {

        int idx = point[0] * N + point[1];
        Integer val = idx2amount.getOrDefault(idx, 0);
        idx2amount.put(idx, val + 1);
    }

    public int count(int[] point) {

        int res = 0;
        int curIdx = point[0] * N + point[1];
//        int curAmount = idx2amount.getOrDefault(curIdx, 0);
//        curAmount++;
        int curAmount = 1;
        // top
        while (idx2amount.floorKey(curIdx - 1) != null && idx2amount.floorKey(curIdx - 1) / N == point[0]) {
            // top right
            int x1 = idx2amount.floorKey(curIdx - 1);
            int bottomRightYIdx = x1 % N;
            int distance = point[1] - bottomRightYIdx;
            int amount1 = idx2amount.get(x1);
            int x2 = (point[0] - distance) * N + point[1];
            int amount2 = idx2amount.getOrDefault(x2, 0);
            int x3 = (point[0] - distance) * N + (point[1] - distance);
            int amount3 = idx2amount.getOrDefault(x3, 0);
            res += curAmount * amount1 * amount2 * amount3;
            // top left
            int x4 = (point[0] + distance) * N + point[1];
            int amount4 = idx2amount.getOrDefault(x4, 0);
            int x5 = (point[0] + distance) * N + (point[1] - distance);
            int amount5 = idx2amount.getOrDefault(x5, 0);
            res += curAmount * amount1 * amount4 * amount5;
            curIdx = idx2amount.floorKey(curIdx - 1);
        }

        // bottom
        curIdx = point[0] * N + point[1];
        while (idx2amount.ceilingKey(curIdx + 1) != null && idx2amount.ceilingKey(curIdx + 1) / N == point[0]) {
            // bottom right
            int x1 = idx2amount.ceilingKey(curIdx + 1);
            int y = x1 % N;
            int distance = y - point[1];
            int amount1 = idx2amount.getOrDefault(x1, 0);
            int x2 = (point[0] - distance) * N + point[1];
            int amount2 = idx2amount.getOrDefault(x2, 0);
            int x3 = (point[0] - distance) * N + point[1] + distance;
            int amount3 = idx2amount.getOrDefault(x3, 0);
            res += curAmount * amount1 * amount2 * amount3;
            // bottom left
            int x4 = (point[0] + distance) * N + point[1];
            int amount4 = idx2amount.getOrDefault(x4, 0);
            int x5 = (point[0] + distance) * N + point[1] + distance;
            int amount5 = idx2amount.getOrDefault(x5, 0);
            res += curAmount * amount1 * amount4 * amount5;
            curIdx = idx2amount.ceilingKey(curIdx + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[] {3, 10});
        detectSquares.add(new int[] {11, 2});
        detectSquares.add(new int[] {3, 2});
        System.out.println(detectSquares.count(new int[] {11, 10}));

    }
}
