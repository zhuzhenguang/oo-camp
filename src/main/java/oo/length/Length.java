package oo.length;

/**
 * length
 * <p/>
 * Created by twer on 15/7/28.
 */
public class Length {
    private double value;
    private Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double convertUnitSameWith(Length other) {
        double factor = unit.convertTo(other.getUnit());
        return value * factor;
    }

    public boolean isLongerThan(Length shorter) {
        double shorterValue = shorter.convertUnitSameWith(this);
        return value > shorterValue;
    }

    public boolean isShorterThan(Length longer) {
        double longerValue = longer.convertUnitSameWith(this);
        return value < longerValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length other = (Length) o;
        double otherValue = other.convertUnitSameWith(this);
        return value == otherValue;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }

    public Unit getUnit() {
        return unit;
    }
}
