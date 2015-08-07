package oo.car;

/**
 * parking body
 * <p/>
 * Created by twer on 15/8/6.
 */
public class ParkingBoy {
    private ParkingLot[] parkingLots;

    public ParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots = parkingLots;
    }

    public String park(String car) {
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
