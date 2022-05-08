package lainex.jigsaw.view;

import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class NeonButtonSkin extends ButtonSkin {
    public NeonButtonSkin(Button button, double v, Color color) {
        super(button);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(2.0);
        dropShadow.setOffsetY(2.0);
        dropShadow.setColor(color);
        button.setEffect(dropShadow);

        button.setFont(Font.loadFont(getClass().getResourceAsStream("/Games.ttf"), v));

        Glow glow = new Glow();
        glow.setLevel(0.9);

        button.setOnMouseEntered(event -> button.setEffect(glow));
        button.setOnMouseExited(event -> button.setEffect(dropShadow));
    }
}
