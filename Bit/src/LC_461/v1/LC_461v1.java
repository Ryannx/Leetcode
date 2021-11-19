package LC_461.v1;

public class LC_461v1 {
    public int hammingDistance(int x, int y) {

        return Integer.bitCount(x ^ y);
    }
}
