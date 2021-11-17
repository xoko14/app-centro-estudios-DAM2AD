package com.xoquin.app_db_c_estudios.factory;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class DialogFactory {
    public static final int YES_NO_DIALOG = 1;

    public static final int RESULT_UNEXECUTED = -1;
    public static final int RESULT_NO = 0;
    public static final int RESULT_YES = 1;

    private int currentMode;

    private String text;

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private int result;

    public int getResult() {
        return result;
    }

    public DialogFactory(int mode) {
        currentMode = mode;
        result = RESULT_UNEXECUTED;
    }

    public void launch() {
        switch (currentMode) {
        case YES_NO_DIALOG:
            createAlert();
            break;
        }

        
    }

    private void createAlert(){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Alerta");
        alert.setHeaderText("Confirmar");
        alert.setContentText(text);

        Optional<ButtonType> resultB = alert.showAndWait();
        if (resultB.get() == ButtonType.OK) {
            result = RESULT_YES;
        } else {
            result = RESULT_NO;
        }
    }
}
