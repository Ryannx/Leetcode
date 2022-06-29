package LC_406;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class LC_406 {
    public int[][] reconstructQueue(int[][] people) {

        if (people == null || people.length == 0) {
            return null;
        }

        Comparator<int[]> comparator = (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        Arrays.sort(people, comparator);
        LinkedList<int[]> temp = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            if (temp.size() == 0) {
                temp.add(people[i]);
                continue;
            }
            int pos = people[i][1];
            temp.add(pos, people[i]);
        }

        int[][] res = new int[people.length][2];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }

        return res;
    }
}
