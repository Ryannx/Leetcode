package LC_1649;

import java.util.HashMap;
import java.util.TreeSet;

public class LC_1649 {
    public int createSortedArray(int[] instructions) {

        if (instructions == null || instructions.length == 0) {
            return 0;
        }

        // 离散化 and sort
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : instructions) {
            set.add(num);
        }
        HashMap<Integer, Integer> num2idx = new HashMap<>();
        int i = 0;
        for (Integer num : set) {
            num2idx.put(num, i);
            i++;
        }

        int res = 0;
        int n = set.size() - 1;
        int M = (int) 1e9 + 7;
        SegTreeNode root = new SegTreeNode(0, n);
        root.initial(root, 0, n);
        for (int j = 0; j < instructions.length; j++) {
            int curIdx = num2idx.get(instructions[j]);
            res += Math.min(root.queryRange(root, 0, curIdx - 1), root.queryRange(root, curIdx + 1, n));
            res %= M;
            root.singleUpdate(root, curIdx, 1);
        }

        return res;
    }

    public static void main(String[] args) {
        LC_1649 lc_1649 = new LC_1649();
        int[] instructions = {1,3,3,3,2,4,2,1,2};
        System.out.println(lc_1649.createSortedArray(instructions));
    }
}
