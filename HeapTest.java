import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {

    @Test
    void makeHeap() {
        Heap heap= new Heap();
        int[] a = {4,6,1,3,2,9,8,7,5};
        heap.MakeHeap(a,3);
        System.out.println(Arrays.toString(heap.HeapArray));
    }

    @Test
    void getMax() {
        Heap heap= new Heap();
        int[] a = {4,6,9,8,7,5,10,1,12,2,11,3};
        heap.MakeHeap(a,3);
        System.out.println(Arrays.toString(heap.HeapArray));
        assertEquals(12,heap.GetMax());
        System.out.println(Arrays.toString(heap.HeapArray));
    }


    @Test
    void add() {
        Heap heap= new Heap();
        int[] a = {4,6,9,8,7,5};
        heap.MakeHeap(a,3);
        heap.Add(12);
        heap.Add(2);
        heap.Add(10);
        heap.Add(11);
        heap.Add(1);
        System.out.println(Arrays.toString(heap.HeapArray));
    }
    @Test
    void add2() {
        Heap heap= new Heap();
        int[] a = {40,60,90,80,70,50};
        heap.MakeHeap(a,3);
        heap.Add(64);
        heap.Add(23);
        heap.Add(65);
        heap.Add(71);
        heap.Add(77);
        System.out.println(Arrays.toString(heap.HeapArray));
    }

    @Test
    void addFullHeap() {
        Heap heap= new Heap();
        int[] a = {4,6,9};
        heap.MakeHeap(a,1);
        assertFalse(heap.Add(12));
        System.out.println(Arrays.toString(heap.HeapArray));
    }
}