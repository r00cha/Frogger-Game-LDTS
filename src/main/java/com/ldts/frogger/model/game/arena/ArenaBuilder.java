package com.ldts.frogger.model.game.arena;


import com.ldts.frogger.model.game.elements.Car;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.model.game.elements.Sidewalk;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setFrog(createFrog());
        arena.setCars(createCars());
        arena.setSidewalks(createSidewalks());
        return arena;
    }

    protected abstract List<Car> createCars();

    protected abstract List<Sidewalk> createSidewalks();

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract Frog createFrog();

}
