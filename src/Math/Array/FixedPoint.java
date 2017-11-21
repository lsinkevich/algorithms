package Math.Array;

public class FixedPoint {
    public static int fixedPoint(int data[], int start_point, int finish_point) {
        if (finish_point < start_point)
            return -1;
        int mid_point = (start_point + finish_point) / 2;
        if (mid_point == data[mid_point])
            return mid_point;
        if (data[mid_point] > mid_point) {
            return fixedPoint(data, start_point, mid_point - 1);
        } else {
            return fixedPoint(data, mid_point + 1, finish_point);
        }

    }

    public static void main(String[] args) {

        int data[] = {-10, -4, -1, 0, 1, 2, 3, 10, 30, 100};
        System.out.printf("%d is fixed point", fixedPoint(data, 0, data.length-1));
    }
}
