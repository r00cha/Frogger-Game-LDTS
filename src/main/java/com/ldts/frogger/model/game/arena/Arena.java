package com.ldts.frogger.model.game.arena;

import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.elements.Car;
import com.ldts.frogger.model.game.elements.Frog;
import com.sun.source.tree.Tree;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Frog frog;
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Frog getFrog() {
        return frog;
    }

    public void setFrog(Frog frog) {
        this.frog = frog;
    }
    public boolean isEmpty(Position position) {

        return true;
    }
    public boolean isCar(Position position) {
        for (Car car : cars)
            if (car.getPosition().equals(position))
                return true;
        return false;
    }

}
