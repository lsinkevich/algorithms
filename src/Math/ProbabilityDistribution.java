package Math;
import java.util.Random;

public class ProbabilityDistribution
{

    static int find(int data[], int r, int l, int v) {
        int mid;
        while (l < v) {
            mid = (l + v) >> 1;
            if (r > data[mid])
                l = mid + 1;
            else
                v = mid;
        }

        if (data[l] >= r)
            return l;

        return -1;
    }

    static int custom(int data1[], int data2[]) {
        int n = data1.length;
        Random rand = new Random(System.nanoTime());
        int an[] = new int[n];
        an[0] = data2[0];
        for (int i = 1; i < n; i++)
            an[i] = an[i - 1] + data2[i];
        int v = rand.nextInt(an[n - 1]) + 1;
        int ind = find(an, v, 0, n - 1);
        return data1[ind];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int frequency[] = { 10, 20, 30, 40 };
        for (int i = 0; i < 5; i++)
            System.out.printf("%d ", custom(arr, frequency));
        System.out.println();
    }
}
