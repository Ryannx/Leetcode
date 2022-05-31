package LC_1461;

public class LC_1461 {
    public boolean hasAllCodes(String s, int k) {

        if (s == null) {
            return false;
        }
        int count = 1 << k;
        int allOne = count - 1;
        int hashCode = 0;
        boolean[] visited = new boolean[count];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            hashCode = (hashCode << 1) & allOne | (s.charAt(i) - '0');
            if (i >= k - 1 && !visited[hashCode]) {
                count--;
                visited[hashCode] = true;
                if (count == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
