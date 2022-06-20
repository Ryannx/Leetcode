package LC_2310;

public class LC_2310 {
    public int minimumNumbers(int num, int k) {

        if (num == 0) {
            return 0;
        }
        if (num == k) {
            return 1;
        }
        int numLastDigit = getLastDigit(num);
        if (k == 1) {
            if (numLastDigit == 0) return 10;
            return numLastDigit;
        }
        if (numLastDigit % 2 != 0 && k % 2 == 0) {
            return -1;
        }

        int temp = k;
        for (int i = 1; i <= 10; i++) {
            temp = k * i;
            if (temp > num) {
                return -1;
            }
            int curLastDigit = getLastDigit(temp);
            if (curLastDigit == numLastDigit) {
                return i;
            }
        }
        return -1;
    }

    private int getLastDigit(int num) {
        String sum = String.valueOf(num);
        int lastDigit = Integer.parseInt(String.valueOf(sum.charAt(sum.length() - 1)));
        return lastDigit;
    }
}
