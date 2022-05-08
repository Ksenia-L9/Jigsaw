package lainex.jigsaw.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import lainex.jigsaw.model.BlockGenerator;
import lainex.jigsaw.model.Game;
import lainex.jigsaw.view.GameOverView;

public class GameController {
    /**
     * Instance of game.
     */
    private static Game game;

    /**
     * Initializes new game.
     */
    public static void startNewGame() {
        game = new Game();
    }

    /**
     * Hands over the block to set to the field.
     *
     * @param block block to be set.
     * @param newX  coordinate X, where to set.
     * @param newY  coordinate Y, where to set.
     * @return true if block was set, else false.
     */
    public boolean trySetBlock(boolean[][] block, int newX, int newY) {
        return game.trySet(block, newX, newY);
    }

    /**
     * Gets the field from Game class.
     *
     * @return container of playing field.
     */
    public boolean[][] getField() {
        return game.getField();
    }

    /**
     * Gets new random block.
     *
     * @return container of block.
     */
    public boolean[][] getRandomBlock() {
        return BlockGenerator.generateBlock();
    }

    /**
     * Initializes a new scene, after game ends.
     *
     * @param parentStage main stage if application.
     * @return scene when game is over.
     */
    public Scene end(Stage parentStage) {
        return new Scene(new GameOverView(parentStage), 700, 400);
    }

    /**
     * Gets number of moves done by player in the game.
     *
     * @return string representing number of moves.
     */
    public static String getMovesCount() {
        return game.getMoves().toString();
    }

    /**
     * Sets game time.
     *
     * @param time string representing game time.
     */
    public static void setTimePassed(String time) {
        game.setTime(time);
    }

    /**
     * Gets game time.
     *
     * @return string representing game time.
     */
    public static String getTimePassed() {
        return game.getTime();
    }
}
