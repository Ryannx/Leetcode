package LC_2007;

import java.util.*;

public class LC_2007 {

    public int[] findOriginalArray(int[] changed) {

        if (changed.length % 2 != 0) {
            return new int[0];
        }

        Comparator<Map.Entry<Integer, TreeSet<Integer>>> comparator = (a, b) -> (a.getKey() - b.getKey());
        TreeMap<Integer, TreeSet<Integer>> points = new TreeMap<Integer, TreeSet<Integer>>(); // [val, idxSet]
        int arrLen = changed.length;
        for (int i = 0; i < arrLen; i++) {
            TreeSet val = points.getOrDefault(changed[i], new TreeSet<>());
            val.add(i);
            points.put(changed[i], val);
        }

        int j = 0;
        int[] res = new int[arrLen / 2];
        while (!points.isEmpty()) {
            int cur = points.firstKey();
            int doubleVal = getDoubleVal(points, cur);
            if (doubleVal == -1) {
                return new int[0];
            }
            res[j] = cur;
            j++;
            updatePoints(points, cur);
            updatePoints(points, doubleVal);
        }

        return res;
    }

    private void updatePoints(TreeMap<Integer, TreeSet<Integer>> points, int a) {

        TreeSet val = points.get(a);
        if (val.size() == 1) {
            points.remove(a);
        } else {
            val.pollFirst();
            points.put(a, val);
        }
    }

    private int getDoubleVal(TreeMap<Integer, TreeSet<Integer>> points, int target) {

        int next = target * 2;
        if (!points.containsKey(next) || (next == 0 && points.get(next).size() == 1)) {
            return -1;
        }
        return next;
    }

    public static void main(String[] args) {
        LC_2007 lc_2007 = new LC_2007();
        int[] changed = {6,3,0,1};
        int[] res = lc_2007.findOriginalArray(changed);
        for (int n : res) {
            System.out.println(n);
        }
    }
}
