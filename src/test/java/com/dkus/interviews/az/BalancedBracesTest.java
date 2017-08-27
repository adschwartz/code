package com.dkus.interviews.az;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author anders.schwartz
 */
public class BalancedBracesTest {

    @Test
    public void validate() throws Exception {
        BalancedBraces bb = new BalancedBraces();

        assertTrue(bb.validate("[()]{}{[()()]()}"));
        assertFalse(bb.validate("[(])"));
        assertTrue(bb.validate("{}"));
        assertTrue(bb.validate("[]"));
        assertFalse(bb.validate(""));
        assertFalse(bb.validate("{{{"));
    }
}