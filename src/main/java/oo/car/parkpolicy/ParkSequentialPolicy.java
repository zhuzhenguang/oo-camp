package oo.car.parkpolicy;

import oo.car.ParkingLot;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * sequential
 * <p/>
 * Created by twer on 15/8/7.
 */
public class ParkSequentialPolicy implements ParkPolicy {
    @Override
    public Optional<ParkingLot> choose(ParkingLot[] parkingLots) {
        return Arrays.asList(parkingLots).stream()
                .filter(ParkingLot::haveEmptySlot)
                .findFirst();
    }
}
