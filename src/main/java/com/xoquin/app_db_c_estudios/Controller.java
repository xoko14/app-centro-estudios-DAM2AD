package com.xoquin.app_db_c_estudios;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.xoquin.app_db_c_estudios.factory.MariaDBDAOFactory;
import com.xoquin.app_db_c_estudios.vo.Alumno;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable {
    @FXML private Button btnInitDB;
    @FXML private TableView<Alumno> testTab;
    @FXML private TableColumn<Alumno, Integer> colNum;
    @FXML private TableColumn<Alumno, String> colDNI;
    @FXML private TableColumn<Alumno, String> colNombre;
    @FXML private TableColumn<Alumno, String> colApellidos;
    @FXML private TableColumn<Alumno, Date> colNac;
    private MariaDBDAOFactory db = new MariaDBDAOFactory();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colNum.setCellValueFactory(new PropertyValueFactory<Alumno, Integer>("numExp"));
        colDNI.setCellValueFactory(new PropertyValueFactory<Alumno, String>("dni"));
        colNombre.setCellValueFactory(new PropertyValueFactory<Alumno, String>("nombre"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<Alumno, String>("apellidos"));
        colNac.setCellValueFactory(new PropertyValueFactory<Alumno, Date>("fecha"));
    }

    @FXML
    private void doStuff(ActionEvent ae){
        List<Alumno> als = new ArrayList<>();

        try {
            als = db.getAlumnoDAO().getAll(db.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        testTab.getItems().setAll(als);
    }
}
