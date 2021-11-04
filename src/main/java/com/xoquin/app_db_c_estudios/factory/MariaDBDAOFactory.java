package com.xoquin.app_db_c_estudios.factory;

import java.sql.Connection;
import java.sql.SQLException;
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
            // TODO Auto-generated catch block
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
}
