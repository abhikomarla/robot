package com.abhijith.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandExecutor {

    @Autowired
    private PositionProcessor positionProcessor;

    /**
     * Executes the respective commands
     * @param command
     */
    public void execute(final Command command) {

        switch (command.getInstruction()) {
            case PLACE:
                positionProcessor.place(command.getX(), command.getY(), command.getDirection());
                break;
            case LEFT:
                positionProcessor.rotateLeft();
                break;
            case RIGHT:
                positionProcessor.rotateRight();
                break;
            case MOVE:
                positionProcessor.move();
                break;
            case REPORT:
                positionProcessor.report();
                break;
            default:
                break;
        }
    }
}
