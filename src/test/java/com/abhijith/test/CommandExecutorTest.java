package com.abhijith.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommandExecutorTest {

    @Mock
    private PositionProcessor positionProcessor;

    @InjectMocks
    private CommandExecutor commandExecutor;

    @Test
    public void testExecute_1() {
        Command command = new Command();
        command.setInstruction("place");
        command.setX(1);
        command.setY(1);
        command.setDirection("north");
        commandExecutor.execute(command);
        verify(positionProcessor, times(1)).place(1,1, Command.Direction.NORTH);
    }

    @Test
    public void testExecute_2() {
        Command command = new Command();
        command.setInstruction("move");
        commandExecutor.execute(command);
        verify(positionProcessor, times(1)).move();
    }

    @Test
    public void testExecute_3() {
        Command command = new Command();
        command.setInstruction("left");
        commandExecutor.execute(command);
        verify(positionProcessor, times(1)).rotateLeft();
    }

    @Test
    public void testExecute_4() {
        Command command = new Command();
        command.setInstruction("right");
        commandExecutor.execute(command);
        verify(positionProcessor, times(1)).rotateRight();
    }

    @Test
    public void testExecute_5() {
        Command command = new Command();
        command.setInstruction("report");
        commandExecutor.execute(command);
        verify(positionProcessor, times(1)).report();
    }
}
