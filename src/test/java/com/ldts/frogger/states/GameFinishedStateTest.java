package com.ldts.frogger.states;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.game.ArenaController;
import com.ldts.frogger.controller.menu.GameFinishedController;
import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.gui.LanternaGUI;
import com.ldts.frogger.model.menu.GameFinished;
import com.ldts.frogger.viewer.game.GameViewer;
import com.ldts.frogger.viewer.menu.GameFinishedViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameFinishedStateTest {
    private Game game;
    private GameFinished menu;
    private LanternaGUI gui;
    private GameFinishedController controller;

    @BeforeEach
    void setUp() {
        MusicManager manager1 = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager1);
            menu = new GameFinished(true);
            gui = Mockito.mock(LanternaGUI.class);
            game = new Game(gui);
            game.setState(new GameFinishedState(menu));
            controller = new GameFinishedController(menu);
        }
    }

    @Test
    void testMenuStateViewer() {
        assertTrue(game.getState().getViewer() instanceof GameFinishedViewer);
    }

    @Test
    void testMenuStateController() {
        assertTrue(game.getState().getController() instanceof GameFinishedController);
    }

    @Test
    void changeState() throws IOException {
        MusicManager manager1 = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager1);
            controller.step(game, GUI.ACTION.SELECT, 300);
            assertTrue(game.getState().getController() instanceof ArenaController && game.getState().getViewer() instanceof GameViewer);
        }
    }

    @Test
    void getModel() {
        assertTrue(game.getState().getModel() instanceof GameFinished);
    }

    @Test
    void entries() {
        assertEquals(3, menu.getNumberEntries());
        assertEquals("TRY AGAIN", menu.getEntry(0));
        assertEquals("ADD RECORD", menu.getEntry(1));
        assertEquals("EXIT", menu.getEntry(2));
    }
}
