package Math;

public class ActivitySelection {

    public static void activity(int data1[], int data2[]) {
        int n = data1.length;
        int i = 0;
        int j;

        System.out.printf("%d ", i);
        for (j = 1; j < n; j++) {
            if (data1[j] >= data2[i]) {
                System.out.printf("%d ", j);
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        int data1[] = { 1, 2, -1, 4 };
        int data2[] = { -1, -2, -1, 4 };
        activity(data1, data2);
    }
}
