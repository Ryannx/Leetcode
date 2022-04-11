package LC_1891;

public class LC_1891 {
    public int maxLength(int[] ribbons, int k) {

        if (ribbons == null || ribbons.length == 0) {
            return 0;
        }

        int start = 1;
        int end = (int) 1e5;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (countCut(ribbons, mid) >= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (end > (int) 1e5 || end < 1) return 0;
        return end;
    }

    private int countCut(int[] ribbons, int num) {

        int count = 0;
        for (int n : ribbons) {
            count += n / num;
        }
        return count;
    }
}
