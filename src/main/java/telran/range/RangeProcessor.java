package telran.range;

import telran.range.exceptions.OutOfRangeMaxValueException;
import telran.range.exceptions.OutOfRangeMinValueException;

public class RangeProcessor {
    private Range range;
    private int counterOfGreaterMax;
    private int counterOfLessMin;
    private int counterOfRightNumbers;
    public RangeProcessor(Range range) {
        this.range = range;
    }
    public void processNumber(int number) {
        try {
            range.checkNumber(number);
            counterOfRightNumbers++;
        } catch (OutOfRangeMaxValueException e) {
            counterOfGreaterMax++;
        } catch (OutOfRangeMinValueException e) {
            counterOfLessMin++;
        }
    }
    public int getCounterOfGreaterMax(){
        return counterOfGreaterMax;
    }
    public int getCounterOfLessMin(){
        return counterOfLessMin;
    }
    public int getCounterOfRightNumbers(){
        return counterOfRightNumbers;
    }
}
