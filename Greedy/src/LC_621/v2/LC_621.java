package LC_621.v2;

public class LC_621 {
    public int leastInterval(char[] tasks, int n) {

        if (tasks == null) {
            return 0;
        }

        int[] count = new int[26];
        for (char ch : tasks) {
            count[ch - 'A']++;
        }

        int maxFreq = 0;
        int numOfMaxFreq = 0;
        for (int f : count) {
            maxFreq = Math.max(maxFreq, f);
        }
        for (int f : count) {
            if (f == maxFreq) {
                numOfMaxFreq++;
            }
        }

        int len = n + 1;
        return Math.max(numOfMaxFreq + (maxFreq - 1) * len, tasks.length);
    }
}
