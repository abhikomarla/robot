package com.abhijith.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommandProcessorTest {

    private CommandProcessor commandProcessor = new CommandProcessor();

    @Test (expected = Exception.class)
    public void testProcess_1() {
        commandProcessor.process("place abcd,abcd,abcd");
    }

    @Test (expected = Exception.class)
    public void testProcess_2() {
        commandProcessor.process("place 1,abcd,abcd");
    }

    @Test (expected = Exception.class)
    public void testProcess_3() {
        commandProcessor.process("place 1,1,abcd");
    }

    @Test
    public void testProcess_4() {
        Command returnValue = commandProcessor.process("place 1,1,NORTH");
        assertNotNull(returnValue);
        assertEquals(Command.Instruction.PLACE, returnValue.getInstruction());
        assertEquals(Command.Direction.NORTH, returnValue.getDirection());
        assertEquals(1, returnValue.getX());
        assertEquals(1, returnValue.getY());
    }

    @Test
    public void testProcess_5() {
        Command returnValue = commandProcessor.process("MOVE");
        assertNotNull(returnValue);
        assertEquals(Command.Instruction.MOVE, returnValue.getInstruction());
    }
}
