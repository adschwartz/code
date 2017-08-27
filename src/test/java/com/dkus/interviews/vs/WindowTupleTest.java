package com.dkus.interviews.vs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author anders.schwartz
 */
public class WindowTupleTest {

    @Test
    public void testCreatingAndPrintingTuple() {
        WindowTuple tuple = new WindowTuple(3.4, 5.0, null, null);
        assertEquals("(3.40, 5.00, None, None)", tuple.toString());
    }
}