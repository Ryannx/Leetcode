package LC_527;

import java.util.*;

public class LC_527 {
    public List<String> wordsAbbreviation(List<String> words) {

        if (words == null || words.size() == 0) {
            return new ArrayList<>();
        }

        int n = words.size();
        String[] res = new String[n];
        HashMap<String, List<Integer>> abbr2idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String cur = words.get(i);
            if (cur.length() <= 3) {
                res[i] = cur;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(cur.charAt(0)).append(cur.length() - 2).append(cur.charAt(cur.length() - 1));
            String abbr = sb.toString();
            List<Integer> list = abbr2idx.getOrDefault(abbr, new ArrayList<>());
            list.add(i);
            abbr2idx.put(abbr, list);
        }

        while (true) {
            HashMap<String, List<Integer>> temp = new HashMap<>();
            for (Map.Entry<String, List<Integer>> entry : abbr2idx.entrySet()) {
                if (entry.getValue().size() == 1) {
                    res[entry.getValue().get(0)] = entry.getKey();
                } else {
                    for (int idx : entry.getValue()) {
                        String word = words.get(idx);
                        String abbr = getAbbr(word, entry.getKey());
                        List<Integer> list = temp.getOrDefault(abbr, new ArrayList<>());
                        list.add(idx);
                        temp.put(abbr, list);
                    }
                }
                abbr2idx = temp;
            }
            if (temp.isEmpty()) return Arrays.asList(res);
        }
    }

    private String getAbbr(String word, String curAbbr) {

        StringBuilder sb = new StringBuilder();
        for (int i = curAbbr.length() - 2; i >= 0; i--) {
            if (curAbbr.charAt(i) >= '0' && curAbbr.charAt(i) <= '9') {
                sb.append(curAbbr.charAt(i));
            } else {
                sb.reverse();
                break;
            }
        }
        int num = Integer.parseInt(sb.toString());
        if (num == 2) {
            return word;
        }
        sb = new StringBuilder();
        String firstPart = word.substring(0, word.length() - num);
        sb.append(firstPart).append(num - 1).append(word.charAt(word.length() - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        LC_527 lc_527 = new LC_527();
        List<String> words = Arrays.asList("innal","inval");
        System.out.println(lc_527.wordsAbbreviation(words));
    }
}
