package LC_269.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_269 {

    private static class Vertex {
        private char aChar;
        private int indegree;
        private List<Vertex> nexts;
        public Vertex(char aChar) {
            this.aChar = aChar;
            this.indegree = 0;
            this.nexts = new ArrayList<>();
        }
    }
    public String alienOrder(String[] words) {

        if (words == null || words.length == 0) {
            return "";
        }

        // build graph
        Vertex[] graph = new Vertex[26];
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (graph[ch - 'a'] == null) {
                    graph[ch - 'a'] = new Vertex(ch);
                }
            }
        }
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String cur = words[i];
            if (prev.length() > cur.length() && prev.startsWith(cur)) {
                return "";
            }
            updateGraph(graph, prev, cur);
        }

        Queue<Vertex> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        for (Vertex v : graph) {
            if (v != null && v.indegree == 0) {
                queue.add(v);
            }
        }
        while (!queue.isEmpty()) {
            Vertex cur = queue.poll();
            res.append(cur.aChar);
            for (Vertex next : cur.nexts) {
                next.indegree--;
                if (next.indegree == 0) {
                    queue.add(next);
                }
            }
        }

        int amount = 0;
        for (Vertex v : graph) {
            if (v != null) {
                amount++;
            }
        }

        return res.length() != amount ? "" : res.toString();
    }

    private void updateGraph(Vertex[] graph, String prev, String cur) {

        int len = Math.min(prev.length(), cur.length());
        for (int i = 0; i < len; i++) {
            if (prev.charAt(i) != cur.charAt(i)) {
                graph[prev.charAt(i) - 'a'].nexts.add(graph[cur.charAt(i) - 'a']);
                graph[cur.charAt(i) - 'a'].indegree++;
                break;
            }
        }
    }

    public static void main(String[] args) {
        LC_269 lc_269 = new LC_269();
        String[] words = {"ac","ab","zc","zb"};
        System.out.println(lc_269.alienOrder(words));
    }
}
