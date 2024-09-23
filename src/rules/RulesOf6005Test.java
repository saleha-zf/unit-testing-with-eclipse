/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }
    
    
    @Test
    public void testCitedPublicCodeWrittenAsCoursework() {
        assertTrue("Expected true: cited publicly-available code written as coursework",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }

    /**
     * Test case: code not written by the student, not available to others.
     */
    @Test
    public void testNonSelfWrittenCodeNotAvailable() {
        assertFalse("Expected false: code not written by you and not available to others",
                RulesOf6005.mayUseCodeInAssignment(false, false, false, false, true));
    }

    /**
     * Test case: self-written code that does not require implementation.
     */
    @Test
    public void testSelfWrittenCodeNotRequired() {
        assertTrue("Expected true: self-written code when implementation is not required",
                RulesOf6005.mayUseCodeInAssignment(true, false, false, false, false));
    }
}
