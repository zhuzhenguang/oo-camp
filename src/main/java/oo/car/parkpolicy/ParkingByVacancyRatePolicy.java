package oo.car.parkpolicy;

import oo.car.ParkingLot;

import java.util.Comparator;

/**
 * VacancyRate
 * <p/>
 * Created by twer on 15/8/11.
 */
public class ParkingByVacancyRatePolicy extends ParkingByMaxValuePolicy {
    @Override
    Comparator<ParkingLot> parkingLotComparator() {
        return (o1, o2) -> Double.valueOf(o1.vacancyRate()).compareTo(o2.vacancyRate());
    }
}