package com.xoquin.app_db_c_estudios.dao;

import java.sql.Connection;
import java.util.List;

import org.json.JSONObject;

public interface Dao<T> {
    T get(Connection conn, int id);
   
    List<T> getAll(Connection conn);

    JSONObject toJSON(Connection conn);
   }
