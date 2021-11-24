package LC_952;

import UF.UnionFind;
import Eratosthenes.Eratosthenes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_952 {

    private static int maxNum = (int) 1e5;
    public int largestComponentSize(int[] nums) {

        List<Integer> primes = new Eratosthenes((int) Math.sqrt(maxNum)).getPrimes();
        int len = nums.length;
        UnionFind uf = new UnionFind(maxNum + 1);

        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            for (Integer prime : primes) {
                if (cur < prime) {
                    break;
                }
                if (cur % prime == 0) {
                    uf.initial(nums[i]);
                    uf.initial(prime);
                    if (!uf.find(nums[i], prime)) {
                        uf.union(nums[i], prime);
                    }
                    while (cur % prime == 0) {
                        cur /= prime;
                    }
                }
            }
            if (cur > 1) {
                uf.initial(cur);
                uf.initial(nums[i]);
                if (!uf.find(cur, nums[i])) {
                    uf.union(cur, nums[i]);
                }
            }
        }

        HashMap<Integer, Integer> parent2Count = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            parent2Count.put(uf.getRoot(num), parent2Count.getOrDefault(uf.getRoot(num), 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : parent2Count.entrySet()) {
            res = Math.max(res, entry.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        LC_952 lc_952 = new LC_952();
        int[] nums = {2,3,6,7,4,12,21,39};
        System.out.println(lc_952.largestComponentSize(nums));
    }
}
