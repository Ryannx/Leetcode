package LC_2320;

public class LC_2320 {
    public int countHousePlacements(int n) {

        long base = (long) 1e9 + 7;
        long house = 1;
        long space = 1;
        long total = house + space;
        for (int i = 2; i <= n; i++) {
            house = space;
            space = total;
            total = (house + space) % base;
        }

        return (int) ((total * total) % base);
    }
}
