package com.xoquin.app_db_c_estudios.dao;

import java.sql.Connection;
import java.util.List;

public interface Dao<T> {
    T get(Connection conn, int id);
   
    List<T> getAll(Connection conn);
    //METODOS NECESARIOS
   }
