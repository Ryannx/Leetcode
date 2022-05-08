package LC_370;

public class LC_370 {
    public int[] getModifiedArray(int length, int[][] updates) {

        if (updates == null || updates.length == 0) {
            return new int[length];
        }

        int[] diff = new int[length + 1];
        for (int i = 0; i < updates.length; i++) {
            diff[updates[i][0]] += updates[i][2];
            diff[updates[i][1] + 1] -= updates[i][2];
        }

        int curVal = 0;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            curVal += diff[i];
            res[i] = curVal;
        }
        return res;
    }
}
