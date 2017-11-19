package Sort;
import java.util.Arrays;

public class MergeSort
{
    private static void exchange(int[] data, int[] left, int[] right)
    {
        int l = 0;
        int r = 0;
        int index = 0;
        while (l < left.length && r < right.length)
        {
            if (left[l] <= right[r])
            {
                data[index++] = left[l++];
            }
            else
            {
                data[index++] = right[r++];
            }
        }

        while (l < left.length)
        {
            data[index++] = left[l++];
        }

        while (r < right.length)
        {
            data[index++] = right[r++];
        }
    }

    public static void sort(int[] data)
    {
        if (data.length < 2)
        {
            return;
        }

        int mid = (data.length + 1) / 2;
        int left[] = Arrays.copyOfRange(data, 0, mid);
        int right[] = Arrays.copyOfRange(data, mid, data.length);
        sort(left);
        sort(right);
        exchange(data, left, right);
    }

    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, 15, 12, -10, 13, -9};
        sort(arr);
        String comma = "";
        for (int i = 0; i < arr.length; i++)
        {
            int data = arr[i];
            System.out.print(comma + data);
            comma = ",";
        }
    }
}
