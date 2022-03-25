package LC_1029;

import java.util.Arrays;
import java.util.Comparator;

public class LC_1029 {
    public int twoCitySchedCost(int[][] costs) {

        if (costs == null || costs.length == 0 || costs.length % 2 == 1 || costs[0].length == 0) {
            return 0;
        }

        Comparator<int[]> comparator = (a, b) -> ((a[0] - a[1]) - (b[0] - b[1]));
        Arrays.sort(costs, comparator);
        int n = costs.length / 2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (costs[i][0] + costs[i + n][1]);
        }

        return sum;
    }

    public static void main(String[] args) {
        LC_1029 lc_1029 = new LC_1029();
        int[][] costs = {{10,20},{30,200},{400,50},{1,20}};
        System.out.println(lc_1029.twoCitySchedCost(costs));
    }
}
