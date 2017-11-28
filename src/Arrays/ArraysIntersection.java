package Arrays;
import java.util.Arrays;

public class ArraysIntersection {

    public static int[] intersection(int arr1[], int arr2[]) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int[] intersection = new int[Math.max(arr1.length, arr2.length)];

        int i = 0;
        int j = 0;
        int index = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                intersection[index++] = arr1[i];
                i++;
                j++;
            }else if(arr1[i] < arr2[j]){
                i++;
            }else if(arr2[j] < arr1[i]){
                j++;
            }
        }
        for(int k = 0; k < index; k++){
            System.out.printf("%d ", intersection[k]);
        }
        return intersection;
    }

    public static void main(String[] args) {
        int arr1[] = {1,2,-2,15};
        int arr2[] = {0,2,6,12};
        intersection(arr1, arr2);
    }
}
