package LC_1649;

import java.util.Arrays;

public class LC_1649 {

    private int M;
    public int createSortedArray(int[] instructions) {

        if (instructions == null || instructions.length == 0) {
            return 0;
        }

        M = (int) 1e9 + 7;
        int[] sortedArr = Arrays.copyOf(instructions, instructions.length);
        int[] smaller = new int[instructions.length];
        int[] count = new int[(int) 1e5 + 1];
        helper(instructions, sortedArr, smaller, 0, instructions.length - 1);
        int res = 0;
        for (int i = 0; i < instructions.length; i++) {
            res += Math.min(smaller[i], i - smaller[i] - count[instructions[i]]);
            res %= M;
            count[instructions[i]]++;
        }
        return res;
    }

    // the number of elements smaller than current idx element
    private void helper(int[] instructions, int[] sortedArr, int[] smaller, int start, int end) {

        if (start == end) {
            return;
        }

        int mid = start + (end - start) / 2;
        helper(instructions, sortedArr, smaller, start, mid);
        helper(instructions, sortedArr, smaller, mid + 1, end);
        for (int i = mid + 1; i <= end; i++) {
            int idx =  getFloor(sortedArr, instructions[i], start, mid);
            smaller[i] += idx - start + 1;
            smaller[i] %= M;
        }
        int[] temp = new int[end - start + 1];
        int l = start;
        int r = mid + 1;
        int p = 0;
        while (l <= mid && r <= end) {
            if (sortedArr[l] < sortedArr[r]) {
                temp[p] = sortedArr[l];
                l++;
            } else {
                temp[p] = sortedArr[r];
                r++;
            }
            p++;
        }
        while (l <= mid) {
            temp[p] = sortedArr[l];
            l++;
            p++;
        }
        while (r <= end) {
            temp[p] = sortedArr[r];
            r++;
            p++;
        }
        for (int i = start; i <= end; i++) {
            sortedArr[i] = temp[i - start];
        }
    }

    private int getFloor(int[] sortedArr, int target, int s, int e) {
        int start = s;
        int end = e;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (sortedArr[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        LC_1649 lc_1649 = new LC_1649();
        int[] instructions = {1,5,6,2};
        System.out.println(lc_1649.createSortedArray(instructions));
    }
}
