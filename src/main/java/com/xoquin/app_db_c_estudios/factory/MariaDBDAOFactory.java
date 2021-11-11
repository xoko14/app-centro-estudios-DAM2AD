package com.xoquin.app_db_c_estudios.factory;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

import com.xoquin.app_db_c_estudios.dao.AlumnoDAO;
import com.xoquin.app_db_c_estudios.dao.AsignaturaDAO;
import com.xoquin.app_db_c_estudios.dao.DepartamentoDAO;
import com.xoquin.app_db_c_estudios.dao.ProfesorDAO;
import com.xoquin.app_db_c_estudios.pool.BasicConnectionPool;

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
    public boolean volcarDB(URL location) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean cargarVolcadoDB(URL location) {
        // TODO Auto-generated method stub
        return false;
    }
}
