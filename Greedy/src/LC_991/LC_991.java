package LC_991;

public class LC_991 {
    public int brokenCalc(int startValue, int target) {

        return helper(startValue, target);
    }

    private int helper(int start, int end) {

        if (start >= end) {
            return start - end;
        } else if (end % 2 == 1) {
            return helper(start, end + 1) + 1;
        } else {
            return helper(start, end / 2) + 1;
        }
    }
}
