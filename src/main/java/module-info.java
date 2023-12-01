module com.test.jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires activation;
    requires java.mail;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.test.jfx to javafx.fxml;
    exports com.test.jfx;
    exports com.test.jfx.controller;
    opens com.test.jfx.controller to javafx.fxml;
    exports com.test.jfx.view;
    opens com.test.jfx.view to javafx.fxml;
}