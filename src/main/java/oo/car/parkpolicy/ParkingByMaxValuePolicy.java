package oo.car.parkpolicy;

import oo.car.ParkingLot;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/**
 * max policy
 * <p/>
 * Created by twer on 15/8/12.
 */
abstract class ParkingByMaxValuePolicy implements ParkPolicy {
    abstract Comparator<ParkingLot> parkingLotComparator();

    @Override
    public Optional<ParkingLot> choose(ParkingLot[] parkingLots) {
        return Arrays.asList(parkingLots).stream().max(parkingLotComparator());
    }
}
