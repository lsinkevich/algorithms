package Graphs;

public class MarkovChain {

    private static double[][] transition = { { 3, 1, 2 }, { 1, 2, 3 }, { 1, 2, 3 } };

    public static void main(String[] args) {

        int count = 3;
        int point = count - 1;

        int step = 0;
        double random = Math.random();
        double sum = 0;

        while (point > 0) {
            System.out.println(point);
            step++;

            for (int i = 0; i < count; i++) {
                sum += transition[point][i];
                if (random <= sum) {
                    point = i;
                    break;
                }
            }
        }
        System.out.println(step + " steps:");
    }
}
