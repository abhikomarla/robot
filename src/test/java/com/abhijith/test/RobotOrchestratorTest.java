package com.abhijith.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.lang.reflect.Method;

@RunWith(MockitoJUnitRunner.class)
public class RobotOrchestratorTest {

    @Spy
    private Validator validator;

    @Mock
    private CommandProcessor commandProcessor;

    @Mock
    private CommandExecutor commandExecutor;

    @InjectMocks
    private RobotOrchestrator robotOrchestrator;

    @Test
    public void test() throws Exception {
        Class<?> clazz = RobotOrchestrator.class;
        Method method = clazz.getDeclaredMethod("processInput", String.class);
        method.setAccessible(true);
        String input = "place 1,1,north";

        method.invoke(robotOrchestrator, input);
        verify(validator, times(1)).checkIfValidStart(input);
        verify(commandProcessor, times(1)).process(input);
        verify(commandExecutor, times(1)).execute(any());
    }
}
