package oo;

/**
 * length
 *
 * Created by twer on 15/7/28.
 */
public class Length {
    private double value;
    private Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    private int compare(Length other) {
        if (this.unit != other.unit) {
            throw new RuntimeException("Not support");
        }

        if (value > other.value) {
            return 1;
        } else if (value < other.value) {
            return -1;
        } else {
            return 0;
        }
    }

    public boolean isLongerThan(Length shorter) {
        return compare(shorter) == 1;
    }

    public boolean isShorterThan(Length longer) {
        return compare(longer) == -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length length = (Length) o;
        return compare(length) == 0;
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
}
