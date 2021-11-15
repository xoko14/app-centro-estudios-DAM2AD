package com.xoquin.app_db_c_estudios.dao;

import java.sql.Connection;
import java.util.List;

import com.xoquin.app_db_c_estudios.dao.ImpartenDAO.Imparten;

import org.json.JSONArray;
import org.json.JSONObject;

public class ImpartenDAO implements Dao<Imparten> {

    @Override
    public Imparten get(Connection conn, int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Imparten> getAll(Connection conn) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JSONObject toJSON(Connection conn) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void batchInsert(Connection conn, List<Imparten> list) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Imparten> getJSON(JSONArray arr) {
        // TODO Auto-generated method stub
        return null;
    }

    class Imparten {
        private int profesor;
        private int asignatura;
        private int alumno;
        private int curso;

        public int getProfesor() {
            return this.profesor;
        }

        public void setProfesor(int profesor) {
            this.profesor = profesor;
        }

        public int getAsignatura() {
            return this.asignatura;
        }

        public void setAsignatura(int asignatura) {
            this.asignatura = asignatura;
        }

        public int getAlumno() {
            return this.alumno;
        }

        public void setAlumno(int alumno) {
            this.alumno = alumno;
        }

        public int getCurso() {
            return this.curso;
        }

        public void setCurso(int curso) {
            this.curso = curso;
        }

        public Imparten() {
        }
    }
}
