package LC_207.bfs;

import java.util.*;

public class LC_207 {

    private static class Vertex {
        private int val;
        private int indegree;
        private List<Vertex> nexts;
        public Vertex(int val) {
            this.val = val;
            this.indegree = 0;
            this.nexts = new ArrayList<>();
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.val);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Vertex)) {
                return false;
            }
            Vertex another = (Vertex) obj;
            return this.val == another.val;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        // build graph
        Vertex[] graph = new Vertex[numCourses];
        int amountOfCourses = 0;
        for (int[] p : prerequisites) {
            if (graph[p[0]] == null) {
                graph[p[0]] = new Vertex(p[0]);
                amountOfCourses++;
            }
            if (graph[p[1]] == null) {
                graph[p[1]] = new Vertex(p[1]);
                amountOfCourses++;
            }
            graph[p[0]].indegree++;
            graph[p[1]].nexts.add(graph[p[0]]);
        }

        // bfs
        int count = 0;
        Queue<Vertex> queue = new LinkedList<>();
        for (Vertex v : graph) {
            if (v != null && v.indegree == 0) {
                queue.add(v);
            }
        }
        while (!queue.isEmpty()) {
            Vertex cur = queue.poll();
            count++;
            for (Vertex next : cur.nexts) {
                next.indegree--;
                if (next.indegree == 0) {
                    queue.add(next);
                }
            }
        }
        return amountOfCourses == count;
    }
}
