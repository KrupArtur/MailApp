package com.test.jfx;

import com.test.jfx.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;


public class Launcher extends Application {

    public void start(Stage stage) throws IOException {
        ViewFactory viewFactory = new ViewFactory(new EmailManager());
        viewFactory.showLoginWindow();
        viewFactory.updateStyles();


    }

    public static void main(String[] args) {
        launch();
    }

}