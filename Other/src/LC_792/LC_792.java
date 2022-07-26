package LC_792;

public class LC_792 {
    public int numMatchingSubseq(String s, String[] words) {

        if (s == null || words == null) {
            return 0;
        }

        String str = "#" + s;
        int m = s.length();
        int[][] nexts = new int[m + 1][26];
        for (int j = 0; j < 26; j++) {
            nexts[m][j] = -1;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                nexts[i][j] = nexts[i + 1][j];
            }
            nexts[i][str.charAt(i + 1) - 'a'] = i + 1;
        }

        int count = 0;
        for (String word : words) {
            boolean flag = true;
            int idx = 0;
            for (int i = 0; i < word.length(); i++) {
                if (nexts[idx][word.charAt(i) - 'a'] == -1) {
                    flag = false;
                    break;
                }
                idx = nexts[idx][word.charAt(i) - 'a'];
            }
            if (flag) count++;
        }

        return count;
    }
}
