package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class Train extends MoveableElement {

    public Train(int x, int y) {
        super(x, y);
    }

    public Train(Position position, int direction, String color) {
        super(position, direction, color);
    }

    public Train(Position position, int direction) {
        super(position, direction);
    }

}