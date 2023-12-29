package com.test.jfx.view;

import com.test.jfx.EmailManager;
import com.test.jfx.Launcher;
import com.test.jfx.controller.BaseController;
import com.test.jfx.controller.LoginWindowController;
import com.test.jfx.controller.MainWindowController;
import com.test.jfx.controller.OptionsWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ViewFactory {

    private EmailManager emailManager;
    private ArrayList<Stage> activeStages;
    private boolean mainViewInitialized = false;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
        activeStages = new ArrayList<Stage>();
    }

    public boolean isMainViewInitialized(){
        return mainViewInitialized;
    }

    //View options hangling:
    private ColorTheme colorTheme = ColorTheme.DEFAULT;
    private FontSize fontSize = FontSize.MEDIUM;

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public void showLoginWindow(){
        System.out.println("show login window");

        BaseController controller = new LoginWindowController(emailManager, this,"LoginWindow.fxml");
        initializateStage(controller);

    }

    public void showMainWindow(){
        System.out.println("show main window");

        BaseController controller = new MainWindowController(emailManager, this,"MainWindow.fxml");
        initializateStage(controller);
        mainViewInitialized = true;
    }

    public void showOptionsWindow(){
        System.out.println("show options window");

        BaseController controller = new OptionsWindowController(emailManager,this,"OptionsWindow.fxml");
        initializateStage(controller);
    }

    private void initializateStage(BaseController baseController){
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (Exception e){
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        activeStages.add(stage);
    }

    public void closeStage(Stage stageToClose){
        stageToClose.close();
        activeStages.remove(stageToClose);
    }

    public void updateStyles() {
        for (Stage stage: activeStages) {
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(Launcher.class.getResource(ColorTheme.getCssPath(colorTheme)).toExternalForm());
            scene.getStylesheets().add(Launcher.class.getResource(FontSize.getCssPath(fontSize)).toExternalForm());
        }
    }
}
