package oo.car.parkpolicy;

import oo.car.ParkingLot;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/**
 * VacancyRate
 * <p/>
 * Created by twer on 15/8/11.
 */
public class ParkVacancyRatePolicy implements ParkPolicy {
    private static Comparator<ParkingLot> comparator = (o1, o2) ->
            Double.valueOf(o1.vacancyRate()).compareTo(o2.vacancyRate());

    @Override
    public Optional<ParkingLot> choose(ParkingLot[] parkingLots) {
        return Arrays.asList(parkingLots).stream().max(comparator);
    }
}
