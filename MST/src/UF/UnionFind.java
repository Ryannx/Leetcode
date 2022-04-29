package UF;

public class UnionFind {

    private int[] parent;
    private int[] size;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            this.initial(i);
        }
    }

    private void initial(int idx) {
        this.parent[idx] = idx;
        this.size[idx] = 1;
    }

    public int getRoot(int idx) {

        int cur = idx;
        while (cur != parent[cur]) {
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }
        parent[idx] = cur;
        return cur;
    }

    public boolean find(int a, int b) {
        return getRoot(a) == getRoot(b);
    }

    public void union(int a, int b) {
        int aRoot = getRoot(a);
        int bRoot = getRoot(b);
        if (size[aRoot] < size[bRoot]) {
            parent[aRoot] = parent[bRoot];
            size[bRoot] += size[aRoot];
        } else {
            parent[bRoot] = parent[aRoot];
            size[aRoot] += size[bRoot];
        }
    }
}
