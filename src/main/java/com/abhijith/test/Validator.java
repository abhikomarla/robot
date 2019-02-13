package com.abhijith.test;

import org.springframework.stereotype.Component;

@Component
public class Validator {

    public boolean checkIfValidStart(final String input) {
        if (null == input || input.trim().isEmpty()) {
            return false;
        }

        String[] commands = input.split(" ");
        if (null != commands && commands.length != 2) {
            return false;
        }
        if ("PLACE".equalsIgnoreCase(commands[0])) {
            String[] coordinates = commands[1].split(",");
            if (null != coordinates && 3 != coordinates.length) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean validateInput(final String input) {
        if (null == input || input.trim().isEmpty()) {
            return false;
        }

        String[] commands = input.split(" ");
        if (null != commands && commands.length != 1) {
            return false;
        }

        if (!("MOVE".equalsIgnoreCase(input)
                || "LEFT".equalsIgnoreCase(input)
                || "RIGHT".equalsIgnoreCase(input)
                || "REPORT".equalsIgnoreCase(input))) {
            return false;
        }

        return true;
    }
}
