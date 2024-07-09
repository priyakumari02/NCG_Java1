package com.adobe.orderapp.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilTest {
    @Test
    public void testGetMaxOfArray() {
        int[] data = {4,56,12,78,2};
        int result = ArrayUtil.getMax(data);
        assertEquals(78, result);
    }

    @Test
    public void testSortArray() {
        int[] data = {4,56,12,78,2};
        ArrayUtil.sort(data);
        int[] expected = {2,4,12,56,78};
        assertArrayEquals(expected, data); // compare data and not reference
    }
}
