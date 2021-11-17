package com.xoquin.app_db_c_estudios.controller;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import com.xoquin.app_db_c_estudios.util.ExceptionHandler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

public class CrearAlumnosController extends DBViewController{
    @FXML TextField txtDNI;
    @FXML TextField txtNome;
    @FXML TextField txtApelidos;
    @FXML DatePicker data;
    @FXML Button btnAlta;
    @FXML ProgressIndicator prgStatus;

    private DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @FXML
    private void darAlta(ActionEvent ae){
        boolean result;

        prgStatus.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
        prgStatus.setVisible(true);

        String dni = txtDNI.getText();
        String nombre = txtNome.getText();
        String apellidos = txtApelidos.getText();
        String fecha = data.getValue().format(format);

        try {
            result = db.getAlumnoDAO().newAlumno(db.getConnection(), dni, nombre, apellidos, fecha);
        } catch (SQLException e) {
            ExceptionHandler.handle(e);
            result = false;
        }

        if(result){
            prgStatus.setProgress(1);
        }
        else{
            //failed :(
            System.out.println("Failed");
        }
    }
}
