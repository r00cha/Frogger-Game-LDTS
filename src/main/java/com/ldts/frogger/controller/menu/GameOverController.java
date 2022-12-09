package com.ldts.frogger.controller.menu;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.Controller;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.arena.LoaderArenaBuilder;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.model.menu.GameOver;
import com.ldts.frogger.model.menu.LeaderboardDisplay;
import com.ldts.frogger.model.menu.Menu;
import com.ldts.frogger.states.GameState;
import com.ldts.frogger.states.LeaderboardState;
import com.ldts.frogger.states.MenuState;


import java.io.IOException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case QUIT:
                game.setState(new MenuState(new Menu()));
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()){
                    game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
                    Arena.setPoints(0);
                    Frog.setLives(3);
                }
        }
    }
}