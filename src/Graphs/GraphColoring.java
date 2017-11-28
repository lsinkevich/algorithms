package Graphs;

public class GraphColoring {

    private static boolean coloring(int graph[][], int color_number, int color[], int vertex) {
        int length = graph.length;
        if (vertex == length)
            return true;

        for (int i = 1; i <= color_number; i++) {
            for (int j = 0; j < graph.length; j++)
                if (graph[vertex][j] != 0 && i == color[j])
                    break;
            else {
                color[vertex] = i;
                if (coloring(graph, color_number, color, vertex + 1) == true)
                    return true;
                color[vertex] = 0;
            }
        }
        return false;
    }

    public static boolean coloring(int graph[][], int color_number) {
        int length = graph.length;
        int[] color = new int[length];

        if (coloring(graph, color_number, color, 0) == false) {
            System.out.printf("no solution");
            return false;
        }

        for (int i = 0; i < color.length; i++)
            System.out.printf(" %d ", color[i]);
        return true;
    }

    public static void main(String[] args) {
        int graph[][] = { {1, 1, 1}, {0, 1, 0}, {1, 1, 1} };
        int color_number = 2;
        coloring(graph, color_number);
    }
}
