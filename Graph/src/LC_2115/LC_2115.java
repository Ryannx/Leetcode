package LC_2115;

import java.util.*;

public class LC_2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        HashMap<String, List<String>> graph = new HashMap<>();
        HashMap<String, Integer> indegree = new HashMap<>();
        HashSet<String> targets = new HashSet<>();
        int len = recipes.length;
        for (int i = 0; i < len; i++) {
            List<String> cur = ingredients.get(i);
            targets.add(recipes[i]);
            for (int j = 0; j < cur.size(); j++) {
                List<String> nexts = graph.getOrDefault(cur.get(j), new ArrayList<>());
                nexts.add(recipes[i]);
                graph.put(cur.get(j), nexts);
                Integer val = indegree.getOrDefault(recipes[i], 0);
                val++;
                indegree.put(recipes[i], val);
            }
        }

        Queue<String> queue = new LinkedList<>();
        for (String s : supplies) {
            queue.add(s);
        }
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (targets.contains(cur)) {
                res.add(cur);
            }
            List<String> nexts = graph.get(cur);
            if (nexts == null) {
                continue;
            }
            for (String next : nexts) {
                Integer val = indegree.get(next);
                val--;
                indegree.put(next, val);
                if (val == 0) {
                    queue.add(next);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC_2115 lc_2115 = new LC_2115();
        String[] recipes = {"bread"};
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("yeast","flour"));
        String[] supplies = {"yeast","flour","corn"};
        System.out.println(lc_2115.findAllRecipes(recipes, ingredients, supplies));
    }
}
