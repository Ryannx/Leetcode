package LC_2276;

import java.util.TreeMap;

public class CountIntervals {
    private TreeMap<Integer, Integer> intervals;
    private int count;
    public CountIntervals() {
        this.intervals = new TreeMap<>();
    }

    public void add(int left, int right) {

        if (intervals.floorKey(right) == null || intervals.get(intervals.floorKey(right)) < left) {
            intervals.put(left, right);
            count += right - left + 1;
        } else {
            // merge all overlap
            int start = left;
            int end = right;
            while (true) {
                int l = intervals.floorKey(end);
                int r = intervals.get(l);
                start = Math.min(start, l);
                end = Math.max(end, r);
                count -= r - l + 1;
                intervals.remove(l);
                // break
                if (intervals.floorKey(end) == null || intervals.get(intervals.floorKey(end)) < start) {
                    intervals.put(start, end);
                    count += end - start + 1;
                    break;
                }
            }
        }
    }

    public int count() {
        return this.count;
    }
}
