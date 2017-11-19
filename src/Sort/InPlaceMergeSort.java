package Sort;

public class InPlaceMergeSort {

    private static void exchange(final Comparable[] data, final int first, final int last) {
        Comparable swap_data;

        if (first >= last)
            return;

        int mid = (first + last) / 2;
        int f = first;
        int l = mid + 1;

        exchange(data, f, mid);
        exchange(data, l, last);

        if (data[mid].compareTo(data[l]) <= 0)
            return;

        while (f <= mid && l <= last) {
            if (data[f].compareTo(data[l]) <= 0)
                f++;
            else {
                swap_data = data[l];
                System.arraycopy(data, f, data, f + 1, l - f);
                data[f] = swap_data;
                mid++;
                f++;
                l++;
            }
        }
    }

    public static void sort(final Comparable[] data) {
        exchange(data, 0, data.length - 1);
    }

    public static void main(final String[] args) {
        Integer arr[] = {1, 2, 3, 15, 12, -10, 13, -9};
        sort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.printf("%d ", arr[i]);
        System.out.println();
    }
}
