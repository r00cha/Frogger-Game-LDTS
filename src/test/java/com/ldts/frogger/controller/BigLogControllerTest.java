package com.ldts.frogger.controller;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.game.BigLogController;
import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigLogControllerTest {
    private BigLogController controller;
    private Frog frog;
    private Arena arena;
    private Game game;
    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        arena.setWaters(Arrays.asList(new Water(5,5), new Water(6,5), new Water(7,5), new Water(8,5), new Water(9,5)));
        controller = new BigLogController(arena);
        game = Mockito.mock(Game.class);
    }

    @Test
    void FrogLeftLog1() throws IOException {
        MusicManager manager= Mockito.mock(MusicManager .class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            BigLog bigLog = new BigLog(new Position(5, 5), 1);
            arena.setBigLogs(List.of(bigLog));
            frog = new Frog(5, 5);
            arena.setFrog(frog);
            controller.step(game, GUI.ACTION.NONE, 1000);
            assertEquals(new Position(6, 5), bigLog.getPosition());
            assertEquals(new Position(6, 5), frog.getPosition());
        }
    }

    @Test
    void FrogMiddleLog1() throws IOException {
        MusicManager manager= Mockito.mock(MusicManager .class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            BigLog bigLog = new BigLog(new Position(5, 5), 1);
            arena.setBigLogs(List.of(bigLog));
            frog = new Frog(6, 5);
            arena.setFrog(frog);
            controller.step(game, GUI.ACTION.NONE, 1000);
            assertEquals(new Position(6, 5), bigLog.getPosition());
            assertEquals(new Position(7, 5), frog.getPosition());
        }
    }

    @Test
    void FrogEndLog1() throws IOException {
        MusicManager manager= Mockito.mock(MusicManager .class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            BigLog bigLog = new BigLog(new Position(5, 5), 1);
            arena.setBigLogs(List.of(bigLog));
            frog = new Frog(7, 5);
            arena.setFrog(frog);
            controller.step(game, GUI.ACTION.NONE, 1000);
            assertEquals(new Position(6, 5), bigLog.getPosition());
            assertEquals(new Position(8, 5), frog.getPosition());
        }
    }

    @Test
    void FrogLeftLog0() throws IOException {
        MusicManager manager= Mockito.mock(MusicManager .class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            BigLog bigLog = new BigLog(new Position(5, 5), 0);
            arena.setBigLogs(List.of(bigLog));
            frog = new Frog(5, 5);
            arena.setFrog(frog);
            controller.step(game, GUI.ACTION.NONE, 1000);
            assertEquals(new Position(4, 5), bigLog.getPosition());
            assertEquals(new Position(4, 5), frog.getPosition());
        }
    }

    @Test
    void FrogMiddleLog0() throws IOException {
        MusicManager manager= Mockito.mock(MusicManager .class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            BigLog bigLog = new BigLog(new Position(5, 5), 0);
            arena.setBigLogs(List.of(bigLog));
            frog = new Frog(6, 5);
            arena.setFrog(frog);
            controller.step(game, GUI.ACTION.NONE, 1000);
            assertEquals(new Position(4, 5), bigLog.getPosition());
            assertEquals(new Position(5, 5), frog.getPosition());
        }
    }

    @Test
    void FrogEndLog0() throws IOException {
        MusicManager manager= Mockito.mock(MusicManager .class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            BigLog bigLog = new BigLog(new Position(5, 5), 0);
            arena.setBigLogs(List.of(bigLog));
            frog = new Frog(7, 5);
            arena.setFrog(frog);
            controller.step(game, GUI.ACTION.NONE, 1000);
            assertEquals(new Position(4, 5), bigLog.getPosition());
            assertEquals(new Position(6, 5), frog.getPosition());
        }
    }

    @Test
    void LogReset0() throws IOException {
        MusicManager manager= Mockito.mock(MusicManager .class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            BigLog bigLog = new BigLog(new Position(-1, 5), 0);
            arena.setBigLogs(List.of(bigLog));
            frog = new Frog(1, 5);
            arena.setFrog(frog);
            controller.step(game, GUI.ACTION.NONE, 1000);
            assertEquals(new Position(9, 5), bigLog.getPosition());
        }
    }

    @Test
    void LogReset1() throws IOException {
        MusicManager manager= Mockito.mock(MusicManager .class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            BigLog bigLog = new BigLog(new Position(9, 5), 1);
            arena.setBigLogs(List.of(bigLog));
            frog = new Frog(10, 5);
            arena.setFrog(frog);
            controller.step(game, GUI.ACTION.NONE, 1000);
            assertEquals(new Position(-1, 5), bigLog.getPosition());
        }
    }
}
