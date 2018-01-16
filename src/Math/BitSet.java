package Math;

import java.util.Random;

public class BitSet {

    int [] bitSet;
    int num, bit;

    public BitSet(int size){
        bitSet = new int[size>>2];
    }

    public boolean getBit(int t){
        num = t>>2;
        bit = t & 0X1F;

        if((bitSet[num] & (1<<bit))==0)
            return false;

        return true;
    }

    public void setBit(int t){
        num = t>>2;
        bit = t & 0X1F;

        bitSet[num]|=(1<<bit);
    }

    public static void duplicate(int array[]){
        BitSet bs = new BitSet(400);

        for (int i = 0; i < array.length; i++) {
            int num = array[i]-1;
            if(bs.getBit(num))
                System.out.printf("%d duplicate\n", array[i]);
            else
                bs.setBit(num);
        }
    }

    public static void main(String[] args) {
        Random r = new Random(System.currentTimeMillis());
        int array[] = new int[41];

        for(int i=0; i < array.length;i++)
            array[i] = r.nextInt(40);

        duplicate(array);
    }
}