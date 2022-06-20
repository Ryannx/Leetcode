package LC_1268;

import java.util.*;

public class LC_1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        if (products == null || searchWord == null) {
            return new ArrayList<>();
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = 0;
                int j = 0;
                int n = o1.length();
                int m = o2.length();
                while (i < n && j < m) {
                    if (o1.charAt(i) == o2.charAt(j)) {
                        i++;
                        j++;
                        continue;
                    }
                    if (o1.charAt(i) < o2.charAt(j)) return -1;
                    return 1;
                }
                if (i == n) return -1;
                return 1;
            }
        };

        Arrays.sort(products, comparator);

        TrieNode root = new TrieNode();
        root.initial(products);
        for (int i = 0; i < products.length; i++) {
            root.addWord(products[i], i);
        }
        return root.search(searchWord);
    }

    public static void main(String[] args) {
        LC_1268 lc_1268 = new LC_1268();
        String[] products = {"code","codephone","coddle","coddles","codes"};
        String searchWord = "coddle";
        System.out.println(lc_1268.suggestedProducts(products, searchWord));
    }
}
