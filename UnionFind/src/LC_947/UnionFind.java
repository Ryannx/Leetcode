package LC_947;

import java.util.HashMap;

class UnionFind {
    private HashMap<Integer, Integer> child2parent;
    private HashMap<Integer, Integer> idx2size;
    private int base;
    private int ccAmount;
    public UnionFind(int base) {
        this.child2parent = new HashMap<>();
        this.idx2size = new HashMap<>();
        this.base = base;
    }

    public void initial(int[][] stones) {
        for (int[] stone : stones) {
            int idx = stone[0] * base + stone[1];
            child2parent.put(idx, idx);
            idx2size.put(idx, 1);
        }
        this.ccAmount = child2parent.size();
    }

    private int getRoot(int a) {
        int cur = a;
        while (cur != child2parent.get(child2parent.get(cur))) {
            int grandP = child2parent.get(child2parent.get(cur));
            child2parent.put(cur, grandP);
            cur = grandP;
        }
        child2parent.put(a, cur);
        return cur;
    }

    public boolean find(int a, int b) {
        return getRoot(a) == getRoot(b);
    }

    public void union(int a, int b) {
        int aRoot = getRoot(a);
        int bRoot = getRoot(b);
        if (idx2size.get(aRoot) < idx2size.get(bRoot)) {
            child2parent.put(aRoot, bRoot);
            idx2size.put(bRoot, idx2size.get(aRoot) + idx2size.get(bRoot));
        } else {
            child2parent.put(bRoot, aRoot);
            idx2size.put(aRoot, idx2size.get(aRoot) + idx2size.get(bRoot));
        }
        ccAmount--;
    }

    public int getCcAmount() {
        return ccAmount;
    }
}
