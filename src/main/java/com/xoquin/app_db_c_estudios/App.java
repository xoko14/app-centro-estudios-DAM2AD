package com.xoquin.app_db_c_estudios;

import com.xoquin.app_db_c_estudios.controller.MainController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/main_window.fxml"));
        MainController c = new MainController();
        loader.setController(c);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        //primaryStage.getIcons().add(new Image(getclass stuff))
        primaryStage.setTitle("DB Browser");
        primaryStage.show();
    }
}
