package lainex.jigsaw.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import lainex.jigsaw.view.MenuView;

public class MenuButtonController {
    /**
     * Controls menu button.
     *
     * @param parentStage main stage of application.
     * @return menu scene.
     */
    public static Scene menu(Stage parentStage) {
        return new Scene(new MenuView(parentStage), 800, 500);
    }
}
