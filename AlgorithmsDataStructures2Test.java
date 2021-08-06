import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsDataStructures2Test {

    @Test
    void generateBBSTArray() {
        int[] a = {2, 5, 7, 4, 3, 1, 6};
        int[] array = AlgorithmsDataStructures2.GenerateBBSTArray(a);
        System.out.println(Arrays.toString(array));
    }

    @Test
    void generateBBSTArray2() {
        int[] a = {2, 5, 7, 4, 3, 1, 6, 8};
        int[] array = AlgorithmsDataStructures2.GenerateBBSTArray(a);
        System.out.println(Arrays.toString(array));
    }
}