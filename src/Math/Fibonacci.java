package Math;

public class Fibonacci
{
    public static int[][] increase(int data1[][], int data2[][], int n, int m)
    {
        int data[][] = new int[n][m];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                int sum = 0;
                for (int k = 0; k < data2.length; k++)
                {
                    sum += data1[i][k] * data2[k][j];
                }
                data[i][j] = sum;
            }
        }
        return data;
    }

    public static long[][] increase2( long data1[][], long data2[][])
    {
        long [][] data = new long[2][2];
        data[0][0] = data1[0][0] * data2[0][0] + data1[0][1] * data2[1][0];
        data[0][1] = data1[0][0] * data2[0][1] + data1[0][1] * data2[1][1];
        data[1][0] = data1[1][0] * data2[0][0] + data1[1][1] * data2[1][0];
        data[1][1] = data1[1][0] * data2[0][1] + data1[1][1] * data2[1][1];
        return data;
    }

    public static long[][] preparation(long data[][], int n)
    {
        if (n == 1)
            return data;
        long pr_data[][] = preparation(data, n / 2);

        if (n % 2 == 0)
        {
            return increase2(pr_data, pr_data);
        }
        else
        {
            return increase2(data, increase2(pr_data, pr_data));
        }
    }

    public static long fib(int fdata)
    {
        long[][] ldata = { { 1, 1 }, { 1, 0 } };
        long data[][] = preparation(ldata, fdata);
        return data[0][1];
    }

    public static void main(String[] args)
    {
        System.out.println(fib(1));
        System.out.println(fib(10));
    }
}
