package com.dkus.interviews.vs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author anders.schwartz
 */
public class StatisticsGeneratorTest {

    @Test
    public void testRollingWindows() {
        int w1Size = 3;
        int w2Size = 20;
        int streamCount = 100;

        List<Double> data = new ArrayList<>();
        for (int i = 1; i < streamCount; i++) {
            data.add(i * 1.0);
        }
        StatisticsGenerator sc = new StatisticsGenerator(w1Size, w2Size, data.iterator());

        // Note, the following is not the proper way to validate the contents of the WindowTuple.
        // Given more time I would have implemented equals (and hashCode) for WindowTuple and used that to compare with!
        for (int i = 0; i < data.size(); i++) {
            WindowTuple wt = sc.next();
            if (i == 2) {
                assertEquals("(2.00, 3.00, None, None)", wt.toString());
            } else if (i == 19) {
                assertEquals("(19.00, 20.00, 10.50, 20.00)", wt.toString());
            } else if (i == 99) {
                assertEquals("(98.00, 99.00, 89.50, 99.00)", wt.toString());
            }
        }
    }

    @Test
    public void testNonMonotonicInput() {
        int w1Size = 3;
        int w2Size = 2;
        List<Double> data = new ArrayList<>();
        data.add(4.0);
        data.add(3.0);
        data.add(7.0);
        data.add(9.0);
        data.add(1.0);

        StatisticsGenerator sc = new StatisticsGenerator(w1Size, w2Size, data.iterator());

        // Note, the following is not the proper way to validate the contents of the WindowTuple.
        // Given more time I would have implemented equals (and hashCode) for WindowTuple and used that to compare with!
        assertEquals("(None, None, None, None)", sc.next().toString());
        assertEquals("(None, None, 3.50, 4.00)", sc.next().toString());
        assertEquals("(4.67, 7.00, 5.00, 7.00)", sc.next().toString());
        assertEquals("(6.33, 9.00, 8.00, 9.00)", sc.next().toString());
        assertEquals("(5.67, 9.00, 5.00, 9.00)", sc.next().toString());
    }
}
