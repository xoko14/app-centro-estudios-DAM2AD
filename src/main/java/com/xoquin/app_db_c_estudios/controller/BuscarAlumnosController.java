package com.xoquin.app_db_c_estudios.controller;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.xoquin.app_db_c_estudios.factory.MariaDBDAOFactory;
import com.xoquin.app_db_c_estudios.vo.Alumno;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BuscarAlumnosController implements Initializable{
    @FXML private Button btnInitDB;
    @FXML private TableView<Alumno> tabAlumnos;
    @FXML private TableColumn<Alumno, Integer> colNum;
    @FXML private TableColumn<Alumno, String> colDNI;
    @FXML private TableColumn<Alumno, String> colNombre;
    @FXML private TableColumn<Alumno, String> colApellidos;
    @FXML private TableColumn<Alumno, Date> colNac;
    @FXML private ComboBox<String> cbxBuscarPor; 
    @FXML private TextField txtBusqueda;

    private MariaDBDAOFactory db = new MariaDBDAOFactory();
    private String selectedItem = null;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colNum.setCellValueFactory(new PropertyValueFactory<Alumno, Integer>("numExp"));
        colDNI.setCellValueFactory(new PropertyValueFactory<Alumno, String>("dni"));
        colNombre.setCellValueFactory(new PropertyValueFactory<Alumno, String>("nombre"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<Alumno, String>("apellidos"));
        colNac.setCellValueFactory(new PropertyValueFactory<Alumno, Date>("fecha"));

        cbxBuscarPor.getItems().setAll("ID", "DNI", "Nombre", "Apellidos", "Fecha de nacimiento");
        cbxBuscarPor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldI, String newI) {
              selectedItem = newI;
            }
          });
    }

    @FXML
    private void buscar(ActionEvent ae){
        if (selectedItem != null) {
            switch(selectedItem) {
              case "ID": findByID(); break;
              case "DNI": break;
              case "Nombre": break;
              case "Apellidos": break;
              case "Fecha de nacimiento": break;
            }
          }
    }

    private void findByID(){
        int id = Integer.parseInt(txtBusqueda.getText());
        List<Alumno> als = new ArrayList<>();
        try {
            als.add(db.getAlumnoDAO().get(db.getConnection(), id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tabAlumnos.getItems().setAll(als);
    }
}
