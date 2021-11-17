package com.xoquin.app_db_c_estudios.controller;

import java.io.File;

import com.xoquin.app_db_c_estudios.factory.DialogFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class DangerZoneController extends DBViewController {
    @FXML Button btnInicializar;
    @FXML Button btnBorrar;
    @FXML Button btnSeleccionar;
    @FXML Button btnVolcar;
    @FXML Button btnCargarVolcado;
    @FXML TextField txtVolcadoFolder;

    @FXML
    public void seleccionarCarpeta(ActionEvent ae) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Selecciona carpeta para volcado");
        File defaultDirectory = new File("./");
        chooser.setInitialDirectory(defaultDirectory);
        Stage stage = new Stage();
        File selectedDirectory = chooser.showDialog(stage);
        if(selectedDirectory != null) txtVolcadoFolder.setText(selectedDirectory.toPath().toString());
    }

    @FXML
    public void borrar(ActionEvent ae){
        DialogFactory df = new DialogFactory(DialogFactory.YES_NO_DIALOG);
        df.setText("De verdad quieres borrar la base de datos?");
        df.launch();
        if(df.getResult() == DialogFactory.RESULT_YES){
            System.out.println("borrando");
        }
    }
}
