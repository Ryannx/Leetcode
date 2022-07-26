package LC_2343;

import java.util.*;

public class LC_2343 {
    private static class Cell implements Comparable {
        private String num;
        private int idx;
        public Cell(String num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Object o) {
            int n = this.num.length();
            Cell another = (Cell) o;
            for (int i = 0; i < n; i++) {
                if ((int) this.num.charAt(i) < (int) another.num.charAt(i)) {
                    return -1;
                }
                if ((int) this.num.charAt(i) > (int) another.num.charAt(i)) {
                    return 1;
                }
            }
            return this.idx - another.idx;
        }

        public int getIdx() {
            return this.idx;
        }
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {

        // [idx, list<idx>]
        HashMap<Integer, List<Integer>> idx2trims = new HashMap<>();
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> list = idx2trims.get(queries[i][1]);
            if (list != null) continue;
            list = getTrims(queries[i][1], nums);
            idx2trims.put(queries[i][1], list);
        }
        for (int i = 0; i < n; i++) {
            res[i] = idx2trims.get(queries[i][1]).get(queries[i][0] - 1);;
        }

        return res;
    }

    private List<Integer> getTrims(int trim, String[] nums) {

        List<Cell> temp = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            String digit = nums[i].substring(nums[i].length() - trim);
            temp.add(new Cell(digit, i));
        }

        Collections.sort(temp);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(temp.get(i).getIdx());
        }

        return res;
    }

    public static void main(String[] args) {
        String[] nums = {"9415","5908","1840","5307"};
        int[][] queries = {{3,2},{2,2},{3,3},{1,3}};
        LC_2343 solution3 = new LC_2343();
        int[] res = solution3.smallestTrimmedNumbers(nums, queries);
        for (int i = 0; i < queries.length; i++) {
            System.out.println(res[i]);
        }
    }
}
