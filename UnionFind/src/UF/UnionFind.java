package UF;

public class UnionFind {

    private int[] parent;
    private int[] size;
    private int connectedComponentCount;
    private int maxSize;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        this.connectedComponentCount = 0;
        this.maxSize = 0;
    }

    public void initial(int p) {

        if (size[p] != 0) {
            return;
        }
        parent[p] = p;
        size[p] = 1;
        connectedComponentCount++;
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

    public boolean find(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    public void union(int p, int q) {

        int pRoot = getRoot(p);
        int qRoot = getRoot(q);
        if (size[pRoot] < size[qRoot]) {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
            maxSize = Math.max(maxSize, size[qRoot]);
        } else {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
            maxSize = Math.max(maxSize, size[pRoot]);
        }
        this.connectedComponentCount--;
    }

    public int getMaxSize() {
        return this.maxSize;
    }
}
