package Math.Array;

public class PeakElement {

    public static int peakElement(int data[], int start, int finish) {
        int mid = (start + finish) / 2;

        if (mid == 0 && data[mid] >= data[mid + 1])
            return mid;

        if (mid == data.length - 1 && data[mid] >= data[mid - 1])
            return mid;

        if (mid > 0 && (data[mid - 1] <= data[mid] && data[mid] >= data[mid + 1]))
            return mid;

        if (mid > 0 && data[mid - 1] > data[mid])
            return peakElement(data, start, mid - 1);

        return peakElement(data, mid + 1, finish);
    }

    public static void main(String[] args) {
        int data[] = { 1, 4, 8, 6, 2 };

        int index = peakElement(data, 0, data.length);
        System.out.printf("%d\n", data[index]);
    }
}
