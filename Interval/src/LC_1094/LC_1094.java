package LC_1094;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC_1094 {
    public boolean carPooling(int[][] trips, int capacity) {

        if (trips == null || trips.length == 0) {
            return true;
        }

        List<int[]> pointsList = new ArrayList<>(); // [location, isStart, #]
        for (int[] trip : trips) {
            pointsList.add(new int[] {trip[1], -1, trip[0]});
            pointsList.add(new int[] {trip[2], 1, trip[0]});
        }

        Comparator<int[]> comparator = (a, b) -> (a[0] == b[0] ?
                (a[1] == b[1] ? 0 : (a[1] == 1 ? -1 : 1)) : a[0] - b[0]);
        Collections.sort(pointsList, comparator);

        int i = 0;
        int numOfPeople = 0;
        int len = pointsList.size();
        while (i < len) {
            if (pointsList.get(i)[1] == -1) {
                numOfPeople += pointsList.get(i)[2];
                if (numOfPeople > capacity) {
                    return false;
                }
            } else {
                numOfPeople -= pointsList.get(i)[2];
            }
            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        LC_1094 lc_1094 = new LC_1094();
        int[][] trips = {{2,1,5}, {3,3,7}};
        System.out.println(lc_1094.carPooling(trips, 4));
    }
}
