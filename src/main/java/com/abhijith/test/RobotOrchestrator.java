package com.abhijith.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class RobotOrchestrator {

    private Scanner scanner = new Scanner(System.in);

    @Autowired
    private Validator validator;

    @Autowired
    private CommandProcessor commandProcessor;

    @Autowired
    private CommandExecutor commandExecutor;

    private boolean validStart;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public void start() {
        do {
            logger.info("Enter your command : ");
            String input = scanner.nextLine();
            processInput(input);
        } while (true);
    }

    private void processInput(final String input) {

        boolean isValid;
        try {
            if (!validStart) {
                //not already a valid start
                //check and update if now it is a valid start
                isValid = validator.checkIfValidStart(input);
            } else {
                //valid start
                //check if the current input is valid
                isValid = validator.validateInput(input);
            }

            if (isValid) {
                // processInput
                Command command = commandProcessor.process(input);
                commandExecutor.execute(command);
                validStart = true;
            }
        } catch(Exception e) {
            logger.log(Level.WARNING, "Exception {}", e.getMessage());
        }
    }
}
