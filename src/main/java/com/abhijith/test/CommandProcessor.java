package com.abhijith.test;

import org.springframework.stereotype.Component;

@Component
public class CommandProcessor {

    /**
     * Converts string input into a Command object
     * @param input
     * @return
     */
    public Command process(final String input) {
        Command command = new Command();

        String[] commands = input.split(" ");
        command.setInstruction(commands[0]);

        if (commands.length == 2) {
            String[] coordinates = commands[1].split(",");
            command.setX(Integer.parseInt(coordinates[0]));
            command.setY(Integer.parseInt(coordinates[1]));
            command.setDirection(coordinates[2].toUpperCase());
        }

        return command;
    }
}
