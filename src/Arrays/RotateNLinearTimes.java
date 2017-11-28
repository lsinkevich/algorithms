package Arrays;

public class RotateNLinearTimes {

    private static void reverse(int[] data, int d1, int d2) {
        while (d1 < d2) {
            int temp = data[d1];
            data[d1] = data[d2];
            data[d2] = temp;
            d1++;
            d2--;
        }
    }

    private static void rotate(int[] data, int n) {
        reverse(data, 0, data.length - 1);
        reverse(data, 0, data.length - n - 1);
        reverse(data, data.length - n, data.length - 1);
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4 };
        rotate(array, 2);
        for (int i : array)
            System.out.print(i + ",");
        System.out.println();

    }
}
