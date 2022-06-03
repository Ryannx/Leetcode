package LC_1386;

import java.util.*;

public class LC_1386 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        if (reservedSeats == null) {
            return 0;
        }
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            HashSet<Integer> set = map.getOrDefault(seat[0], new HashSet<>());
            set.add(seat[1]);
            map.put(seat[0], set);
        }

        int count = n;
        int res = 0;
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            boolean[] validSeat = new boolean[4];
            Arrays.fill(validSeat, true);
            HashSet<Integer> set = entry.getValue();
            if (set.contains(2) || set.contains(3)) {
                validSeat[0] = false;
            }
            if (set.contains(4) || set.contains(5)) {
                validSeat[1] = false;
            }
            if (set.contains(6) || set.contains(7)) {
                validSeat[2] = false;
            }
            if (set.contains(8) || set.contains(9)) {
                validSeat[3] = false;
            }
            if (validSeat[1] && validSeat[2]) {
                if (validSeat[0] && validSeat[3]) {
                    res += 2;
                } else {
                    res += 1;
                }
            } else if (validSeat[0] && validSeat[1]) {
                res += 1;
            } else if (validSeat[2] && validSeat[3]) {
                res += 1;
            }
            count--;
        }
        res += (count *  2);
        return res;
    }
}
