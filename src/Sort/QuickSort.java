package Sort;

public class QuickSort
{

    public static void exchange(int[] data, int i, int j)
    {
        int swap_data = data[i];
        data[i] = data[j];
        data[j] = swap_data;
    }

    public static void sort(int[] data, int first, int last)
    {
        if (first < last)
        {
            int middle = (first + last) / 2;
            int f = first;
            int s = first + 1;
            int l = last;
            exchange(data, f, middle);

            int rod = data[f];
            while (s < l)
            {
                while (data[s] < rod && s < last)
                    s++;

                while (data[l] > rod && l > first)
                    l--;

                if (s < l)
                {
                    exchange(data, s++, l--);
                }
                else
                {
                    s++;
                }
            }

            exchange(data, f, l);
            sort(data, first, l - 1);
            sort(data, l + 1, last);
        }
    }

    public static void sortOptimized(int[] data, int first, int last)
    {
        int f = first;
        int l = last;
        int mid = data[(first + last) / 2];

        while(f <= l)
        {
            while(data[f] < mid && f <= l)
            {
                f++;
            }
            while(data[l] > mid && f <= l)
            {
                l--;
            }
            if(f <= l)
            {
                exchange(data, f, l);
                f++;
                l--;
            }
            if(l > first)
            {
                sortOptimized(data, first, l);
            }
            if(f < last)
            {
                sortOptimized(data, f, last);
            }
        }
    }

    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, 15, 12, -10, 13, -9};
        sortOptimized(arr, 0, arr.length - 1);
        String comma = "";
        for (int i = 0; i < arr.length; i++) {
            int data = arr[i];
            System.out.print(comma + data);
            comma = ",";
        }
    }
}
