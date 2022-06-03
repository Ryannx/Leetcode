package LC_269.dfs;

import java.util.*;

public class LC_269 {
    private static class Node {
        private char ch;
        private List<Node> nexts;
        private int status; // new -1; visiting 0; visited 1

        public Node(char ch) {
            this.ch = ch;
            this.nexts = new ArrayList<>();
            this.status = -1;
        }
    }

    public String alienOrder(String[] words) {

        if (words == null) {
            return "";
        }

        // build graph
        Node[] graph = buildGraph(words);
        if (graph == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        LinkedList<Character> path = new LinkedList<>();
        for (Node node : graph) {
            if (node == null || node.status == 1) continue;
            if (dfs(node, path)) {
                return "";
            }

        }
        for (char ch : path) {
            res.append(ch);
        }
        return res.toString();
    }

    private Node[] buildGraph(String[] words) {
        Node[] graph = new Node[26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (graph[word.charAt(i) - 'a'] == null) {
                    graph[word.charAt(i) - 'a'] = new Node(word.charAt(i));
                }
            }
        }

        for (int i = 1; i < words.length; i++) {
            String str1 = words[i - 1];
            String str2 = words[i];
            if (str1.length() > str2.length() && str1.startsWith(str2)) {
                return null;
            }
            int minLen = Math.min(str1.length(), str2.length());
            int pivot = 0;
            while (pivot < minLen && str1.charAt(pivot) == str2.charAt(pivot)) {
                pivot++;
            }
            if (pivot < minLen) {
                graph[str1.charAt(pivot) - 'a'].nexts.add(graph[str2.charAt(pivot) - 'a']);
            }
        }
        return graph;
    }

    // new -1; visiting 0; visited 1
    private boolean dfs(Node node, LinkedList<Character> path) {

        if (node.status == 1) {
            return false;
        }
        if (node.status == 0) {
            return true;
        }

        List<Node> nexts = node.nexts;
        node.status = 0;
        for (Node next : nexts) {
            if (dfs(next, path)) {
                return true;
            }
        }
        node.status = 1;

        path.addFirst(node.ch);
        return false;
    }
}
