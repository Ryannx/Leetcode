package LC_207.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC_207 {

    private enum Status {
        INITIAL, VISITING, VISITED;
    }

    private static class Vertex {
        private int val;
        private List<Vertex> nexts;
        private Status status;
        public Vertex(int val) {
            this.val = val;
            this.nexts = new ArrayList<>();
            this.status = Status.INITIAL;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        // build graph
        Vertex[] graph = new Vertex[numCourses];
        for (int[] p : prerequisites) {
            if (graph[p[0]] == null) {
                graph[p[0]] = new Vertex(p[0]);
            }
            if (graph[p[1]] == null) {
                graph[p[1]] = new Vertex(p[1]);
            }
            graph[p[1]].nexts.add(graph[p[0]]);
        }

        // check cycle
        for (Vertex v : graph) {
            if (v != null &&  hasCycle(v)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(Vertex vertex) {

        if (vertex.status == Status.VISITED) {
            return false;
        }

        if (vertex.status == Status.VISITING) {
            return true;
        }

        vertex.status = Status.VISITING;
        for (Vertex next : vertex.nexts) {
            if (hasCycle(next)) {
                return true;
            }
        }
        vertex.status = Status.VISITED;
        return false;
    }
}
