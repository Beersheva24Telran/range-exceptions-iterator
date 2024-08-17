package telran.range;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import telran.range.exceptions.OutOfRangeMaxValueException;
import telran.range.exceptions.OutOfRangeMinValueException;

public class RangeTest {
    private static final int MIN = 50;
    private static final int MAX = 100;
    Range range = Range.getRange(MIN, MAX);
    @Test
    void wrongRangeCtreatingTest() {
        assertThrowsExactly(IllegalArgumentException.class, () -> Range.getRange(MAX, MIN) );
    }
    @Test
    void rightNumberTest() throws Exception {
        range.checkNumber(55);
    }
    void wrongNumberTest() throws Exception {
        assertThrowsExactly(OutOfRangeMaxValueException.class,
         () -> range.checkNumber(MAX + 1));
         assertThrowsExactly(OutOfRangeMinValueException.class, () -> range.checkNumber(MIN - 1));
    }
    @Test
    void iteratorTest() {
        Range range = Range.getRange(1, 3);
        runTest(new Integer[] {1,2,3}, range);
    }
    @Test
    void iteratorPredicateMatchTest() {
        Range range = Range.getRange(1, 3);
        range.setPredicate(n -> n % 2 == 0); 
        runTest(new Integer[]{2}, range);
        range.setPredicate(n -> n % 2 != 0); 
        runTest(new Integer[]{1, 3}, range);

    }
    @Test
    void iteratorPredicateNoMatchTest() {
        range.setPredicate(n -> n > MAX);
        runTest(new Integer[0], range);

    }
    private void runTest(Integer[] expected, Range range) {
        Integer [] actual = new Integer[expected.length];
        Iterator<Integer> it = range.iterator();
        int index = 0;
        while(it.hasNext()) {
            actual[index++] = it.next();
        }
        assertArrayEquals(expected, actual);
        assertThrowsExactly(NoSuchElementException.class, it::next);
    }
}
