package telran.range;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BrokenFloorTest {

private int getMinimalBrokenFloor(BallBrokenFloor bbf) {
    //TODO
//Using only method checkFloor to find out minimal broken floor by applying 
//binary search algorithm
 return -1;
}
@Test
void minimalBrokenFloorTest() {
    int [] floors = {200, 17, 1001, 2000};
    for(int i = 0; i < floors.length; i++) {
        BallBrokenFloor bbf = new BallBrokenFloor(floors[i]);
        assertEquals(bbf.getMinBrokenFloor(), getMinimalBrokenFloor(bbf));
    }
}
}
