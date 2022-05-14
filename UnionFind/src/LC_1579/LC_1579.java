package LC_1579;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {

        List<int[]>[] type2edges = new List[3];
        for (int i = 0; i < type2edges.length; i++) {
            type2edges[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            type2edges[edge[0] - 1].add(Arrays.copyOf(edge, edge.length));
        }

        UF uf = new UF(n);
        int count = 0;
        for (int[] edge : type2edges[2]) {
            if (uf.find(edge[1], edge[2])) {
                count++;
                continue;
            }
            uf.union(edge[1], edge[2]);
        }
        UF copyUF = uf.getCopyUF(uf);
        // Alice
        for (int[] edge : type2edges[0]) {
            if (uf.find(edge[1], edge[2])) {
                count++;
                continue;
            }
            uf.union(edge[1], edge[2]);
        }
        if (uf.getCcAmount() != 1) {
            return -1;
        }

        // Bob
        for (int[] edge : type2edges[1]) {
            if (copyUF.find(edge[1], edge[2])) {
                count++;
                continue;
            }
            copyUF.union(edge[1], edge[2]);
        }
        if (copyUF.getCcAmount() != 1) {
            return -1;
        }
        return count;
    }

    public static void main(String[] args) {
        LC_1579 lc_1579 = new LC_1579();
        int[][] edges = {{3,1,2},{3,2,3},{1,1,4},{2,1,4}};
        System.out.println(lc_1579.maxNumEdgesToRemove(4, edges));
    }
}
