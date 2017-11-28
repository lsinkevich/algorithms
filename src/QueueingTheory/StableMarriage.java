package QueueingTheory;
import java.util.Arrays;

public class StableMarriage {

    public static void stableMarriage(int rating[][]) {
        int woman;
        int man1 = 0;
        int man2 = 0;
        int count = rating.length/2;
        int count2 = count;

        int partner[] = new int[count];
        Arrays.fill(partner, -1);

        boolean spare[] = new boolean[count];
        Arrays.fill(spare, false);

        while (count2 > 0 && man1 < count) {
            for (int i = 0; i < count && spare[man1] == false; i++) {
                woman = rating[man1][i];
                if (partner[woman - count] == -1) {
                    count2--;
                    spare[man1] = true;
                    partner[woman - count] = man1;
                }
                else {
                    man2 = partner[woman - count];
                    if (!rating(rating, woman, man1, man2)) {
                        spare[man1] = true;
                        spare[man2] = false;
                        partner[woman - count] = man2;
                    }
                }
            }
            man1++;
        }
        System.out.println("woman   man");
        for (int i = 0; i < count; i++)
            System.out.println(" " + (i + count) + "\t" + partner[i]);
    }

    public static boolean rating(int rating[][], int woman, int man1, int man2) {
        int count = rating.length / 2;
        for (int i = 0; i < count; i++) {
            if (rating[woman][i] == man1)
                return false;
            if (rating[woman][i] == man2)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int rating[][] = { {2, 3}, {3, 2}, {0, 1}, {0, 1} };
        new StableMarriage().stableMarriage(rating);
    }
}
