package telran.range.exceptions;

public class OutOfRangeMinValueException extends Exception{
    public OutOfRangeMinValueException(int min, int number) {
        super(String.format("Out of Range min: %d, number: %d", min, number));
    }
}
