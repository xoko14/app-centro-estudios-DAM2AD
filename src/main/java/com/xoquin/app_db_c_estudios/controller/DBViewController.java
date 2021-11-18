package com.xoquin.app_db_c_estudios.controller;

import com.xoquin.app_db_c_estudios.factory.MariaDBDAOFactory;

/**
 * Clase pai de todas as que necesiten conectarse á base de datos
 * de maneira que só haxa unha instancia de MariaDBDAOFactory.
 */
public class DBViewController {
    protected MariaDBDAOFactory db = new MariaDBDAOFactory();
}
