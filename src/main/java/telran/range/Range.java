package telran.range;

import java.util.Iterator;
import java.util.NoSuchElementException;

import telran.range.exceptions.OutOfRangeMaxValueException;
import telran.range.exceptions.OutOfRangeMinValueException;

public class Range implements Iterable<Integer>{
    private static final String ERROR_MESSAGE = "max less or equal min";
    private int min;
    private int max;
    private Range(int min, int max) {
        this.min = min;
        this.max = max; 
    }
    public static Range getRange(int min, int max) {
        if (max <= min) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return new Range(min, max);
    }
    public void checkNumber(int number) throws OutOfRangeMaxValueException, OutOfRangeMinValueException {
        if(number > max) {
            throw new OutOfRangeMaxValueException(max, number);
        }
        if (number < min) {
            throw new OutOfRangeMinValueException(min, number);
        }
    }
    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }
    private class RangeIterator implements Iterator<Integer> {
        int current = min;
        @Override
        public boolean hasNext() {
            //the method hasNext in all Iterator classes only checks whether there are more
            // objects for iterating
            return current <= max;
        }

        @Override
        public Integer next() {
            if(! hasNext()) {
                throw new NoSuchElementException();
            }
            return current++;
        }
        
    }
}
