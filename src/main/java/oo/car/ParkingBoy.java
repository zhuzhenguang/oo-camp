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
        String carNo = null;
        for (ParkingLot parkingLot : parkingLots) {
            carNo = parkingLot.park(car);
            if (carNo != null) {
                break;
            }
        }
        return carNo;
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
