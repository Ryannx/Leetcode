package LC_1489;

class UF {
    private int[] parent;
    private int[] size;
    private int ccAmount;

    public UF(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        this.ccAmount = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int getRoot(int a) {

        int cur = a;
        while (parent[cur] != cur) {
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }
        parent[a] = cur;
        return cur;
    }

    public boolean find(int a, int b) {
        return getRoot(a) == getRoot(b);
    }

    public void union(int a, int b) {
        int aRoot = getRoot(a);
        int bRoot = getRoot(b);
        if (size[aRoot] < size[bRoot]) {
            parent[aRoot] = bRoot;
            size[bRoot] += size[aRoot];
        } else {
            parent[bRoot] = aRoot;
            size[aRoot] += size[bRoot];
        }
        this.ccAmount--;
    }

    public int getCcAmount() {
        return this.ccAmount;
    }
}
