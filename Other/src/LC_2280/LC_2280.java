package LC_2280;

import java.util.*;

public class LC_2280 {
    public int minimumLines(int[][] stockPrices) {

        if (stockPrices == null) {
            return 0;
        }

        int n = stockPrices.length;
        int count = n - 1;
        Comparator<int[]> c = (a, b) -> (a[0] - b[0]);
        Arrays.sort(stockPrices, c);
        for (int i = 1; i + 1 < n; i++) {
            if ((long) (stockPrices[i][1] - stockPrices[i - 1][1]) * (stockPrices[i + 1][0] - stockPrices[i][0])
                    == (long) (stockPrices[i + 1][1] - stockPrices[i][1]) * (stockPrices[i][0] - stockPrices[i - 1][0])) {
                count--;
            }
        }

        return count;
    }
}
