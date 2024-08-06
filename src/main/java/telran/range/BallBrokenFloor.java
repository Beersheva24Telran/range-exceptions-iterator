package telran.range;

import java.util.Random;

public class BallBrokenFloor {
    private int nFloors;
    private int minBrokenFloor;
    public BallBrokenFloor(int nFloors) {
        this.nFloors = nFloors;
        minBrokenFloor = new Random().nextInt(1, nFloors + 1);
    }
    public void checkFloor (int floor) throws Exception {
        if (floor > nFloors) {
            throw new IllegalArgumentException();
        } 
        if (floor >= minBrokenFloor) {
            throw new Exception("ball is broken");
        }
    }
    public int getMinBrokenFloor() {
        //used only for testing purposes
        return minBrokenFloor;
    }
}
