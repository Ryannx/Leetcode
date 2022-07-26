package LC_473;

import java.util.*;

public class LC_473 {
    public boolean makesquare(int[] matchsticks) {

        if (matchsticks == null) {
            return false;
        }

        int n = matchsticks.length;
        int sum = 0;
        for (int stick : matchsticks) {
            sum += stick;
        }
        if (sum % 4 != 0) return false;
        int len = sum / 4;
        Arrays.sort(matchsticks);
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = matchsticks[n - 1 - i];
        }
        matchsticks = temp;

        boolean[] visited = new boolean[n];
        return dfs(matchsticks, visited, len, 0, 0, 0);
    }

    private boolean dfs(int[] matchsticks, boolean[] visited, int len, int idx, int group, int sum) {

        if (sum > len) return false;
        if (group == 4) return true;
        if (sum == len) {
            return dfs(matchsticks, visited, len, 0, group + 1, 0);
        }

        int last = -1;
        for (int i = idx; i < matchsticks.length; i++) {
            if (visited[i]) continue;
            if (matchsticks[i] == last) continue;
            visited[i] = true;
            last = matchsticks[i];
            if (dfs(matchsticks, visited, len, i + 1, group, sum + matchsticks[i])) {
                return true;
            }

            visited[i] = false;
        }

        return false;
    }
}
