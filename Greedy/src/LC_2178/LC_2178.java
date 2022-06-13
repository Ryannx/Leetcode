package LC_2178;

import java.util.*;
public class LC_2178 {
    public List<Long> maximumEvenSplit(long finalSum) {

        if (finalSum % 2 != 0) {
            return new ArrayList<>();
        }

        List<Long> path = new ArrayList<>();
        long sum = 0;
        long i = 2;
        while (true) {
            sum += i;
            path.add(i);
            if (sum == finalSum) {
                return path;
            }
            if (sum > finalSum) {
                long temp = sum - finalSum;
                path.remove(temp);
                return path;
            }
            i += 2;
        }
    }

    public static void main(String[] args) {
        LC_2178 lc_2178 = new LC_2178();
        System.out.println(lc_2178.maximumEvenSplit(2));
    }
}
