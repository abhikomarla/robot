package com.abhijith.test;

import org.springframework.stereotype.Component;

@Component
public class PositionProcessor {

    private int x = -1;

    private int y = -1;

    private Command.Direction direction;

    public void place(final int x, final int y, final Command.Direction direction) {

        //if the robot is being placed outside the table ignore
        if ((x < 0 || x > 4)
            || (y < 0 || y > 4)) {
            return;
        }

        //else place the robot by updating local variables
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void rotateLeft() {

        //update direction based on current value
        switch (this.direction) {
            case EAST:
                this.direction = Command.Direction.NORTH;
                break;
            case WEST:
                this.direction = Command.Direction.SOUTH;
                break;
            case SOUTH:
                this.direction = Command.Direction.EAST;
                break;
            case NORTH:
                this.direction = Command.Direction.WEST;
                break;
        }
    }

    public void rotateRight() {

        //update direction based on current value
        switch (this.direction) {
            case EAST:
                this.direction = Command.Direction.SOUTH;
                break;
            case WEST:
                this.direction = Command.Direction.NORTH;
                break;
            case SOUTH:
                this.direction = Command.Direction.WEST;
                break;
            case NORTH:
                this.direction = Command.Direction.EAST;
                break;
        }
    }

    public void move() {

        //if the robot is being moved outside the table, ignore
        switch (this.direction) {
            case EAST:
                if (this.x != 4) {
                    this.x++;
                }
                break;
            case WEST:
                if (this.x != 0) {
                    this.x--;
                }
                break;
            case SOUTH:
                if (this.y != 0) {
                    this.y--;
                }
                break;
            case NORTH:
                if (this.y != 4) {
                    this.y++;
                }
                break;
        }
    }

    public void report() {
        //print the current position
        System.out.println(this.x + "," + this.y + "," + this.direction.name());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Command.Direction getDirection() {
        return direction;
    }
}
