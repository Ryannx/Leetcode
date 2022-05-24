package LC_2237;

public class LC_2237 {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {

        if (lights == null || requirement == null) {
            return 0;
        }

        int[] diff = new int[n + 1];
        for (int i = 0; i < lights.length; i++) {
            int a = Math.max(0, lights[i][0] - lights[i][1]);
            int b = Math.min(n - 1, lights[i][0] + lights[i][1]);
            diff[a] += 1;
            diff[b + 1] -= 1;
        }

        int pivot = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            pivot += diff[i];
            if (pivot >= requirement[i]) {
                res++;
            }
        }
        return res;
    }
}
