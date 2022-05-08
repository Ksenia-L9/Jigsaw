module lainex.jigsaw.jigsaw {
    requires javafx.controls;

    requires org.kordamp.bootstrapfx.core;

    opens lainex.jigsaw.app to javafx.fxml;
    exports lainex.jigsaw.app;
}