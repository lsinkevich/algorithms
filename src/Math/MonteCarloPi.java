package Math;
import java.util.Random;

public class MonteCarloPi {

    public static void main(String[] args) {
        Random r = new Random(System.currentTimeMillis());
        int count = 0;
        int iterations = 1000;

        for (int i = 0; i < iterations; i++) {
            double x = r.nextDouble();
            double y = r.nextDouble();
            double v = x * x + y * y;

            if (v <= 1.0)
                count++;
        }
        System.out.printf("%f\n%f\n", 4 * ((double) count / iterations), java.lang.Math.PI);
    }
}
