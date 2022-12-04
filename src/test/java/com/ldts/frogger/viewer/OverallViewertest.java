package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Car;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.model.game.elements.Sidewalk;
import com.ldts.frogger.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class OverallViewertest {
    private GUI gui;
    private GameViewer viewer;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);
        arena.setSidewalks(Arrays.asList(new Sidewalk(1,1)));
        arena.setCars(Arrays.asList(new Car(new Position(4, 5), 0, "#ffffff"), new Car(new Position(5, 6), 1, "#000000")));
        arena.setFrog(new Frog(5, 8));
    }

    @Test
    void drawFrog() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawFrog(new Position(5, 8), 0, arena.getFrog().getBackgroundColor());
        Mockito.verify(gui, Mockito.times(1)).drawFrog(Mockito.any(Position.class), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    void drawCars() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawCar(new Position(4, 5),"#ffffff",0);
        Mockito.verify(gui, Mockito.times(1)).drawCar(new Position(5, 6),"#000000", 1);
        Mockito.verify(gui, Mockito.times(2)).drawCar(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyInt());
    }


}
