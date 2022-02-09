package LC_777;

public class LC_777 {
    public boolean canTransform(String start, String end) {

        int len = start.length();
        int i = 0;
        int j = 0;
        while (i < len && j < len) {
            while (i < len && start.charAt(i) == 'X') {
                i++;
            }
            if (i == len) {
                break;
            }
            while (j < len && end.charAt(j) == 'X') {
                j++;
            }
            if (j == len) {
                break;
            }
            if (i < len && j < len && start.charAt(i) != end.charAt(j)) {
                return false;
            }
            if (i < len && j < len && start.charAt(i) == 'R' && i > j) {
                return false;
            }
            if (i < len && j < len && start.charAt(i) == 'L' && i < j) {
                return false;
            }
            i++;
            j++;
        }

        while (i < len) {
            if (start.charAt(i) != 'X') {
                return false;
            }
            i++;
        }
        while (j < len) {
            if (end.charAt(j) != 'X') {
                return false;
            }
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        LC_777 lc_777 = new LC_777();
        String start = "X";
        String end = "L";
        System.out.println(lc_777.canTransform(start, end));
    }
}
