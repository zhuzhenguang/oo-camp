package oo.car;

import java.util.*;

/**
 * parking
 * <p/>
 * Created by twer on 15/7/30.
 */
public class ParkingLot {
    private Map<String, String> parkedCars = new HashMap<>();
    private int space;

    public ParkingLot(int space) {
        this.space = space;
    }

    public String pick(String cardNo) {
        String licenseNo = parkedCars.get(cardNo);
        if (licenseNo != null) {
            parkedCars.remove(cardNo);
        }
        return licenseNo;
    }

    public String park(String licenseNo) {
        String cardNo = null;
        if (haveEmptySlot()) {
            cardNo = UUID.randomUUID().toString();
            parkedCars.put(cardNo, licenseNo);
        }
        return cardNo;
    }

    private boolean haveEmptySlot() {
        return parkedCars.size() < space;
    }
}
