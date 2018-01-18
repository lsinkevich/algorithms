package Graphs;

import java.util.ArrayList;
import java.util.List;

class Graph {
    int vertex;
    List<List<Integer>> adj;

    public Graph(int vertex) {
        this.vertex = vertex;
        adj = new ArrayList<List<Integer>>();

        for (int i = 0; i < vertex; i++)
            adj.add(new ArrayList<Integer>());
    }
}

class Eulerian {

    public void depthFirstSearch(Graph g, int val, boolean[] visited) {
        visited[val] = true;
        List<Integer> adjustment = g.adj.get(val);

        for (Integer i : adjustment) {
            if (!visited[i])
                depthFirstSearch(g, i, visited);
        }
    }

    public boolean isConnected(Graph g) {
        boolean[] visited = new boolean[g.vertex];
        int i;

        for (i = 0; i < g.vertex; i++) {
            List<Integer> adj = g.adj.get(i);

            if (adj != null && adj.size() != 0)
                break;
        }

        if (i == g.vertex)
            return true;

        depthFirstSearch(g, i, visited);

        for (i = 0; i < g.vertex; i++) {
            if (!visited[i] && g.adj.get(i).size() > 0)
                return false;
        }

        return true;
    }

    public int isEulerian(Graph g) {
        int i = 0;

        if (!isConnected(g))
            return 0;

        for (int j = 0; j < g.vertex; j++) {
            if (g.adj.get(j).size() % 2 == 1)
                i++;
        }

        if (i > 2)
            return 0;

        if (i > 0)
            return 1;

        return 2;
    }
}

public class EulerianPath {

    public static void main(String[] args) {
        Eulerian e = new Eulerian();

        Graph g = new Graph(5);
        g.adj.get(1).add(0);
        g.adj.get(0).add(1);
        g.adj.get(0).add(2);
        g.adj.get(2).add(0);
        g.adj.get(1).add(2);
        g.adj.get(2).add(1);

        int result = e.isEulerian(g);

        if (result == 0)
            System.out.println("Graph has not an euler path");

        else if (result == 1)
            System.out.println("Graph has an euler path");

        else
            System.out.println("Graph has an euler path");
    }


}
