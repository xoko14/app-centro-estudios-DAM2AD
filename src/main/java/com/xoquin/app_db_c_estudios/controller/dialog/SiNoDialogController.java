package com.xoquin.app_db_c_estudios.controller.dialog;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class SiNoDialogController extends DialogController implements Initializable{
    private String text;

    @FXML Label texto;

    public SiNoDialogController(String text){
        this.text = text;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        texto.setText(text);
    }
}
