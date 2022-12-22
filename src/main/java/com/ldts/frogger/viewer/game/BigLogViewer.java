package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.BigLog;

public class BigLogViewer implements ElementViewer<BigLog> {

    @Override
    public void draw(BigLog bigLog, GUI gui) {
        gui.drawText(bigLog.getPosition(), "ooo", "#523715", "#624219");
    }
}
