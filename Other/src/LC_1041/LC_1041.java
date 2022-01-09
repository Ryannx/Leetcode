package LC_1041;

public class LC_1041 {
    public boolean isRobotBounded(String instructions) {

        if (instructions == null || instructions.length() == 0) {
            return true;
        }

        int[] location = new int[2];
        char[] curDirection = {'U'};
        int count = 4;
        while (count-- > 0) {
            for (int i = 0; i < instructions.length(); i++) {
                char curCommend = instructions.charAt(i);
                update(location, curDirection, curCommend);
            }
            if (location[0] == 0 && location[1] == 0) {
                return true;
            }
        }

        return false;
    }

    private void update(int[] location, char[] curDirection, char curCommend) {

        if (curCommend == 'G') {
            if (curDirection[0] == 'U') {
                location[0] -= 1;
            } else if (curDirection[0] == 'L') {
                location[1] -= 1;
            } else if (curDirection[0] == 'D') {
                location[0] += 1;
            } else { // R
                location[1] += 1;
            }
        } else if (curCommend == 'L') {
            if (curDirection[0] == 'U') {
                curDirection[0] = 'L';
            } else if (curDirection[0] == 'L') {
                curDirection[0] = 'D';
            } else if (curDirection[0] == 'D') {
                curDirection[0] = 'R';
            } else { // R
                curDirection[0] ='U';
            }
        } else { // R
            if (curDirection[0] == 'U') {
                curDirection[0] = 'R';
            } else if (curDirection[0] == 'L') {
                curDirection[0] = 'U';
            } else if (curDirection[0] == 'D') {
                curDirection[0] = 'L';
            } else { // R
                curDirection[0] = 'D';
            }
        }
    }

    public static void main(String[] args) {
        LC_1041 lc_1041 = new LC_1041();
        String instructions = "GGLLGG";
        System.out.println(lc_1041.isRobotBounded(instructions));
    }
}
