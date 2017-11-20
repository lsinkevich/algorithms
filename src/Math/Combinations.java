package Math;
import java.util.Arrays;

public class Combinations {

    private static void combination(int[] data, int p, int pos, int[] combination, int x) {
        if (pos == p) {
            for (int i = 0; i < p; i++) {
                System.out.printf("%d ", combination[i]);
            }
            System.out.println();
            return;
        }

        if (x >= data.length)
            return;

        combination[pos] = data[x];
        combination(data, p, pos + 1, combination, x + 1);

        while (x < data.length - 1 && data[x] == data[x + 1])
            x++;

        combination(data, p, pos, combination, x + 1);
    }

    public static void main(String[] args) {
        int data[] = { 1, 2, 3 };
        int comb[] = new int[2];
        Arrays.sort(data);
        combination(data, 2, 0, comb, 0);
    }
}
