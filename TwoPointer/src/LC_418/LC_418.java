package LC_418;

public class LC_418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {

        if (sentence == null || sentence.length == 0 || rows <= 0 || cols <= 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        for (String word : sentence) {
            if (word.length() > cols) {
                return 0;
            }
            sb.append(word).append(" ");
        }

        int idx = 0;
        int len = sb.length();
        for (int r = 0; r < rows; r++) {
            idx += cols;
            while (sb.charAt(idx % len) != ' ') {
                idx--;
            }
            idx++;
        }

        return idx / len;
    }

    public static void main(String[] args) {
        LC_418 lc_418 = new LC_418();
        String[] sentence = {"hello"};
        System.out.println(lc_418.wordsTyping(sentence, 2, 3));
    }
}
