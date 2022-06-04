module com.example.aimsprojectjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens AimsProject.main to javafx.fxml;
    exports AimsProject.main;

    opens AimsProject.aims.media to javafx.base;
    exports AimsProject.aims.media;

    opens AimsProject.aims.disc.track to javafx.base;
    exports AimsProject.aims.disc.track;
}