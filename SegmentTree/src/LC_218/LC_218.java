package LC_218;

import java.util.*;

public class LC_218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return res;
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int[] building :buildings) {
            treeSet.add(building[0]);
            treeSet.add(building[1]);
        }
        int idx = 0;
        HashMap<Integer, Integer> pos2idx = new HashMap<>();
        HashMap<Integer, Integer> idx2pos = new HashMap<>();
        for (Integer p : treeSet) {
            pos2idx.put(p, idx);
            idx2pos.put(idx, p);
            idx++;
        }

        SegTreeNode root = new SegTreeNode(0, treeSet.size() - 1);
        root.initial(root, 0, treeSet.size() - 1);
        for (int[] b : buildings) {
            root.updateRange(root, pos2idx.get(b[0]), pos2idx.get(b[1]) - 1, b[2]);
        }

        // merge segment
        List<List<Integer>> candidates = new ArrayList<>();
        root.getAllSegment(root, candidates);
        int i = 0;
        int j = i;

        while (i < candidates.size() && j < candidates.size()) {
            res.add(Arrays.asList(idx2pos.get(candidates.get(i).get(0)), candidates.get(i).get(1)));
            if (!candidates.get(i).get(1).equals(candidates.get(j).get(1))) {
                j++;
                i++;
                continue;
            }
            while (j < candidates.size() && candidates.get(i).get(1).equals(candidates.get(j).get(1))) {
                j++;
            }
            i = j;
        }

        return res;
    }

    public static void main(String[] args) {
        LC_218 lc_218 = new LC_218();
        int[][] buildings = {{2,14,4}, {4,8,8}, {6,16,4}};
//        int[][] buildings = {{2,13,10}, {10,17,25}, {12,20,14}};
        System.out.println(lc_218.getSkyline(buildings));
    }
}
