package com.xoquin.app_db_c_estudios;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colNum.setCellValueFactory(new PropertyValueFactory<Alumno, Integer>("numExp"));
    }

    @FXML
    private void doStuff(ActionEvent ae){
        System.out.println("stuff happens");
        btnInitDB.setText("clickado");
        Alumno al = new Alumno();
        al.setNumExp(70);
        Alumno al2 = new Alumno();
        al.setNumExp(22);
        List<Alumno> als = new ArrayList<>();
        als.add(al);
        als.add(al2);
        testTab.getItems().setAll(als);
    }
}
