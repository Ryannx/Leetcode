package LC_1010;

public class LC_1010 {
    public int numPairsDivisibleBy60(int[] time) {

        if (time == null || time.length == 0) {
            return 0;
        }

        int[] bucket = new int[60];
        int count = 0;
        for (int t : time) {
            if (t % 60 == 0) {
                count += bucket[0];
            } else { // 60 - t % 60
                count += bucket[60 - t % 60];
            }
            bucket[t % 60]++;
        }

        return count;
    }

    public static void main(String[] args) {
        LC_1010 lc_1010 = new LC_1010();
        int[] time = {30,20,150,100,40};
        System.out.println(lc_1010.numPairsDivisibleBy60(time));
    }
}
