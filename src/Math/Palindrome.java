package Math;

public class Palindrome {

    public static boolean isPal(int data){
        if(data < 0)
            data = -data;

        int cdata = data;
        int rdata = 0;

        while( data > 0){
            rdata = rdata * 10 + data % 10;
            data = data / 10;
        }
        
        return (cdata == rdata);
    }

    public static void main(String[] args) {
        System.out.println(isPal(0));
        System.out.println(isPal(123));
        System.out.println(isPal(-121));
    }
}
