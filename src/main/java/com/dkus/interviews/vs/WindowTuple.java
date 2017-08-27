package com.dkus.interviews.vs;

/**
 * @author anders.schwartz
 */
public class WindowTuple {

    private final Double mean1;
    private final Double max1;
    private final Double mean2;
    private final Double max2;

    public WindowTuple(Double mean1, Double max1, Double mean2, Double max2) {
        this.mean1 = mean1;
        this.max1 = max1;
        this.mean2 = mean2;
        this.max2 = max2;
    }

    private String format(Double number) {
        if (number == null) {
            return "None";
        } else {
            return String.format("%.2f", number);
        }
    }

    // TODO: Implement equals and hashCode to use for comparison in unit tests

    @Override
    public String toString() {
        return String.format("(%s, %s, %s, %s)", format(mean1), format(max1), format(mean2), format(max2));
    }
}
