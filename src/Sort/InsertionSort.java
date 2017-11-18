package Sort;

public class InsertionSort
{

    public static void exchange(int[] data, int i, int j)
    {
        int swap_data = data[i];
        data[i] = data[j];
        data[j] = swap_data;
    }

    public static void sort(int[] d, int left, int right)
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
            sort(d, left, r);
        }

        if(l < right)
        {
            sort(d, l, right);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 15, 12, -10, 13, -9};
        sort(arr, 0, arr.length - 1);
        String comma = "";
        for (int i = 0; i < arr.length; i++)
        {
            int data = arr[i];
            System.out.print(comma + data);
            comma = ",";
        }
    }
}
