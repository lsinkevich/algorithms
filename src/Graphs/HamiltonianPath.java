package Graphs;
import java.util.Arrays;

public class HamiltonianPath {

    public static boolean hamiltonianPath(int graph[][], int path[], int position) {
        int length = graph.length;
        if (position == length) {
            if (graph[path[position - 1]][path[0]] == 1)
                return true;
            else
                return false;
        }
        for (int i = 1; i < length; i++) {
            if (check(graph, path, i, position)) {
                path[position] = i;
                if (hamiltonianPath(graph, path, position + 1) == true)
                    return true;
                path[position] = -1;
            }
        }
        return false;
    }

    public static boolean hamiltonianPath(int graph[][]) {
        int length = graph.length;
        int path[] = new int[length];
        Arrays.fill(path, -1);
        path[0] = 0;

        if (hamiltonianPath(graph, path, 1) == false) {
            System.out.println("no solution");
            return false;
        }

        for (int i = 0; i < path.length; i++)
            System.out.printf(" %d ", path[i]);
        System.out.printf(" %d ", path[0]);
        return true;
    }

    public static boolean check(int graph[][], int path[], int vertex, int position) {
        if (graph[path[position - 1]][vertex] == 0)
            return false;
        for (int i = 0; i < position; i++)
            if (path[i] == vertex)
                return false;
        return true;
    }

    public static void main(String[] args) {
        int graph[][] = { {1, 1, 0, 1}, {1, 1, 1, 1}, {0, 1, 1, 0}, {1, 1, 1, 1} };
        hamiltonianPath(graph);
    }
}
