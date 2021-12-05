package LC_907;

import java.util.HashMap;
import java.util.Stack;

public class LC_907 {
    public int sumSubarrayMins(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        long res = 0;
        int len = arr.length;
        int M = (int) 1e9 + 7;
        HashMap<Integer, Integer> prevSmallerMap = getPrevSmallerOrEqual(arr);
        HashMap<Integer, Integer> nextSmallerMap = getNextSmaller(arr);

        for (int i = 0; i < len; i++) {
            int prevSmaller = prevSmallerMap.getOrDefault(i, -1);
            int nextSmaller = nextSmallerMap.getOrDefault(i, len);
            long num = (long) (arr[i] * (i - prevSmaller)) % M * (nextSmaller - i) % M;
            res = (res + num) % M;
        }

        return (int) res;
    }

    private HashMap<Integer, Integer> getNextSmaller(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        return map;
    }

    private HashMap<Integer, Integer> getPrevSmallerOrEqual(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        return map;
    }

    public static void main(String[] args) {
        LC_907 lc_907 = new LC_907();
        int[] arr = {2,1,3,1};
        System.out.println(lc_907.sumSubarrayMins(arr));
    }
}
