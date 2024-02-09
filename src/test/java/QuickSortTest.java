import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {
    private final QuickSort quickSort = new QuickSort();

    @Test
    public void testEmptyArray() {
        int[] array = {};
        quickSort.sort(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    public void testSingleElement() {
        int[] array = {1};
        quickSort.sort(array);
        assertArrayEquals(new int[]{1}, array);
    }

    @Test
    public void testTwoElements() {
        int[] array = {5, 2};
        quickSort.sort(array);
        assertArrayEquals(new int[]{2, 5}, array);
    }

    @Test
    public void testMultipleElementsSorted() {
        int[] array = {1, 2, 3, 4, 5};
        quickSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testMultipleElementsReverseSorted() {
        int[] array = {5, 4, 3, 2, 1};
        quickSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testLargeArray() {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
        quickSort.sort(array);
        for (int i = 1; i <= array.length; i++) {
            assertEquals(i, array[i - 1]);
        }
    }

    @Test
    public void testDuplicates() {
        int[] array = {3, 2, 1, 2, 3};
        quickSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 2, 3, 3}, array);
    }

}
