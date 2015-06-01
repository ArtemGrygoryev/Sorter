package test;
import com.artem.sorter.Sorter;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SorterTest {
    @Test
    public void sortShouldHandleEmptyArray() {
        int[] result = Sorter.sort(new int[0]);
        assertArrayEquals(new int[0], result);
    }

    @Test
    public void sortShouldHandleOneElement() {
        int[] result = Sorter.sort(new int[]{1});
        assertArrayEquals(new int[]{1}, result);
    }

    @Test
    public void sortShouldHandleEvenAmountOfElements() {
        int[] result = Sorter.sort(new int[]{2, 1});
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void sortShouldHandleOddAmountOfElements() {
        int[] result = Sorter.sort(new int[]{2, 1, 3});
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    public void sortShouldHandleEqualElements() {
        int[] result = Sorter.sort(new int[]{3, 3, 3, 2, 2, 2});
        assertArrayEquals(new int[]{2, 2, 2, 3, 3, 3}, result);
    }
}