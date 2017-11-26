package Graphs;
import java.util.Queue;
import java.util.LinkedList;

public class BipartiteGraph {

    public static boolean isBipartiteGraph(int graph[][]) {
        int length = graph.length;
        int graph_color[] = new int[length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        for (int i = 0; i < graph_color.length; i++)
            graph_color[i] = -1;

        graph_color[0] = 1;

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int i = 0; i < length; i++) {
                if (graph[poll][i] > 0 && graph_color[i] == -1) {
                    graph_color[i] = 1 - graph_color[poll];
                    queue.add(i);
                }
                else if (graph[poll][i] > 0 && graph_color[i] == graph_color[poll])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int graph[][] = { {0, 1, 0}, {1, 0, 1},{0, 1, 0} };
        if(isBipartiteGraph(graph))
            System.out.println("bipartite graph");
        else
            System.out.println("not bipartite graph");
    }
}
