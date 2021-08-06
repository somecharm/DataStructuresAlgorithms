import java.util.*;

public class AlgorithmsDataStructures2 {


    public static int[] GenerateBBSTArray(int[] a) {
        int size = 0, depth = 0;
        while (size < a.length) {
            size = (int) Math.pow(2, depth + 1) - 1;
            depth++;
        }
        int[] BBSTArray = new int[size];
        Arrays.sort(a);
        Generate(a, 0, BBSTArray);
        return BBSTArray;
    }

    private static void Generate(int[] a, int index, int[] BBSTArray) {
        int middle = a.length / 2;
        BBSTArray[index] = a[middle];

        int[] left = Arrays.copyOfRange(a, 0, middle);
        int[] right = Arrays.copyOfRange(a, middle + 1, a.length);

        if (left.length > 0) {
            Generate(left, 2 * index + 1, BBSTArray);
        }
        if (right.length > 0) {
            Generate(right, 2 * index + 2, BBSTArray);
        }
    }

}