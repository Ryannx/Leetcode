package LC_535;

import java.util.HashMap;
import java.util.Random;

public class Codec {

    private Random random;
    private HashMap<String, String> s2l; // [short, long]
    private static String dictionary = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        this.random = new Random();
        this.s2l = new HashMap<>();
        String res = getCode(longUrl);
        while (s2l.containsKey(res)) {
            res = getCode(longUrl);
        }
        s2l.put(res, longUrl);
        return res;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return s2l.get(shortUrl);
    }

    private String getCode(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            res.append(dictionary.charAt(random.nextInt(62)));
        }
        return res.toString();
    }
}
