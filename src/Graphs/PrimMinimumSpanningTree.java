package Graphs;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimMinimumSpanningTree {

    public void mst(final List<ArrayList<Integer>> graph, final int data[][]) {
        int size = graph.size();
        int parent[] = new int[size];
        final Integer course[] = new Integer[size];

        PriorityQueue<Integer> min = new PriorityQueue<Integer>(graph.size(),
                new Comparator<Integer>() {
                    public int compare(final Integer v1, final Integer v2) {
                        return course[v1].compareTo(course[v2]);
                    }
                });

        for (int i = 1; i < size; ++i) {
            course[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        course[0] = 0;

        for (int i = 0; i < size; i++)
            min.add(i);

        while (!min.isEmpty()) {
            int remove = min.remove();
            List<Integer> adjust = graph.get(remove);

            for (Integer adjustment : adjust) {
                if (min.contains(adjustment) && data[remove][adjustment] < course[adjustment]) {
                    course[adjustment] = data[remove][adjustment];
                    parent[adjustment] = remove;
                    min.remove(adjustment);
                    min.add(adjustment);
                }
            }
        }

        for (int i = 1; i < parent.length; ++i)
            System.out.printf("%d - %d\n", parent[i], i);
    }

    public void mst(final int graph[][]) {

        int length = graph.length;
        int parent[] = new int[length];
        int course[] = new int[length];
        boolean dataset[] = new boolean[length];

        for (int i = 0; i < length; i++) {
            course[i] = Integer.MAX_VALUE;
            dataset[i] = false;
        }

        course[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < length - 1; count++) {
            int max = Integer.MAX_VALUE;
            int index = 0;

            for (int i = 0; i < course.length; i++)
                if ((!dataset[i]) && course[i] < max) {
                    max = course[i];
                    index = i;
                }

            dataset[index] = true;

            for (int i = 0; i < length; i++)
                if (graph[index][i] > 0 && !dataset[i] && graph[index][i] < course[i]) {
                    parent[i] = index;
                    course[i] = graph[index][i];
                }
        }

        for (int i = 1; i < graph.length; i++)
            System.out.printf("%d - %d %d \n", parent[i], i, graph[i][parent[i]]);
    }


    public static void main(final String[] args) {
        int graph[][] = { {0, 1, 2}, {1, 2, 3}, {0, 1, 3} };
        PrimMinimumSpanningTree p = new PrimMinimumSpanningTree();
        p.mst(graph);

        Random random = new Random(System.currentTimeMillis());

        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        int[][] array = new int[10][10];

        for (int i = 0; i < 10; i++) {
            al.add(new ArrayList<Integer>());
            for (int j = 0; j < 10; j++) {
                if (i == j)
                    al.get(i).add(j, 0);
                else if (j < i)
                    al.get(i).add(j, al.get(j).get(i));
                else if (i == 0 && j == 9)
                    al.get(i).add(j, 1);
                else {
                    int val = (Math.abs(random.nextInt()) % 5) + 1;
                    al.get(i).add(j, val);
                    array[i][j] = val;
                }
            }
        }
        p.mst(al, array);
    }
}
