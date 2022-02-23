package LC_631;

import java.util.*;

public class Excel {
    private int[][] vals;
    private List<String>[][] expressions;
    public Excel(int height, char width) {

        this.vals = new int[height + 1][width - 'A' + 1];
        this.expressions = new List[height + 1][width - 'A' + 1];
    }

    public void set(int row, char column, int val) {

        this.vals[row][column - 'A'] = val;
        this.expressions[row][column - 'A'] = null;
    }

    public int get(int row, char column) {

        if (expressions[row][column - 'A'] == null) {
            return vals[row][column - 'A'];
        }
        int res = 0;
        for (String exp : expressions[row][column - 'A']) {
            if (!exp.contains(":")) {
                res += get(Integer.parseInt(exp.substring(1)), exp.charAt(0));
            } else {
                int[] range = parse(exp);
                for (int i = range[0]; i <= range[2]; i++) {
                    for (int j = range[1]; j <= range[3]; j++) {
                        res += get(i, (char) (j + 'A'));
                    }
                }
            }
        }

        return res;
    }

    private int[] parse(String exp) {

        String[] arr = exp.split(":");
        int[] res = new int[4];
        res[0] = Integer.parseInt(arr[0].substring(1));
        res[1] = arr[0].charAt(0) - 'A';
        res[2] = Integer.parseInt(arr[1].substring(1));
        res[3] = arr[1].charAt(0) - 'A';
        return res;
    }

    public int sum(int row, char column, String[] numbers) {

        this.expressions[row][column - 'A'] = Arrays.asList(numbers);
        return get(row, column);
    }

    public static void main(String[] args) {
        Excel excel = new Excel(3, 'C');
        excel.set(1, 'A', 2);
        System.out.println(excel.sum(3, 'C', new String[] {"A1", "A1:B2"}));
        excel.set(2, 'B', 2);
        excel.get(3, 'C');
    }
}
