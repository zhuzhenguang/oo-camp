package oo.car;

import java.util.*;

/**
 * parking
 * <p/>
 * Created by twer on 15/7/30.
 */
public class ParkingLot {
    private Map<String, String> parkedCars = new HashMap<>();
    private int maxSpace;

    public ParkingLot(int maxSpace) {
        this.maxSpace = maxSpace;
    }

    public String pick(String cardNo) {
        return parkedCars.remove(cardNo);
    }

    public String park(String licenseNo) {
        String cardNo = null;
        if (haveEmptySlot()) {
            cardNo = UUID.randomUUID().toString();
            parkedCars.put(cardNo, licenseNo);
        }
        return cardNo;
    }

    public int emptySlot() {
        return maxSpace - parkedCars.size();
    }

    public boolean haveEmptySlot() {
        return parkedCars.size() < maxSpace;
    }

    public double vacancyRate() {
        return maxSpace == 0 ? 0 : (double) emptySlot() / (double) maxSpace;
    }
}
