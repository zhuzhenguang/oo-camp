package oo.car.parkpolicy;

import oo.car.ParkingLot;

import java.util.Optional;

/**
 * parking policy
 * <p/>
 * Created by twer on 15/8/7.
 */
public interface ParkPolicy {
    Optional<ParkingLot> choose(ParkingLot[] parkingLots);
}
