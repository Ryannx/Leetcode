package Eratosthenes;

import java.util.ArrayList;
import java.util.List;

public class Eratosthenes {

    private int[] arr;
    private int n;
    public Eratosthenes(int n) {
        this.arr = new int[n + 1];
        this.n = n;
    }

    public List<Integer> getPrimes() {

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (arr[i] != 1) {
                int j = i * 2;
                while (j <= n) {
                    arr[j] = 1;
                    j += i;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                res.add(i);
            }
        }

        return res;
    }
}
