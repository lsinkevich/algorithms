package Math;

public class Fibonacci {

    public static long[][] increase(long data1[][], long data2[][]) {
        long[][] data = new long[2][2];
        data[0][0] = data1[0][0] * data2[0][0] + data1[0][1] * data2[1][0];
        data[0][1] = data1[0][0] * data2[0][1] + data1[0][1] * data2[1][1];
        data[1][0] = data1[1][0] * data2[0][0] + data1[1][1] * data2[1][0];
        data[1][1] = data1[1][0] * data2[0][1] + data1[1][1] * data2[1][1];
        return data;
    }

    public static long[][] preparation(long data[][], int n) {
        if (n == 1)
            return data;
        long pr_data[][] = preparation(data, n / 2);

        if (n % 2 == 0)
            return increase(pr_data, pr_data);
        else
            return increase(data, increase(pr_data, pr_data));
    }

    public static long fib(int fdata) {
        long[][] ldata = {{1, 1}, {1, 0}};
        long data[][] = preparation(ldata, fdata);
        return data[0][1];
    }

    public static void main(String[] args) {
        System.out.println(fib(1));
        System.out.println(fib(10));
    }
}
