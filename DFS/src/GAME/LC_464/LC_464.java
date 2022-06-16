package GAME.LC_464;

import java.util.HashMap;

public class LC_464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        if (desiredTotal <= 0) {
            return true;
        }
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        HashMap<Integer, Boolean> memo = new HashMap<>();
        return dfs(desiredTotal, maxChoosableInteger, 0, 0, memo);
    }

    private boolean dfs(int desiredTotal, int maxChoosableInteger, int board, int sum, HashMap<Integer, Boolean> memo) {

        if (sum >= desiredTotal) {
            return false;
        }

        Boolean val = memo.get(board);
        if (val != null) {
            return val;
        }

        for (int i = 0; i < maxChoosableInteger; i++) {
            if ((board & (1 << i)) != 0) continue;
            if (!dfs(desiredTotal, maxChoosableInteger, board | (1 << i), sum + i + 1, memo)) {
                memo.put(board, true);
                return true;
            }
        }

        memo.put(board, false);
        return false;
    }

    public static void main(String[] args) {
        LC_464 lc_464 = new LC_464();
        int maxChoosableInteger = 7;
        int desiredTotal = 16;
        System.out.println(lc_464.canIWin(maxChoosableInteger, desiredTotal));
        System.out.println(5 & 4);
    }
}
