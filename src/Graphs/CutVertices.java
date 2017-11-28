package Graphs;
import java.util.List;
import java.util.ArrayList;

public class CutVertices {

    int vertice;
    static int time = 0;
    List<Integer> adjustment[];

    public CutVertices(int data) {
        this.vertice = data;
        adjustment = new List[data];
        for (int i = 0; i < data; i++) {
            adjustment[i] = new ArrayList<Integer>();
        }
    }

    public void depthFirstTraversal(int vertice, Integer parent_vertice[], boolean visited[], boolean articulation_point[], int discovery_time[], int low_vertice[]) {
        List<Integer> adjList = adjustment[vertice];
        discovery_time[vertice] = low_vertice[vertice] = ++time;

        int children = 0;
        visited[vertice] = true;

        for (Integer v : adjList) {
            if (!visited[v]) {
                parent_vertice[v] = vertice;
                children++;
                depthFirstTraversal(v, parent_vertice, visited, articulation_point, discovery_time, low_vertice);
                low_vertice[vertice] = Math.min(low_vertice[vertice], low_vertice[v]);
                if (parent_vertice[vertice] != null && low_vertice[v] >= discovery_time[vertice])
                    articulation_point[vertice] = true;
                if (parent_vertice[vertice] == null && children > 1)
                    articulation_point[vertice] = true;

            }
            else if (v != parent_vertice[vertice])
                low_vertice[vertice] = Math.min(low_vertice[vertice], discovery_time[v]);
        }
    }

    public static void main(String[] args) {
        CutVertices g1= new CutVertices(4);
        Integer[] parent_vertice = new Integer[g1.vertice];
        boolean[] visited = new boolean[g1.vertice];
        boolean [] articulation_point = new boolean[g1.vertice];
        int[] discovery_time = new int[g1.vertice];
        int[] low_vertice = new int[g1.vertice];

        g1.adjustment[1].add(0);
        g1.adjustment[0].add(1);
        g1.adjustment[0].add(2);
        g1.adjustment[2].add(0);
        g1.adjustment[2].add(1);
        g1.adjustment[1].add(2);
        g1.adjustment[2].add(3);
        g1.adjustment[3].add(2);

        for (int i = 0; i < g1.vertice; i++)
        {
            parent_vertice[i] = null;
            visited[i] = false;
            articulation_point[i] = false;
        }

        for (int i = 0; i < g1.vertice; i++)
            if (!visited[i])
                g1.depthFirstTraversal(0, parent_vertice, visited, articulation_point, discovery_time, low_vertice);

        System.out.printf("articulation points \n");
        for (int i = 0; i < g1.vertice; i++)
            if (articulation_point[i] == true)
                System.out.printf("%d ", i);
    }
}
