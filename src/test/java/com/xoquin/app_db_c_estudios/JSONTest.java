package com.xoquin.app_db_c_estudios;

import java.sql.SQLException;

import com.xoquin.app_db_c_estudios.factory.MariaDBDAOFactory;

import org.json.JSONObject;
import org.junit.Test;

public class JSONTest {
    private static MariaDBDAOFactory db = new MariaDBDAOFactory();

    @Test
    public void getAlumnosJSON(){
        try {
            JSONObject als = db.getAlumnoDAO().toJSON(db.getConnection());
            System.out.println(als);
            JSONObject prof = db.getProfesorDAO().toJSON(db.getConnection());
            System.out.println(prof);
            JSONObject dept = db.getDepartamentoDAO().toJSON(db.getConnection());
            System.out.println(dept);
            JSONObject asig = db.getProfesorDAO().toJSON(db.getConnection());
            System.out.println(asig);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void volcar(){
        try {
            db.volcarDB(db.getConnection(), "/home/xoquin/Documentos/Projects/app_db_c_estudios/target/volcado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
