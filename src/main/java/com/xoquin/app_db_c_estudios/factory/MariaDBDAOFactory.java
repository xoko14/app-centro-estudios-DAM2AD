package com.xoquin.app_db_c_estudios.factory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;

import com.xoquin.app_db_c_estudios.dao.AlumnoDAO;
import com.xoquin.app_db_c_estudios.dao.AsignaturaDAO;
import com.xoquin.app_db_c_estudios.dao.DepartamentoDAO;
import com.xoquin.app_db_c_estudios.dao.ProfesorDAO;
import com.xoquin.app_db_c_estudios.pool.BasicConnectionPool;

import org.json.JSONObject;

public class MariaDBDAOFactory extends DAOFactory{
    final static String url = "jdbc:mariadb://localhost/centro_estudios";
    final static String user = "admin";
    final static String password = "1234";
    static BasicConnectionPool bcp;

    public MariaDBDAOFactory() {
        try {
            bcp = BasicConnectionPool.create(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return bcp.getConnection();
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        return bcp.releaseConnection(connection);
    }

    @Override
    public int getSize() {
        return bcp.getSize();
    }

    // add getUser, getURL....
    @Override
    public void shutdown() throws SQLException {
        bcp.shutdown();
    }

    @Override
    public AlumnoDAO getAlumnoDAO() {
        return new AlumnoDAO();
    }

    @Override
    public AsignaturaDAO getAsignaturaDAO() {
        return new AsignaturaDAO();
    }

    @Override
    public DepartamentoDAO getDepartamentoDAO() {
        return new DepartamentoDAO();
    }

    @Override
    public ProfesorDAO getProfesorDAO() {
        return new ProfesorDAO();
    }

    @Override
    public boolean createDB() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean clearDB() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean volcarDB(Connection conn, String location) {
        Writer writer;
        try {
            writer = new FileWriter(Paths.get(location, "alumnos.json").toFile());
            this.getAlumnoDAO().toJSON(conn).write(writer);
            writer.flush();
            writer.close();
            
            writer = new FileWriter(Paths.get(location.toString(), "departamentos.json").toFile());
            this.getDepartamentoDAO().toJSON(conn).write(writer);
            writer.flush();
            writer.close();

            writer = new FileWriter(Paths.get(location.toString(), "profesores.json").toFile());
            this.getProfesorDAO().toJSON(conn).write(writer);
            writer.flush();
            writer.close();

            writer = new FileWriter(Paths.get(location.toString(), "asignaturas.json").toFile());
            this.getAsignaturaDAO().toJSON(conn).write(writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean cargarVolcadoDB(Connection conn, String location) {
        String content;
        try {
            content = Files.readString(Paths.get(location, "alumnos.json"), StandardCharsets.UTF_8);
            JSONObject als = new JSONObject(content).getJSONObject("alumnos");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
