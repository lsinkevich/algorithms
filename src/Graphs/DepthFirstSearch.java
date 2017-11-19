package Graphs;
import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch {

    private static final int max_val = 100;

    static int k = 2;
    static int val[] = new int[max_val + 1];
    static int depth[] = new int[max_val + 1];
    static int graph[][] = new int[max_val + 1][max_val + 1];

    public static List<Integer> neighbor(final int data) {
        List<Integer> neighbor = new LinkedList<Integer>();

        for (int i = 0; i <= max_val; i++) {
            if (graph[data][i] != 0)
                neighbor.add(i);
        }
        return neighbor;
    }

    public static boolean depthFirstSearch(final int data1, final int data2) {
        val[data2] = data1;
        depth[data1] = data2;

        List<Integer> neig = neighbor(data1);

        for (Integer apex : neig) {
            if (depth[apex] == 0) {
                if (depthFirstSearch(apex, data2 + 1))
                    return true;
            }
            else if (data2 - depth[apex] >= k) {
                System.out.printf("%d\n", data2 - depth[apex] + 1);
                for (int j = depth[apex]; j <= data2; j++)
                    System.out.printf("%d ", val[j]);
                return true;
            }
        }
        return false;
    }

    public static void main(final String[] args) {
        graph[1][2] = 1;
        graph[1][3] = 1;
        graph[2][1] = 1;
        graph[2][3] = 1;
        graph[3][1] = 1;
        graph[3][2] = 1;

        depthFirstSearch(1, 1);
    }
}
