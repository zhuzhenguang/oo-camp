package oo.car.parkpolicy;

import oo.car.ParkingLot;

import java.util.Comparator;

/**
 * by empty slots
 * <p/>
 * Created by twer on 15/8/8.
 */
public class ParkingByEmptySlotsPolicy extends ParkingByMaxValuePolicy {
    @Override
    Comparator<ParkingLot> parkingLotComparator() {
        return (o1, o2) -> Integer.valueOf(o1.emptySlot()).compareTo(o2.emptySlot());
    }
}