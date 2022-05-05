package LC_1157;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MajorityChecker {

    private HashMap<Integer, List<Integer>> num2positions;
    private SegTreeNode root;
    public MajorityChecker(int[] arr) {

        this.num2positions = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = num2positions.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            num2positions.put(arr[i], list);
        }

        this.root = new SegTreeNode(0, arr.length - 1);
        root.initial(root, 0, arr.length - 1, arr);
    }

    public int query(int left, int right, int threshold) {

        int[] candidate = root.queryRange(root, left, right); // [val, diff]
        List<Integer> positions = num2positions.get(candidate[0]);
        if (isValid(positions, left, right, threshold)) {
            return candidate[0];
        }
        return -1;
    }

    private boolean isValid(List<Integer> positions, int left, int right, int threshold) {

        int leftIdx = Collections.binarySearch(positions, left);
        int rightIdx = Collections.binarySearch(positions, right);
        int res = 0;
        if (leftIdx < 0 && rightIdx < 0) {
            res = Math.abs(leftIdx - rightIdx);
        } else if (leftIdx < 0) {
            res = rightIdx - (-leftIdx - 1) + 1;
        } else if (rightIdx < 0) {
            res = (-rightIdx - 1) - leftIdx;
        } else {
            res = rightIdx - leftIdx + 1;
        }

        return res >= threshold;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 1, 1};
        MajorityChecker majorityChecker = new MajorityChecker(arr);
        System.out.println(majorityChecker.query(2,3,2));
    }
}
