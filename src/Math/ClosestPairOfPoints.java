package Math;
import java.util.AbstractList;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ClosestPairOfPoints {

    private static class Prepare implements Comparable {
        public int x;
        public int y;
        public int xval;
        public int yval;

        public Prepare(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public int quadrante() {
            if (xval >= 0 && yval >= 0)
                return 1;
            if (xval < 0 && yval >= 0)
                return 2;
            if (xval < 0 && yval < 0)
                return 3;
            return 4;
        }

        public int compareTo(final Object o) {
            Prepare p = (Prepare) o;
            if (this.quadrante() < p.quadrante())
                return -1;
            if (this.quadrante() > p.quadrante())
                return 1;
            if (this.xval == p.xval && this.yval == p.yval)
                return 0;
            if (this.xval == 0 && p.yval == 0) {
                if (this.xval > p.xval)
                    return 1;
                return -1;
            }
            if (this.yval * p.xval > this.xval * p.yval)
                return 1;
            return -1;
        }
    }

    public List<Integer> getList(final int data[]) {
        return new AbstractList<Integer>() {
            public Integer get(final int i) {
                return data[i];
            }
            public int size() {
                return data.length;
            }
        };
    }

    public static double distance(final Prepare val1, final Prepare val2) {
        double xdistance = val1.x - val2.x;
        double ydistance = val1.y - val2.y;
        return xdistance * xdistance + ydistance * ydistance;
    }

    public static double closestPair(final Prepare[] data) {
        double min = Double.MAX_VALUE;

        for (int i = 0; i < data.length; i++) {
            Prepare val1 = data[i];

            for (int j = i + 1; j < data.length; j++) {
                Prepare val2 = data[j];

                double dist = distance(val1, val2);
                if (dist < min)
                    min = dist;
            }
        }
        return Math.sqrt(min);
    }

    public static void main(final String[] args) {
        Prepare points[] = new Prepare[5];
        Random rand = new Random(System.currentTimeMillis());

        for (int i = 0; i < 5; i++) {
            Prepare p = new Prepare(Math.abs(rand.nextInt()) % 20, Math.abs(rand.nextInt()) % 20);
            points[i] = p;
        }

        System.out.printf("%f\n", closestPair(points));
    }
}
