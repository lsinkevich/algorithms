package Graphs;
import java.util.List;
import java.util.ArrayList;

public class BiconnectedGraph {

    int vertex;
    List<Integer> adjacent[];

    boolean[] visited;
    static int period = 0;
    Integer[] parent_vertices;
    int[] low_vertices;
    int[] discovery_times;

    public BiconnectedGraph(int vertex) {
        this.vertex = vertex;
        adjacent = new List[vertex];
        for (int i = 0; i < vertex; i++)
            adjacent[i] = new ArrayList<Integer>();
        visited = new boolean[vertex];
        discovery_times = new int[vertex];
        low_vertices = new int[vertex];
        parent_vertices = new Integer[vertex];
    }

    public boolean biconnectivity() {
        if (depthFirstSearch(0, visited, parent_vertices, low_vertices, discovery_times))
            return false;
        for (int i = 0; i < vertex; i++)
            if (!visited[i])
                return false;
        return true;
    }

    public boolean depthFirstSearch(int v, boolean visited[], Integer parent_vertices[], int low_vertices[], int discovery_times[]) {
        visited[v] = true;
        List<Integer> adjacentL = adjacent[v];
        discovery_times[v] = low_vertices[v] = ++period;
        int children_vertice = 0;

        for (Integer vertice : adjacentL) {
            if (!visited[vertice]) {
                children_vertice++;
                parent_vertices[vertice] = v;

                if (depthFirstSearch(vertice, visited, parent_vertices, low_vertices, discovery_times))
                    return true;
                low_vertices[v] = Math.min(low_vertices[v], low_vertices[vertice]);

                if (parent_vertices[v] == null && children_vertice > 1)
                    return true;
                if (parent_vertices[v] != null && low_vertices[vertice] >= discovery_times[v])
                    return true;
            }
            else if (vertice != parent_vertices[v])
                low_vertices[v] = Math.min(low_vertices[v], discovery_times[vertice]);
        }
        return false;
    }

    public static void main(String[] args) {
        BiconnectedGraph graph = new BiconnectedGraph(5);
        graph.adjacent[0].add(1);
        graph.adjacent[1].add(0);
        graph.adjacent[1].add(2);
        graph.adjacent[2].add(1);
        graph.adjacent[0].add(3);
        graph.adjacent[3].add(0);
        graph.adjacent[3].add(4);
        graph.adjacent[4].add(3);
        graph.adjacent[2].add(4);
        graph.adjacent[4].add(2);
        System.out.println(graph.biconnectivity());
    }
}
