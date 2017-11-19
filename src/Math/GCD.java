package Math;
import java.math.BigInteger;

public class GCD {

    public static int gcd(final int data1, final int data2) {
        if (data1 == data2)
            return data1;
        if (data1 == 0)
            return data2;
        if (data2 == 0)
            return data1;

        if ((~data1 & 1) > 0) {
            if ((data2 & 1) > 0)
                return gcd(data1 >> 1, data2);
            return gcd(data1 >> 1, data2 >> 1) << 1;
        }

        if ((~data2 & 1) > 0)
            return gcd(data1, data2 >> 1);
        if (data1 > data2)
            return gcd((data1 - data2) >> 1, data2);
        else
            return gcd(data1, (data2 - data1) >> 1);
    }

    public static void main(final String[] args) {
        System.out.println(gcd(12, 5));
        System.out.println(gcd(12, 6));
    }
}
