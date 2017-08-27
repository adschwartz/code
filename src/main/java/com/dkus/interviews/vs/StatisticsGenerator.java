package com.dkus.interviews.vs;

import java.util.*;

/**
 * Class for computing the mean and max of two sliding windows.
 * <p>
 * See example of use in  main of this class {@link #main(String[])} or in unit test
 * class {@code StatisticsGeneratorTest}.
 *
 * @author anders.schwartz
 */
public class StatisticsGenerator implements Iterator<WindowTuple> {

    private final Iterator<Double> inputIterator;

    private final MeanMaxStatistic mms1;
    private final MeanMaxStatistic mms2;

    /**
     * This class implements an iterator a data stream ({@link #inputIterator}), computing the mean and max of two
     * rolling windows of sizes {@code w1Size} and {@code w2Size}.
     * <p>
     * Average time complexity: O(1)
     * Space complexity: O(w), where w is the size of the largest window.
     *
     * @param w1Size   The size (larger than zero) of the first rolling window.
     * @param w2Size   The size (larger than zero) of the second rolling window.
     * @param iterator Iterator over the data stream.
     */
    public StatisticsGenerator(int w1Size, int w2Size, Iterator<Double> iterator) {
        Objects.requireNonNull(iterator);
        assert w1Size > 0;
        assert w2Size > 0;

        this.inputIterator = iterator;
        this.mms1 = new MeanMaxStatistic(w1Size);
        this.mms2 = new MeanMaxStatistic(w2Size);
    }

    /**
     * @return Returns true if the input data stream has more elements that can be included for statistical
     * computation. See also {@link #next()}.
     */
    @Override
    public boolean hasNext() {
        return inputIterator.hasNext();
    }

    /**
     * @return {@link WindowTuple} of the min and max of the elements of the two current windows.
     * @throws NoSuchElementException is thrown if the input data stream does not have any elements.
     */
    @Override
    public WindowTuple next() throws NoSuchElementException {
        Double nextElement = inputIterator.next();

        // Update statistics:
        mms1.slideWindow(nextElement);
        Double mean1 = mms1.getCurrentMean();
        Double max1 = mms1.getCurrentMax();

        mms2.slideWindow(nextElement);
        Double mean2 = mms2.getCurrentMean();
        Double max2 = mms2.getCurrentMax();

        return new WindowTuple(mean1, max1, mean2, max2);
    }

    public static void main(String[] args) {
        int streamCount = 100;
        List<Double> data;

        data = new ArrayList<>();
        for (int i = 1; i < streamCount; i++) {
            data.add(i * 1.0);
        }
        final Iterator<Double> iterator = data.iterator();

        int w1Size = 3;
        int w2Size = 20;
        StatisticsGenerator sc = new StatisticsGenerator(w1Size, w2Size, iterator);

        while (sc.hasNext()) {
            System.out.println(sc.next());
        }
    }
}