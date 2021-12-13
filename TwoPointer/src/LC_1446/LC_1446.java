package LC_1446;

public class LC_1446 {
    public int maxPower(String s) {

        if (s == null) {
            return 0;
        }

        int slow = 0;
        int fast = 0;
        int len = s.length();
        int res = 0;
        while (slow < len) {
            int count = 0;
            while (fast < len && s.charAt(fast) == s.charAt(slow)) {
                fast++;
                count++;
            }
            res = Math.max(res, count);
            slow = fast;
        }

        return res;
    }
}
