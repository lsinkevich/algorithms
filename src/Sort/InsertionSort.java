package Sort;

public class InsertionSort
{

    public static void sort(int[] data)
    {
        for (int i = 1; i < data.length; i++)
        {
            int k = data[i];
            for (int j = 0; j < i; j++)
            {
                if (k < data[j])
                {
                    System.arraycopy(data, j, data, j + 1, i - j);
                    data[j] = k;
                    break;
                }
            }
        }
    }

    public static void exchange(int[] data, int i, int j)
    {
        int swap_data = data[i];
        data[i] = data[j];
        data[j] = swap_data;
    }

    public static void insertSort(int[] d, int left, int right)
    {
        int rod = d[(left + right) / 2];
        int l = left;
        int r = right;
        while(l <= r)
        {
            while(rod > d[l])
            {
                l++;
            }
            while(rod < d[r])
            {
                r--;
            }
            if(l <= r)
            {
                exchange(d, l++, r--);
            }
        }

        if(left < r)
        {
            insertSort(d, left, r);
        }

        if(l < right)
        {
            insertSort(d, l, right);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 15, 12, -10, 13, -9};
        insertSort(arr, 0, arr.length - 1);
        String comma = "";
        for (int i = 0; i < arr.length; i++)
        {
            int data = arr[i];
            System.out.print(comma + data);
            comma = ",";
        }
    }
}
