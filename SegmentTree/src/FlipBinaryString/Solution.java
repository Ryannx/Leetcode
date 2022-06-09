package FlipBinaryString;

// You are given a string binarystring consisting of O' sand '1' s, as well as an array of strings requests containing requests of two types:
// requests[i] = "count" - find the amount of '1' s in binarystring;
// requests[i] = "flip" - find the leftmost 'O' in binarystring (say it is located at binaryString[index] ) and flip all elements of binarystring[O..index]
// i.e. change all 'O' sto "1' s. and "1' s to 'O' s. The answer for this request is index
// Return an array answers of the same length as requests, where answers [i] contains the answer for requests[i]
// Example:
// -For binarystring = "101000" and requests = ["count","lip", "flip","flip", "count"] , the output should be solution(binarystring, requests) = [2, 1, 0, 3, 1]
// Explaination:
// requests [0] - "count" : the current string binaryString = "101000" contains two 1 s;
// requests[1] = "flip" : the current string binarystring = "101000" has the first o at index 1. After flipping binarystring[0..1], it becomes "011000"
// requests [2] = "flip" : the current string binarystring = "011000" has the first o at index o. After flipping binarystring[O..0] , it becomes "111000"
// requests[3] = "flip" : the current string binarystring = "111000" has the first o at index 3 . After flipping binarystring[O..3], it becomes "000100"
// requests [4] = "count" : the current string binarystring = "000100" contains one 1
// The answers for the requests are 2. 1. 0. 3, and 1, respectively, so the output of the function is [2, 1, 0, 3, 1]
// (input) string binaryString
// A string consisting of 'O' sand "1' s
// Guaranteed constraints:
// 1 <= binarystring. length <= 10^5
// [input] array.string requests
// An array of strings representing the requests. It is guaranteed that each requests[i] is either "count" or "flip"
// Guaranteed constraints:
// 1 ≤ requests. length ≤ 10^5
public class Solution {

    public int[] solution(String binaryString, String[] requests) {

        if (binaryString == null || requests == null) {
            return null;
        }

        int n = binaryString.length();
        int m = requests.length;
        SegTreeNode root = new SegTreeNode(0, n - 1);
        root.initial(root, 0, n - 1, binaryString);
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            if (requests[i].equals("count")) {
                res[i] = root.getOneAmount();
            } else {
                res[i] = root.getZeroIdx();
                for (int j = 0; j <= res[i]; j++) {
                    root.updateRange(root, j, j);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String binaryString = "10000100";
        String[] requests = {"flip", "flip", "flip", "flip", "flip"};
        int[] res = solution.solution(binaryString, requests);
        for (int n : res) {
            System.out.println(n);
        }
    }
}
