package telran.range;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BrokenFloorTest {

private int getMinimalBrokenFloor(BallBrokenFloor bbf) {
//Using only method checkFloor to find out minimal broken floor by applying 
//binary search algorithm
int downFloor = 0;
int uperFloor = Integer.MAX_VALUE;
int middle = (uperFloor + downFloor) / 2;
while (downFloor <= uperFloor) {
    try {
        bbf.checkFloor(middle);
        downFloor = middle + 1;
    } catch (Exception e) {
        uperFloor = middle -1;
    }
    middle = (uperFloor + downFloor) / 2;
}

 return downFloor;
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
