import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleSortTest {
    private final BubbleSort bubbleSort = new BubbleSort();

    @Test
    public void testEmptyArray() {
        int[] array = {};
        bubbleSort.sort(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    public void testSingleElement() {
        int[] array = {1};
        bubbleSort.sort(array);
        assertArrayEquals(new int[]{1}, array);
    }

    @Test
    public void testTwoElements() {
        int[] array = {5, 2};
        bubbleSort.sort(array);
        assertArrayEquals(new int[]{2, 5}, array);
    }

    @Test
    public void testMultipleElementsSorted() {
        int[] array = {1, 2, 3, 4, 5};
        bubbleSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testMultipleElementsReverseSorted() {
        int[] array = {5, 4, 3, 2, 1};
        bubbleSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testLargeArray() {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
        bubbleSort.sort(array);
        for (int i = 1; i <= array.length; i++) {
            assertEquals(i, array[i - 1]);
        }
    }

    @Test
    public void testDuplicates() {
        int[] array = {3, 2, 1, 2, 3};
        bubbleSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 2, 3, 3}, array);
    }

}
