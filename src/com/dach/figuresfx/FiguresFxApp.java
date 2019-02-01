package com.dach.figuresfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;


public class FiguresFxApp extends Application {
    private static final Logger LOGGER = Logger.getLogger(FiguresFxApp.class);
    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("FiguresFx");
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainScreenView.fxml"));
        window.setScene(new Scene(root, 1024, 600));
        window.setResizable(false);
        window.show();

    }

    public static void main(String[] args) {
        LOGGER.info("You JavaFX App started");
        launch();
    }
}
