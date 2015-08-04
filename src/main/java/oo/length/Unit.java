package oo.length;

/**
 * unit
 * <p/>
 * Created by twer on 15/7/28.
 */
public enum Unit {
    M(1.0),
    DM(10.0),
    CM(100.0);

    private final double value;

    Unit(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public double convertTo(Unit other) {
        return other.getValue() / value;
    }
}
