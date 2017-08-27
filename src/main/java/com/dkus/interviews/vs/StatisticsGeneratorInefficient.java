package com.dkus.interviews.vs;

import java.util.*;

/**
 * @author anders.schwartz
 */
public class StatisticsGeneratorInefficient implements Iterator<WindowTuple> {

    // for two windows use two queues
    // or use simple arrays with modding
    // implement iterable instead so you can loop over.
    // Deque: Add is amortized 1
    //<T extends Number> Consider using bigdecimal // how much precision with double?

    // Do this without keeping the data around??
    // Make things more pluggable. What if you want to do median?
    private final Deque<Double> window;

    private final int w1Size;
    private final int w2Size;

    private final Iterator<Double> inputIterator;

    /**
     * Assumption: w2size is greater than w1.
     *
     * Time complexity: O(n*m), where n is the total number of numbers in the stream and m is the window size
     * Space complexity: O(n), when the window size m=n. On average it will be m.
     *
     * @param w1Size
     * @param w2Size
     * @param iterator
     */
    public StatisticsGeneratorInefficient(int w1Size, int w2Size, Iterator<Double> iterator) {
        assert w1Size < w2Size;
        this.window = new ArrayDeque<>(w2Size);
        this.w1Size = w1Size;
        this.w2Size = w2Size;
        this.inputIterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return inputIterator.hasNext();
    }

    @Override
    public WindowTuple next() throws NoSuchElementException {
        Double next = inputIterator.next();
        if(window.size() == w2Size){
            window.remove();
        }
        window.add(next);
        return calculateStatistics();
    }

    // Don't like using nulls. Optional would have been more idiomatic but Optional would give a performance hit
    private WindowTuple calculateStatistics() {
        Double avg1 = null, max1 = null, avg2 = null, max2 = null;

        if (this.window.size() >= w1Size) {
            avg1 = 0.0;
            max1 = Double.MIN_VALUE;

            boolean secondCalc = false;
            if(this.window.size() >= w2Size) {
                avg2 = 0.0;
                max2 = Double.MIN_VALUE;
                secondCalc = true;
            }

            int counter = 0;
            Iterator<Double> reverseIterator = window.descendingIterator();
            while (reverseIterator.hasNext() && counter < w2Size) {
                Double val = reverseIterator.next();

                if (counter < w1Size) {
                    avg1 += val;
                    if (val > max1)
                        max1 = val;
                }
                if(secondCalc && counter < w2Size){
                    avg2 += val;
                    if (val > max2)
                        max2 = val;
                }

                counter++;
            }
            avg1 /= w1Size;
            if(secondCalc){
                avg2 /= w2Size;
            }
        }

        return new WindowTuple(avg1, max1, avg2, max2);
    }

}
