package oo.car;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * parking manager
 * <p/>
 * Created by twer on 15/8/13.
 */
public class ParkingManagerTest {
    @Test
    public void should_park_car_when_he_manage_a_parking_lot_with_1_empty_position() {
        ParkingLot aParkingLot = new ParkingLot(1);
        ParkingManager aParkingManager = new ParkingManager(aParkingLot);

        String carNo = aParkingManager.park("a new car");

        assertEquals("a new car", aParkingLot.pick(carNo));
    }

    @Test
    public void should_park_car_when_he_manage_2_parking_lots_and_each_parking_lot_has_1_empty_position() {
        ParkingLot firstParkingLot = new ParkingLot(1);
    }

}
