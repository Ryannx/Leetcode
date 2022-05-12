package LC_47;

import java.util.*;

public class LC_47 {
    private HashMap<Integer, Integer> num2idx;
    private HashMap<Integer, Integer> idx2num;
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        this.num2idx = new HashMap<>();
        this.idx2num = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] idx2amount = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            num2idx.put(num, idx);
            idx2num.put(idx, num);
            idx++;
        }
        for (int num : nums) {
            idx2amount[num2idx.get(num)]++;
        }
        int[] path = new int[nums.length];
        dfs(res, path, idx2amount, 0, nums.length);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] path, int[] idx2amount, int idx, int len) {

        if (idx == len) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                temp.add(path[i]);
            }
            res.add(temp);
            return;
        }
        if (idx > len) {
            return;
        }

        for (int i = 0; i < idx2amount.length; i++) {
            if (idx2amount[i] == 0) continue;
            // select
            path[idx] = idx2num.get(i);
            idx2amount[i]--;
            dfs(res, path, idx2amount, idx + 1, len);
            idx2amount[i]++;
        }
    }

    public static void main(String[] args) {
        LC_47 lc_47 = new LC_47();
        int[] nums = {1,2,3};
        System.out.println(lc_47.permuteUnique(nums));
    }
}
