package LC_370;

public class LC_370 {
    public int[] getModifiedArray(int length, int[][] updates) {

        if (updates == null || updates.length == 0) {
            return new int[length];
        }

        SegTreeNode root = new SegTreeNode(0, length - 1);
        root.initial(root, 0, length - 1);
        for (int i = 0; i < updates.length; i++) {
            root.updateRange(root, updates[i][0], updates[i][1], updates[i][2]);
        }

        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = root.querySingle(root, i);
        }

        return res;
    }

    public static void main(String[] args) {
        LC_370 lc_370 = new LC_370();
        int[][] updates = {{0,0,0}};
        lc_370.getModifiedArray(1, updates);
    }
}
