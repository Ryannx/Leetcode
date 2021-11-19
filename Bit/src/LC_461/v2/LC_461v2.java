package LC_461.v2;

public class LC_461v2 {

    public int hammingDistance(int x, int y) {

        int res = 0;
        for (int i = 0; i < 31; i++) {
            int rx = x % 2;
            int ry = y % 2;
            if (rx != ry) {
                res++;
            }
            x = x >> 1;
            y = y >> 1;
        }

        return res;
    }
}
