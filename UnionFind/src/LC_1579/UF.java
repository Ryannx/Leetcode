package LC_1579;

import java.util.Arrays;

class UF {
    private int[] parent;
    private int[] size;
    private int ccAmount;
    private int N;

    public UF(int n) {
        this.parent = new int[n + 1];
        this.size = new int[n + 1];
        this.ccAmount = n;
        this.N = n;
        for (int i = 0; i < parent.length; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
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

    public UF getCopyUF(UF uf) {

        UF res = new UF(uf.N);
        res.parent = Arrays.copyOf(uf.parent, uf.parent.length);
        res.size = Arrays.copyOf(uf.size, uf.size.length);
        res.ccAmount = uf.ccAmount;
        return res;
    }
}
