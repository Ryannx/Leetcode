package LC_843;

import java.util.*;

public class LC_843 {

    private static class Master {

        public Master() {}
        public int guess(String word) {
            return 1;
        }
    }

    public void findSecretWord(String[] wordlist, Master master) {

        Random random = new Random();
        List<String> list = Arrays.asList(wordlist);
        for (int i = 0; i < 10; i++) {
            String curG = list.get(random.nextInt(list.size()));
            int k = master.guess(curG);
            if (k == 6) {
                return;
            }

            List<String> updateList = new ArrayList<>();
            for (String word : list) {
                if (getMatch(word, curG) == k) {
                    updateList.add(word);
                }
            }
            list = updateList;
        }
    }

    private int getMatch(String str1, String str2) {

        int res = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                res++;
            }
        }
        return res;
    }
}
