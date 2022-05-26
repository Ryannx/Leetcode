package LC_354;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC_354 {
    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Comparator<int[]> comparator = (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        Arrays.sort(envelopes, comparator);
        List<Integer> list = new ArrayList<>();
        for (int[] e : envelopes) {
            if (list.size() == 0 || list.get(list.size() - 1) < e[1]) {
                list.add(e[1]);
            } else {
                update(list, e[1]);
            }
        }

        return list.size();
    }

    private void update(List<Integer> list, int targe) {

        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) < targe) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        list.set(start, targe);
    }
}
