package LC_1465;

import java.util.Arrays;

public class LC_1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        if (horizontalCuts == null && verticalCuts == null) {
            return 0;
        }

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int m = horizontalCuts.length;
        int n = verticalCuts.length;
        long base = (long) 1e9 + 7;

        int[] hTemp = new int[m + 1];
        hTemp[0] = horizontalCuts[0];
        long hCut = hTemp[0];
        for (int i = 1; i < m; i++) {
            hTemp[i] = horizontalCuts[i] - horizontalCuts[i - 1];
            hCut = Math.max(hCut, hTemp[i]);
        }
        hTemp[m] = h - horizontalCuts[m - 1];
        hCut = Math.max(hCut, hTemp[m]);

        int[] vTemp = new int[n + 1];
        vTemp[0] = verticalCuts[0];
        long vCut = vTemp[0];
        for (int i = 1; i < n; i++) {
            vTemp[i] = verticalCuts[i] - verticalCuts[i - 1];
            vCut = Math.max(vCut, vTemp[i]);
        }
        vTemp[n] = w - verticalCuts[n - 1];
        vCut = Math.max(vCut, vTemp[n]);

        return (int) (hCut * vCut % base);
    }
}
