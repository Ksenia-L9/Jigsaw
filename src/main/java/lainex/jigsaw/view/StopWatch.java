package lainex.jigsaw.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.effect.Glow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class StopWatch extends HBox {
    private final Text time;
    private Integer minutes;
    private Integer seconds;
    private Timeline timeline;

    public StopWatch() {
        super();
        setAlignment(Pos.CENTER);

        minutes = 0;
        seconds = 0;

        Glow glow = new Glow();
        glow.setLevel(0.6);

        time = new Text();
        time.setFont(Font.loadFont(getClass().getResourceAsStream("/Games.ttf"), 35));
        time.setFill(Paint.valueOf("#00ffff"));
        time.setEffect(glow);

        setTime();

        getChildren().add(time);
    }

    public void setTime() {
        if (seconds == 60) {
            ++minutes;
            seconds = 0;
        }

        String m = minutes >= 10 ? minutes.toString() : "0" + minutes;
        String s = seconds >= 10 ? seconds.toString() : "0" + seconds;

        time.setText(m + ":" + s);
    }

    public Text getTime() {
        return time;
    }

    public void start() {
        KeyFrame frame = new KeyFrame(Duration.millis(1000), e -> {
            ++seconds;
            setTime();
        });

        timeline = new Timeline(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void stop() {
        timeline.stop();
    }
}
