package Graphs;

public class IsTheSameBinarySearchTree {

    private static boolean isTheSame(int bst1[], int bst2[], int index1, int index2, int min, int max) {
        int i;
        int j;
        int bstLength = bst1.length;

        for (i = index1; i < bstLength; i++)
            if (bst1[i] > min && bst1[i] < max)
                break;

        for (j = index2; j < bstLength; j++)
            if (bst2[j] > min && bst2[j] < max)
                break;

        if (i == bstLength && j == bstLength)
            return true;

        if (((i == bstLength) ^ (j == bstLength)) || bst1[i] != bst2[j])
            return false;

        return isTheSame(bst1, bst2, i + 1, j + 1, bst1[i], max) && isTheSame(bst1, bst2,i + 1, j + 1, min, bst1[i]);
    }

    static boolean isSameBST(int[] bst1, int[] bst2) {
        return isTheSame(bst1, bst2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        int bst1[] = { 1, 4, 2, 6 };
        int bst2[] = { 1, 5, 3, 6 };
        System.out.printf("%s\n", isSameBST(bst1, bst2) ? "BSTs are same" : "BSTs not same");
    }
}
