package oo.car;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Super
 *
 * Created by twer on 15/8/11.
 */
public class SuperParkingBoyTest {
    @Test
    public void should_park_car_by_boy_when_he_manage_a_parking_lot_with_a_empty_position() {
        ParkingLot aParkingLot = new ParkingLot(1);
        ParkingBoy aBoy = ParkingBoy.superInstance(aParkingLot);

        String carNo = aBoy.park("a new car");

        assertEquals("a new car", aParkingLot.pick(carNo));
    }

    @Test
    public void should_not_park_car_by_boy_when_he_manage_a_parking_lot_with_no_empty_position() {
        ParkingLot aParkingLot = new ParkingLot(0);
        ParkingBoy aBoy = ParkingBoy.superInstance(aParkingLot);

        String carNo = aBoy.park("a new car");

        assertNull(carNo);
    }

    @Test
    public void should_park_car_by_boy_when_he_manage_2_parking_lot_with_1_empty_position() {
        ParkingLot fullParkingLot = new ParkingLot(0);
        ParkingLot emptyParkingLot = new ParkingLot(1);
        ParkingBoy aBoy = ParkingBoy.superInstance(fullParkingLot, emptyParkingLot);

        String carNo = aBoy.park("a new car");

        assertEquals("a new car", emptyParkingLot.pick(carNo));
    }

    @Test
    public void should_not_park_car_by_boy_when_he_manage_2_parking_lot_with_no_empty_position() {
        ParkingBoy aBoy = ParkingBoy.superInstance(new ParkingLot(0), new ParkingLot(0));

        String carNo = aBoy.park("a new car");

        assertNull(carNo);
    }

    @Test
    public void should_pick_car_by_boy_when_he_manage_1_parking_lot_with_1_empty_position_and_a_car_has_been_parked() {
        ParkingLot aParkingLot = new ParkingLot(1);
        ParkingBoy aBoy = ParkingBoy.superInstance(aParkingLot);
        String carNo = aParkingLot.park("a new car");

        String pickedCar = aBoy.pick(carNo);

        assertEquals("a new car", pickedCar);
    }

    @Test
    public void should_pick_car_by_boy_when_he_manage_2_parking_lot_with_1_empty_position_and_has_parked_a_car() {
        ParkingBoy aBoy = ParkingBoy.superInstance(new ParkingLot(0), new ParkingLot(1));
        String carNo = aBoy.park("a new car");

        String pickedCar = aBoy.pick(carNo);

        assertEquals("a new car", pickedCar);
    }

    @Test
    public void should_not_pick_car_by_boy_when_the_car_has_not_been_parked() {
        ParkingBoy aBoy = ParkingBoy.superInstance(new ParkingLot(0), new ParkingLot(1));

        String pickedCar = aBoy.pick("not exist car no");

        assertNull(pickedCar);
    }

    @Test
    public void should_not_pick_car_by_boy_when_the_car_had_been_picked() {
        ParkingBoy aBoy = ParkingBoy.superInstance(new ParkingLot(1));
        String carNo = aBoy.park("a new car");
        aBoy.pick(carNo);

        String pickedCar = aBoy.pick(carNo);

        assertNull(pickedCar);
    }
    
    @Test
    public void should_park_car_orderly_when_parking_lots_vacancy_rate_are_same() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy aBoy = ParkingBoy.superInstance(firstParkingLot, secondParkingLot);

        String carNo = aBoy.park("a new car");

        assertEquals("a new car", firstParkingLot.pick(carNo));
    }

    @Test
    public void should_park_car_to_vacancy_rate_larger_parking_lot(){
        ParkingLot vacancyRateSmaller = new ParkingLot(5);
        vacancyRateSmaller.park("Toyota car");
        vacancyRateSmaller.park("Nissan car");
        vacancyRateSmaller.park("Hongda car");
        ParkingLot vacancyRateLarger = new ParkingLot(2);
        vacancyRateLarger.park("Audi car");
        ParkingBoy aBoy = ParkingBoy.superInstance(vacancyRateSmaller, vacancyRateLarger);

        String carNo = aBoy.park("BMW car");

        assertEquals("BMW car", vacancyRateLarger.pick(carNo));
    }
}
