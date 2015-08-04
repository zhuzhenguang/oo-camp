package oo.car;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * park test
 * <p/>
 * Created by twer on 15/7/30.
 */
public class ParkTest {
    @Test
    public void should_park_car_when_parking_lot_not_full() {
        ParkingLot aParkingLot = new ParkingLot(5);

        String cardNo = aParkingLot.park("A1");

        assertNotNull(cardNo);
    }

    @Test
    public void should_not_park_car_when_parking_lot_full() {
        ParkingLot aParkingLot = new ParkingLot(1);
        aParkingLot.park("A1");

        String cardNo = aParkingLot.park("A2");

        assertNull(cardNo);
    }

    @Test
    public void should_pick_car_when_the_car_in_parking_lot() {
        ParkingLot aParkingLot = new ParkingLot(5);
        String cardNo = aParkingLot.park("A1");

        String pickedCar = aParkingLot.pick(cardNo);

        assertEquals("A1", pickedCar);
    }

    @Test
    public void should_not_pick_car_when_the_car_not_in_parking_lot() {
        ParkingLot aParkingLot = new ParkingLot(5);

        String pickedCar = aParkingLot.pick("XXXX");

        assertNull(pickedCar);
    }

    @Test
    public void should_not_pick_car_when_the_car_has_picked() {
        ParkingLot aParkingLot = new ParkingLot(5);
        String cardNo = aParkingLot.park("A1");
        aParkingLot.pick(cardNo);

        String pickedCar = aParkingLot.pick(cardNo);

        assertNull(pickedCar);
    }
}
