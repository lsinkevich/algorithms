package Graphs;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Dijkstra {

    public static Integer[] dijkstra(int data, ArrayList<ArrayList<Integer>> d) {

        final Integer dist[] = new Integer[d.size()];
        Integer prev[] = new Integer[d.size()];

        PriorityQueue<Integer> mass = new PriorityQueue<>(d.size(),
                new Comparator<Integer>() {
                    public int compare(Integer v1, Integer v2) {
                        return dist[v1].compareTo(dist[v2]);
                    }
                });

        for (int v = 0; v < d.size(); v++) {
            dist[v] = Integer.MAX_VALUE;
            prev[v] = null;
            mass.add(v);
        }

        mass.remove(data);
        dist[data] = 0;
        mass.add(data);

        while (!mass.isEmpty()) {
            int u = mass.remove();
            if (dist[u] == Integer.MAX_VALUE) {
                break;
            }

            ArrayList<Integer> adjust = d.get(u);
            for(int v=0; v < adjust.size(); v++){
                Integer alternative = dist[u] + d.get(u).get(v);
                if (alternative < dist[v]) {
                    dist[v] = alternative;
                    prev[v] = u;
                    mass.remove(v);
                    mass.add(v);
                }
            }

        }

        for (int i = 0; i < prev.length; i++) {
            Integer integer = prev[i];
            System.out.printf("previous %d = %d\n", i, integer);
        }
        return dist;
    }

    public static void main(String[] args) {
        Random rand = new Random(System.currentTimeMillis());
        ArrayList<ArrayList<Integer>> d = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < 10; i++) {
            d.add( new ArrayList<Integer>());
            for (int j = 0; j < 10; j++) {
                if(i == 0 && j ==9)
                    d.get(i).add(j,1);
                else if(i == j)
                    d.get(i).add(j,0);
                else if(j < i)
                    d.get(i).add(j, d.get(j).get(i));
                else
                    d.get(i).add(j,(Math.abs(rand.nextInt()) % 5) + 1);
            }
        }

        for(int i = 0 ; i < d.size(); i++){
            ArrayList<Integer> v = d.get(i);
            for(int j=0; j < v.size(); j++)
                System.out.printf("%d %d %d \n", i, j, v.get(j));
        }
        System.out.println();

        Integer[] dijkstra = dijkstra(0, d);
        for (int i = 0; i < dijkstra.length; i++)
            System.out.printf("distancia 0 - %d = %d \n", i, dijkstra[i]);
    }
}
