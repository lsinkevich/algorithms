package Graphs;
import java.util.LinkedList;
import java.util.ArrayList;

public class BreadthFirstSearch {

    public static boolean breadthFirstSearch(final int data, final int finish, final ArrayList<ArrayList<Integer>> graph) {
        if (data == finish)
            return true;

        LinkedList<Integer> q = new LinkedList<Integer>();
        boolean visit[] = new boolean[graph.size()];
        visit[data] = true;
        q.add(data);

        while (!q.isEmpty()) {
            int k = q.poll();

            for (int neighbor : graph.get(k)) {
                if (neighbor == finish)
                    return true;

                if (!visit[neighbor]) {
                    visit[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        return false;
    }

    public static void main(final String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        graph.add(0, new ArrayList<Integer>());
        graph.add(1, new ArrayList<Integer>());
        graph.add(2, new ArrayList<Integer>());
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(2);

        System.out.println(breadthFirstSearch(1, 2, graph));
    }
}
