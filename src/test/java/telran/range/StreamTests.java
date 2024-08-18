package telran.range;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Test;

public class StreamTests {
    Range range = Range.getRange(1, 6);

    @Test
    void evenNumbersFromRange() {

        Integer[] expected = { 2, 4, 6 };
        Integer[] actual = StreamSupport.stream(range.spliterator(), false)
                .filter(n -> n % 2 == 0).toArray(Integer[]::new);
        assertArrayEquals(expected, actual);
    }

    @Test
    void oddNumbersSumTest() {
        int sumExpected = 9;
        int sumActual = StreamSupport.stream(range.spliterator(), false).filter(n -> n % 2 != 0)
                .mapToInt(n -> (int) n).sum();
        assertEquals(sumExpected, sumActual);
    }
}
