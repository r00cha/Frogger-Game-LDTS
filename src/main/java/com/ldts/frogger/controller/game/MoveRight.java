package com.ldts.frogger.controller.game;

import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;


public class MoveRight extends Command{

    @Override
    public Position execute(Position position, Arena arena) {
        if(position.getX() > arena.getWidth() - 2){
            return new Position(-1,position.getY());
        }
       return position.getRight();
    }
}
