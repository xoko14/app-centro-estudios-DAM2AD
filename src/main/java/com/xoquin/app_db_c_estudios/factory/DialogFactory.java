package com.xoquin.app_db_c_estudios.factory;

import java.io.IOException;

import com.xoquin.app_db_c_estudios.controller.dialog.DialogController;
import com.xoquin.app_db_c_estudios.controller.dialog.SiNoDialogController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DialogFactory {
    public static final int SI_NO_DIALOG = 1;

    private int currentMode;
    private String location;
    private DialogController dc;

    private String text;

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public DialogFactory(int mode){
        currentMode = mode;
    }

    public void launch(){
        switch(currentMode){
            case SI_NO_DIALOG:
            location = "/fxml/yes_no_alert.fxml";
            dc = new SiNoDialogController(text);
            break;
        }


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(location));
        loader.setController(dc);
        Parent root;
        try {
            root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
