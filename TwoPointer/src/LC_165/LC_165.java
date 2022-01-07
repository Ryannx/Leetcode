package LC_165;

public class LC_165 {
    public int compareVersion(String version1, String version2) {

        if (version1 == null || version2 == null) {
            return 2;
        }

        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int i = 0;
        int len1 = str1.length;
        int len2 = str2.length;
        while (i < len1 && i < len2) {
            int cur1 = Integer.parseInt(str1[i]);
            int cur2 = Integer.parseInt(str2[i]);
            if (cur1 > cur2) {
                return 1;
            } else if (cur1 < cur2) {
                return -1;
            }
            i++;
        }

        if (len1 > len2) {
            while (i < len1) {
                int cur1 = Integer.parseInt(str1[i]);
                if (cur1 > 0) {
                    return 1;
                } else if (cur1 < 0) {
                    return -1;
                }
                i++;
            }
        } else {
            while (i < len2) {
                int cur2 = Integer.parseInt(str2[i]);
                if (cur2 > 0) {
                    return -1;
                } else if (cur2 < 0) {
                    return 1;
                }
                i++;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        LC_165 lc_165 = new LC_165();
        String str1 = "0.01";
        String str2 = "1.001";
        System.out.println(lc_165.compareVersion(str1, str2));
    }
}
