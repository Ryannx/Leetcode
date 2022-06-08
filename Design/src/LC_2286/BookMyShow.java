package LC_2286;

import java.util.*;

public class BookMyShow {

    private SegTreeNode root;
    private int pivot;
    private int[] seats;
    private int m, n;
    public BookMyShow(int n, int m) {
        this.root = new SegTreeNode(0, n - 1);
        this.root.initial(root, 0, n - 1, m);
        this.pivot = 0;
        this.seats = new int[n];
        Arrays.fill(seats, m);
        this.m = m;
        this.n = n;
    }

    public int[] gather(int k, int maxRow) {

        int start = pivot;
        int end = maxRow;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (root.queryRangeMax(root, pivot, mid) >= k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (start > maxRow || seats[start] < k) {
            return new int[] {};
        }
        seats[start] -= k;
        if (seats[pivot] == 0) {
            pivot++;
        }
        root.updateRange(root, start, start, seats[start]);
        return new int[] {start, m - (seats[start] + k)};
    }

    public boolean scatter(int k, int maxRow) {

        if (root.queryRangeSum(root, 0, maxRow) < k) {
            return false;
        }
        int remainSeats = k;
        while (remainSeats > 0) {
            int rowValid = Math.min(remainSeats, seats[pivot]);
            seats[pivot] -= rowValid;
            remainSeats -= rowValid;
            root.updateRange(root, pivot, pivot, seats[pivot]);
            if (seats[pivot] == 0) {
                pivot++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow(2, 5);
        int[] temp = bookMyShow.gather(4, 0);
        for (int n : temp) {
            System.out.println(n);
        }
        int[] arr2 = bookMyShow.gather(2, 0);
        for (int n : arr2) {
            System.out.println(n);
        }
        System.out.println(bookMyShow.scatter(5, 1));
//        System.out.println(bookMyShow.scatter(5, 1));
    }
}
