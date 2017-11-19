package Math;
import java.math.BigInteger;
import java.util.Random;

public class KaratsubaMultiplication {

    private static final int clip = 192;

    public static BigInteger multiplication(final BigInteger data1, final BigInteger data2) {

        int count = Math.max(data1.bitLength(), data2.bitLength());
        if (count <= clip)
            return data1.multiply(data2);
        count = (count / 2) + (count % 2);

        BigInteger v1 = data1.shiftRight(count);
        BigInteger v2 = data1.subtract(v1.shiftLeft(count));
        BigInteger v3 = data2.shiftRight(count);
        BigInteger v4 = data2.subtract(v3.shiftLeft(count));

        BigInteger v13 = multiplication(v2, v4);
        BigInteger v24 = multiplication(v1, v3);
        BigInteger v1234 = multiplication(v2.add(v1), v4.add(v3));

        return v13.add(v1234.subtract(v13).subtract(v24).shiftLeft(count)).add(v24.shiftLeft(2 * count));
    }

    public static void main(final String[] args) {
        int count = 1000;
        Random random = new Random();
        BigInteger v1 = new BigInteger(count, random);
        BigInteger v2 = new BigInteger(count, random);
        BigInteger v3 = multiplication(v1, v2);
        BigInteger v4 = v1.multiply(v2);

        System.out.println((v3.equals(v4)));
    }
}
