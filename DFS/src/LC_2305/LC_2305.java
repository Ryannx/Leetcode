package LC_2305;

public class LC_2305 {
    private int res = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        if (cookies == null || cookies.length == 0) {
            return 0;
        }

        int[] kids = new int[k];
        dfs(cookies, k, 0, kids);
        return res;
    }

    private void dfs(int[] cookies, int k, int idx, int[] kids) {
        if (idx == cookies.length) {
            int max = 0;
            for (int cookie : kids) {
                max = Math.max(max, cookie);
            }
            res = Math.min(res, max);
            return;
        }

        for (int i = 0; i < k; i++) {
            kids[i] += cookies[idx];
            dfs(cookies, k, idx + 1, kids);
            kids[i] -= cookies[idx];
        }
    }
}
