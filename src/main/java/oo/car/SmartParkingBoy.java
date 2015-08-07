package oo.car;

import java.util.Arrays;

/**
 * smart parking boy
 *
 * Created by twer on 15/8/7.
 */
public class SmartParkingBoy {
    private ParkingLot[] parkingLots;

    public SmartParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots = parkingLots;
    }

    public String park(String car) {
        Arrays.sort(parkingLots, new ParkingLotComparatorByEmptySlots());

        for (ParkingLot parkingLot : parkingLots) {
            String carNo = parkingLot.park(car);
            if (carNo != null) {
                return carNo;
            }
        }
        return null;
    }

    public String pick(String carNo) {
        for (ParkingLot parkingLot : parkingLots) {
            String pickedCar = parkingLot.pick(carNo);
            if (pickedCar != null) {
                return pickedCar;
            }
        }
        return null;
    }
}
