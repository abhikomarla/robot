package com.abhijith.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidatorTest {

    private Validator validator = new Validator();

    @Test
    public void testValidateStart() {
        assertFalse(validator.checkIfValidStart(""));
        assertFalse(validator.checkIfValidStart("    "));
        assertFalse(validator.checkIfValidStart(null));
        assertFalse(validator.checkIfValidStart("xfgcfgxg"));
        assertFalse(validator.checkIfValidStart("place"));
        assertFalse(validator.checkIfValidStart("1,1,NORTH"));
        assertFalse(validator.checkIfValidStart("place 1,1,north,1234"));
        assertFalse(validator.checkIfValidStart("place 1 1"));
        assertTrue(validator.checkIfValidStart("place abcd,abcd,abcd"));
        assertTrue(validator.checkIfValidStart("place 1,1,north"));
    }

    @Test
    public void test() {
        assertFalse(validator.validateInput(""));
        assertFalse(validator.validateInput("           "));
        assertFalse(validator.validateInput(null));
        assertFalse(validator.validateInput("djgnkfdjg"));
        assertTrue(validator.validateInput("move"));
        assertTrue(validator.validateInput("MOVE"));
        assertTrue(validator.validateInput("REPORT"));
        assertTrue(validator.validateInput("LEFT"));
        assertTrue(validator.validateInput("RIGHT"));
    }
}
