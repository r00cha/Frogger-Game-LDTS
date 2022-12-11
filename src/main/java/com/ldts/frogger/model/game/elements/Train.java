package com.ldts.frogger.model.game.elements;
import com.ldts.frogger.model.Position;

public class Train extends MoveableElement {
    private int direction = 0;
    private String color;
    public Train(int x, int y) {
        super(x, y);
    }
    public Train(Position position, int direction, String color) {
        super(position.getX(), position.getY());
        this.direction = direction;
        this.color = color;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}