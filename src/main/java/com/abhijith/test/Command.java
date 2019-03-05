package com.abhijith.test;

public class Command {

    private Instruction instruction;

    private int x;

    private int y;

    private Direction direction;

    public void setInstruction(String instruction) {
        this.instruction = Instruction.valueOf(instruction.toUpperCase());
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(final String direction) {
        this.direction = Direction.valueOf(direction.toUpperCase());
    }

    public enum Direction {
        NORTH, SOUTH, EAST, WEST
    }

    public enum Instruction {

        PLACE, MOVE, LEFT, RIGHT, REPORT;
    }
}



