import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void sort(int[] A) {
        int length = A.length;
        if (length > 1) {

            // split the array in half
            int middle = length / 2; // determine the middle
            int[] aLeft = Arrays.copyOfRange(A, 0, middle); // array of left side
            int[] aRight = Arrays.copyOfRange(A, middle, length); // array of right side

            sort(aLeft); // recursive call: sort left half of array
            sort(aRight); // recursive call: sort right half of array

            // merge
            int lengthLeft = aLeft.length;
            int lengthRight = aRight.length;

            int indexLeft = 0; // for iterating over the left array
            int indexRight = 0; // for iterating over the right array
            int indexResult = 0; // for iterating over the merged array

            while (indexLeft < lengthLeft && indexRight < lengthRight) {
                if (aLeft[indexLeft] <= aRight[indexRight]) {
                    A[indexResult] = aLeft[indexLeft++];
                } else {
                    A[indexResult] = aRight[indexRight++];
                }
                indexResult++;
            }

            while (indexLeft < lengthLeft) {
                A[indexResult++] = aLeft[indexLeft++];
            }
            while (indexRight < lengthRight) {
                A[indexResult++] = aRight[indexRight++];
            }

        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> liste = new ArrayList<Integer>();

        // read file
        String path = args[0];
        Scanner read = new Scanner(new File(path));
        while (read.hasNextLine()) {
            liste.add(Integer.valueOf(read.nextLine()));
        }
        read.close();

        // copy arraylist into standard java array for mergesort
        int[] arr = new int[liste.size()];

        for (int i = 0; i < liste.size(); i++) {
            arr[i] = liste.get(i);
        }

        // sort array and measure runtime of algorithm
        final long timeStart = System.nanoTime();
        sort(arr);
        final long timeEnd = System.nanoTime();
        for (int u = 0; u < arr.length; u++) {
            System.out.println(arr[u] + " ");
        }
        System.out.println("Lauf des Sortieralgoruthmus: " + (timeEnd - timeStart) + "Nanosek.");
    }
}
