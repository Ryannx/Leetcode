package LC_1423;

public class LC_1423 {
    public int maxScore(int[] cardPoints, int k) {

        if (cardPoints == null || cardPoints.length == 0) {
            return 0;
        }

        int n = cardPoints.length;
        int[] start2end = new int[n + 1];
        int[] end2start = new int[n + 1];
//        start2end[0] = cardPoints[0];
//        end2start[0] = cardPoints[n - 1];
        for (int i = 1; i <= n; i++) {
            start2end[i] = cardPoints[i - 1] + start2end[i - 1];
            end2start[i] = cardPoints[n - i] + end2start[i - 1];
        }

        int res = 0;
        for (int i = 0; i <= k; i++) {
            res = Math.max(res, start2end[i] + end2start[k - i]);
        }

        return res;
    }
}
