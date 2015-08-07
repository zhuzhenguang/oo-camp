package oo.car;

import java.util.Comparator;

/**
 * compare parking lot
 * <p/>
 * Created by twer on 15/8/7.
 */
public class ParkingLotComparatorByEmptySlots implements Comparator<ParkingLot> {
    @Override
    public int compare(ParkingLot o1, ParkingLot o2) {
        return -(Integer.valueOf(o1.emptySlot()).compareTo(o2.emptySlot()));
    }
}
