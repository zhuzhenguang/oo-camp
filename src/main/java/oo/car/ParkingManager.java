package oo.car;

/**
 * parking manager
 * <p/>
 * Created by twer on 15/8/13.
 */
public class ParkingManager {
    private ParkingLot parkingLot;

    public ParkingManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String park(String car) {
        return parkingLot.park(car);
    }
}
