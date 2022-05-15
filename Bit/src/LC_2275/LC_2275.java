package LC_2275;

public class LC_2275 {
    public int largestCombination(int[] candidates) {

        int res = 0;
        for (int i = 1; i <= (int) 1e9; i <<= 1) {
            int cur = 0;
            for (int c : candidates) {
                if ((i & c) > 0) {
                    cur++;
                }
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
