package LC_11;

public class LC_11 {
    public int maxArea(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int len = height.length;
        int left = 0;
        int right = len - 1;
        int res = 0;
        while (left < right) {
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
