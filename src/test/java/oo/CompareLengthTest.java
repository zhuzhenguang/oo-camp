package oo;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * test length
 * <p>
 * Created by twer on 15/7/28.
 */
public class CompareLengthTest {
    @Test
    public void should_return_longer() {
        Length longer = new Length(2, Unit.M);
        Length shorter = new Length(1, Unit.M);

        boolean result = longer.isLongerThan(shorter);

        assertTrue(result);
    }

    @Test
    public void should_return_shorter() {
        Length longer = new Length(2, Unit.CM);
        Length shorter = new Length(1, Unit.CM);

        boolean result = shorter.isShorterThan(longer);

        assertTrue(result);
    }

    @Test
    public void should_be_same() {
        Length left = new Length(1, Unit.DM);
        Length right = new Length(1, Unit.DM);

        boolean result = left.equals(right);

        assertTrue(result);
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_given_different_units() {
        Length longer = new Length(2, Unit.M);
        Length shorter = new Length(1, Unit.CM);

        longer.isLongerThan(shorter);
    }
}
