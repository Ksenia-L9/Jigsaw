package lainex.jigsaw.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import lainex.jigsaw.view.GameView;

public class MenuController {
    /**
     * Controls start button. Initializes game scene.
     *
     * @param parentStage main stage of application.
     * @return game scene.
     */
    public static Scene start(Stage parentStage) {
        GameController.startNewGame();
        return new Scene(new GameView(parentStage), 800, 750);
    }
}
