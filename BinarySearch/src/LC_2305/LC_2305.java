package LC_2305;

public class LC_2305 {
    public int distributeCookies(int[] cookies, int k) {

        if (cookies == null || cookies.length == 0) {
            return 0;
        }

        int start = 1;
        int end = Integer.MAX_VALUE / 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int[] kids = new int[k];
            if (isValid(cookies, 0, kids, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private boolean isValid(int[] cookies, int idx, int[] kids, int target) {

        if (idx == cookies.length) {
            return true;
        }

        for (int c : cookies) {
            if (c > target) {
                return false;
            }
        }

        for (int i = 0; i < kids.length; i++) {
            if (kids[i] + cookies[idx] > target) continue;
            kids[i] += cookies[idx];
            if (isValid(cookies, idx + 1, kids, target)) {
                return true;
            }
            kids[i] -= cookies[idx];
        }

        return false;
    }
}
