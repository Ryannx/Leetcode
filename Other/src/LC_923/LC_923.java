package LC_923;

public class LC_923 {
    private int M;
    public int threeSumMulti(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        M = (int) 1e9 + 7;
        int[] count = new int[101];
        for (int num : arr) {
            count[num]++;
        }

        long res = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            // i != j != k
            for (int j = i + 1; j < count.length; j++) {
                int k = target - i - j;
                if (k < 0 || k > 100 || k <= j || count[j] == 0 || count[k] == 0) continue;
                res += ((long) count[i] * count[j] * count[k]) % M;
                res %= M;
            }
            // i = j != k
            if (target - 2 * i > i && target - 2 * i <= 100 && count[target - 2 * i] != 0 && count[i] >= 2) {
                res += ((long) count[target - 2 * i] * count[i] * ((count[i]) - 1) / 2) % M ;
                res %= M;
            }
            // i != j = k
            if ((target - i) % 2 == 0 && (target - i) / 2 > i && (target - i) / 2 <= 100 && count[(target - i) / 2] >= 2) {
                res += ((long) count[i] * count[(target - i) / 2] * (count[(target - i) / 2] - 1) / 2) % M;
                res %= M;
            }

        }

        // i = j = k
        if (target % 3 == 0 && count[target / 3] >= 3) {
            res += (long) count[target / 3] * (count[target / 3] - 1) * (count[target / 3] - 2) / 6;
            res %= M;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        LC_923 lc_923 = new LC_923();
        int[] arr = new int[3000];
        int target = 0;
        System.out.println(lc_923.threeSumMulti(arr, target));
    }
}
