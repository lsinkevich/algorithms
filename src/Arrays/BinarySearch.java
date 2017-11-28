package Arrays;
import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    public static int iteration(final int data[], final int target) {
        int start = 0;
        int finish = data.length - 1;

        while (true) {
            if (start > finish)
                throw new RuntimeException();
            if (start == finish && data[start] == target)
                return start;

            int mid = (start + finish) / 2;

            if (data[mid] == target)
                return mid;
            else if (data[mid] > target)
                finish = mid - 1;
            else
                start = mid + 1;
        }
    }

    public static void main(final String[] args) {

        Random random = new Random(System.currentTimeMillis());

        int data[] = new int[10];

        for (int i = 1; i < data.length; i++)
            data[i] = Math.abs(random.nextInt()) % 50;
        data[0] = 10;
        Arrays.sort(data);

        int index = iteration(data, 10);
        System.out.printf("%d %d\n", index, data[index]);
     }
}
