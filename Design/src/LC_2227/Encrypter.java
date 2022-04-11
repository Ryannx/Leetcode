package LC_2227;

import java.util.*;

public class Encrypter {

    private HashMap<String, Integer> str2amount;
    private HashMap<Character, Integer> key2idx;
    private String[] values;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        this.values = values;
        this.str2amount = new HashMap<>();
        key2idx = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            key2idx.put(keys[i], i);
        }
        for (String word : dictionary) {
            String code = this.encrypt(word);
            if (code.equals("")) continue;
            Integer amount = str2amount.getOrDefault(code, 0);
            amount++;
            str2amount.put(code, amount);
        }
    }

    public String encrypt(String word1) {

        if (word1 == null) return "";
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < word1.length(); i++) {
            char cur = word1.charAt(i);
            Integer idx = key2idx.get(cur);
            if (idx == null || idx >= this.values.length)
                return "";
            res.append(values[idx]);
        }

        return res.toString();
    }

    public int decrypt(String word2) {

        if (word2 == null || word2.length() == 0) {
            return 0;
        }

        Integer res = str2amount.get(word2);
        if (res == null) return 0;
        return res;
    }

    public static void main(String[] args) {
        char[] keys = {'a','b','c','d'};
        String[] values = {"ei","zf","ei","am"};
        String[] dictionary = {"abcd","acbd","adbc","badc","dacb","cadb","cbda","abad"};
        Encrypter encrypter = new Encrypter(keys, values, dictionary);
        System.out.println(encrypter.decrypt("eizfeiam"));
    }
}
