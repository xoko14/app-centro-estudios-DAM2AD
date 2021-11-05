package com.xoquin.app_db_c_estudios.controller;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.xoquin.app_db_c_estudios.factory.MariaDBDAOFactory;
import com.xoquin.app_db_c_estudios.vo.Profesor;

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

public class BuscarProfesoresController implements Initializable{
    @FXML private Button btnInitDB;
    @FXML private TableView<Profesor> tabProfesores;
    @FXML private TableColumn<Profesor, String> colDNI;
    @FXML private TableColumn<Profesor, String> colNombre;
    @FXML private TableColumn<Profesor, String> colApellidos;
    @FXML private TableColumn<Profesor, Date> colDept;
    @FXML private ComboBox<String> cbxBuscarPor; 
    @FXML private TextField txtBusqueda;

    private MariaDBDAOFactory db = new MariaDBDAOFactory();
    private String selectedItem = null;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colDNI.setCellValueFactory(new PropertyValueFactory<Profesor, String>("dni"));
        colNombre.setCellValueFactory(new PropertyValueFactory<Profesor, String>("nombre"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<Profesor, String>("apellidos"));
        colDept.setCellValueFactory(new PropertyValueFactory<Profesor, Date>("departamento"));

        cbxBuscarPor.getItems().setAll("DNI", "Nombre", "Apellidos", "Departamento");
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
              case "DNI": findByDNI(); break;
              case "Nombre": break;
              case "Apellidos": break;
              case "Departamento": break;
            }
          }
    }

    private void findByDNI(){
        List<Profesor> profs = new ArrayList<>();
        try {
            profs = db.getProfesorDAO().getByDNI(db.getConnection(), txtBusqueda.getText());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tabProfesores.getItems().setAll(profs);
    }
}
