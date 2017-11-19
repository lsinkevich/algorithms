package Sort;

public class SelectionSort
{
    private static void exchange(int[] data, int i, int min)
    {
        int swap_data = data[i];
        data[i] = data[min];
        data[min] = swap_data;
    }

    public static void sort (int data[])
    {
        for(int i = 0; i < data.length - 1; i++)
        {
            int min = i;

            for(int j = i + 1; j < data.length; j++)
            {
                if(data[min] > data[j])
                {
                    min = j;
                }
            }

            if(min != i)
            {
                exchange(data, i, min);
            }
        }
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
