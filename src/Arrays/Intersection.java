package Arrays;
import java.util.Arrays;

public class Intersection {

    public static int[] intersection(int arr1[], int arr2[]) {
        int index = 0;
        int i = 0;
        int j = 0;

        int[] intersection = new int[Math.max(arr1.length, arr2.length)];
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                intersection[index++] = arr1[i];
                i++;
                j++;
            }
            else if(arr1[i] < arr2[j])
                i++;
            else if(arr2[j] < arr1[i])
                j++;
        }

        for(int k = 0; k < index; k++)
            System.out.printf("%d ", intersection[k]);

        return intersection;
    }

    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5};
        int arr2[] = {-1,0,1,2,7};
        intersection(arr1, arr2);
    }
}
