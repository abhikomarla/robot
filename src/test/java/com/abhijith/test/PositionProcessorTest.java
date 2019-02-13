package com.abhijith.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PositionProcessorTest {

    private PositionProcessor positionProcessor = new PositionProcessor();

    @Test
    public void test() {
        positionProcessor.place(1,1, Command.Direction.NORTH);
        assertEquals(1, positionProcessor.getX());
        assertEquals(1, positionProcessor.getY());
        assertEquals(Command.Direction.NORTH, positionProcessor.getDirection());

        positionProcessor.rotateRight();
        assertEquals(Command.Direction.EAST, positionProcessor.getDirection());

        positionProcessor.rotateLeft();
        positionProcessor.rotateLeft();
        positionProcessor.rotateLeft();
        assertEquals(Command.Direction.SOUTH, positionProcessor.getDirection());

        positionProcessor.move();
        assertEquals(1, positionProcessor.getX());
        assertEquals(0, positionProcessor.getY());
        assertEquals(Command.Direction.SOUTH, positionProcessor.getDirection());

        positionProcessor.move();
        assertEquals(1, positionProcessor.getX());
        assertEquals(0, positionProcessor.getY());
        assertEquals(Command.Direction.SOUTH, positionProcessor.getDirection());

        positionProcessor.rotateRight();
        positionProcessor.move();
        assertEquals(0, positionProcessor.getX());
        assertEquals(0, positionProcessor.getY());
        assertEquals(Command.Direction.WEST, positionProcessor.getDirection());
    }
}
