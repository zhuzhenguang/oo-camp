package oo.car.parkpolicy;

import oo.car.ParkingLot;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/**
 * by empty slots
 * <p/>
 * Created by twer on 15/8/8.
 */
public class ParkingByEmptySlotsPolicy implements ParkPolicy {
    public static final Comparator<ParkingLot> PARKING_LOT_COMPARATOR = (o1, o2) ->
            Integer.valueOf(o1.emptySlot()).compareTo(o2.emptySlot());

    @Override
    public Optional<ParkingLot> choose(ParkingLot[] parkingLots) {
        return Arrays.asList(parkingLots).stream().max(PARKING_LOT_COMPARATOR);
    }
}