package LC_954;

import java.util.TreeMap;

public class LC_954 {
    public boolean canReorderDoubled(int[] arr) {

        if (arr == null) {
            return true;
        }

        TreeMap<Integer, Integer> negativePool = new TreeMap<>(); // [val, count]
        TreeMap<Integer, Integer> positivePool = new TreeMap<>();
        int zeroCount = 0;
        int negativeCount = 0;
        int positiveCount = 0;
        for (int num : arr) {
            if (num < 0) {
                int count = negativePool.getOrDefault(num, 0);
                negativePool.put(num, count + 1);
                negativeCount++;
            } else if (num > 0) {
                int count = positivePool.getOrDefault(num, 0);
                positivePool.put(num, count + 1);
                positiveCount++;
            } else {
                zeroCount++;
            }
        }

        if (negativeCount % 2 != 0 || positiveCount % 2 != 0 || zeroCount % 2 != 0) {
            return false;
        }

        while (!positivePool.isEmpty()) {
            int cur = positivePool.firstKey();
            Integer biggerCount = positivePool.get(cur * 2);
            if (biggerCount == null) {
                return false;
            }
            int curCount = positivePool.get(cur);
            if (biggerCount < curCount) {
                return false;
            }
            if (biggerCount == curCount) {
                positivePool.remove(cur * 2);
            } else {
                positivePool.put(cur * 2, biggerCount - curCount);
            }
            positivePool.remove(cur);
        }
        if (!positivePool.isEmpty()) {
            return false;
        }

        while (!negativePool.isEmpty()) {
            int cur = negativePool.lastKey();
            Integer smallerCount = negativePool.get(cur * 2);
            if (smallerCount == null) {
                return false;
            }
            int curCount = negativePool.get(cur);
            if (smallerCount < curCount) {
                return false;
            }
            if (smallerCount == curCount) {
                negativePool.remove(cur * 2);
            } else {
                negativePool.put(cur * 2, smallerCount - curCount);
            }
            negativePool.remove(cur);
        }
        if (!negativePool.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        LC_954 lc_954 = new LC_954();
        int[] arr = {1,2,1,-8,8,-4,4,-4,2,-2};
        System.out.println(lc_954.canReorderDoubled(arr));
    }
}
