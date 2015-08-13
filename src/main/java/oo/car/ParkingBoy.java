package oo.car;

import oo.car.parkpolicy.ParkingByByEmptySlotsPolicy;
import oo.car.parkpolicy.ParkPolicy;
import oo.car.parkpolicy.ParkSequentialPolicy;
import oo.car.parkpolicy.ParkingByVacancyRatePolicy;

import java.util.Optional;

/**
 * parking boy
 * <p/>
 * Created by twer on 15/8/7.
 */
public class ParkingBoy {
    protected ParkingLot[] parkingLots;
    private ParkPolicy parkPolicy;

    private ParkingBoy(ParkPolicy parkPolicy, ParkingLot... parkingLots) {
        this.parkPolicy = parkPolicy;
        this.parkingLots = parkingLots;
    }

    public String park(String car) {
        Optional<ParkingLot> parkingLot = parkPolicy.choose(parkingLots);
        return parkingLot.isPresent() ? parkingLot.get().park(car) : null;
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

    public static ParkingBoy commonInstance(ParkingLot... parkingLots) {
        return new ParkingBoy(new ParkSequentialPolicy(), parkingLots);
    }

    public static ParkingBoy smartInstance(ParkingLot... parkingLots) {
        return new ParkingBoy(new ParkingByByEmptySlotsPolicy(), parkingLots);
    }

    public static ParkingBoy superInstance(ParkingLot... parkingLots) {
        return new ParkingBoy(new ParkingByVacancyRatePolicy(), parkingLots);
    }
}
