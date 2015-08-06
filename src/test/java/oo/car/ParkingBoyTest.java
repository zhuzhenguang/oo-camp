package oo.car;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * parking boy
 * <p/>
 * Created by twer on 15/8/6.
 */
public class ParkingBoyTest {
    @Test
    public void should_park_car_by_body_when_he_manage_a_parking_lot_with_a_empty_position() {
        ParkingLot aParkingLot = new ParkingLot(1);
        ParkingBoy aBoy = new ParkingBoy(aParkingLot);

        String carNo = aBoy.park("a new car");

        assertEquals("a new car", aParkingLot.pick(carNo));
    }

    @Test
    public void should_not_park_car_by_body_when_he_manage_a_parking_lot_with_no_empty_position() {
        ParkingLot aParkingLot = new ParkingLot(0);
        ParkingBoy aBoy = new ParkingBoy(aParkingLot);

        String carNo = aBoy.park("a new car");

        assertNull(carNo);
    }

    @Test
    public void should_park_car_by_body_when_he_manage_2_parking_lot_with_1_empty_position() {
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy aBoy = new ParkingBoy(parkingLot1, parkingLot2);

        String carNo = aBoy.park("a new car");

        assertEquals("a new car", parkingLot2.pick(carNo));
    }

    @Test
    public void should_not_park_car_by_body_when_he_manage_2_parking_lot_with_no_empty_position() {
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(0);
        ParkingBoy aBoy = new ParkingBoy(parkingLot1, parkingLot2);

        String carNo = aBoy.park("a new car");

        assertNull(carNo);
    }

    @Test
    public void should_pick_car_by_body_when_he_manage_1_parking_lot_with_1_empty_position_and_a_car_has_been_parked() {
        ParkingLot aParkingLot = new ParkingLot(1);
        ParkingBoy aBoy = new ParkingBoy(aParkingLot);
        String carNo = aParkingLot.park("a new car");

        String pickedCar = aBoy.pick(carNo);

        assertEquals("a new car", pickedCar);
    }

    @Test
    public void should_pick_car_by_body_when_he_manage_2_parking_lot_with_1_empty_position_and_has_parked_a_car() {
        ParkingBoy aBoy = new ParkingBoy(new ParkingLot(0), new ParkingLot(1));
        String carNo = aBoy.park("a new car");

        String pickedCar = aBoy.pick(carNo);

        assertEquals("a new car", pickedCar);
    }

    @Test
    public void should_not_pick_car_by_boy_when_the_car_has_not_been_parked() {
        ParkingBoy aBoy = new ParkingBoy(new ParkingLot(0), new ParkingLot(1));

        String pickedCar = aBoy.pick("not exist car no");

        assertNull(pickedCar);
    }

    @Test
    public void should_not_pick_car_by_boy_when_the_car_had_been_picked() {
        ParkingBoy aBoy = new ParkingBoy(new ParkingLot(1));
        String carNo = aBoy.park("a new car");
        aBoy.pick(carNo);

        String pickedCar = aBoy.pick(carNo);

        assertNull(pickedCar);
    }

}
