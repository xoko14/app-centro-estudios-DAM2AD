package com.xoquin.app_db_c_estudios.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xoquin.app_db_c_estudios.vo.Asignatura;

public class AsignaturaDAO implements Dao<Asignatura> {

    @Override
    public Asignatura get(Connection conn, int id) {
        Asignatura asig = new Asignatura();
        try {
            PreparedStatement s = conn.prepareStatement("select * from asignaturas where id = ?");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            rs.next();
            asig.setId(rs.getInt("id"));
            asig.setNombre(rs.getString("nombre"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asig;
    }

    @Override
    public List<Asignatura> getAll(Connection conn) {
        List<Asignatura> lista = new ArrayList<>();
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from asiganturas");
            while (rs.next()) {
                Asignatura asig = new Asignatura();
                asig.setId(rs.getInt("id"));
                asig.setNombre(rs.getString("nombre"));
                lista.add(asig);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Asignatura> getByName(Connection conn, String query){
        List<Asignatura> lista = new ArrayList<>();
        try {
            PreparedStatement s = conn.prepareStatement("select * from asignaturas where upper(nombre) like upper(?)");
            s.setString(1, "%"+query+"%");
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Asignatura asig = new Asignatura();
                asig.setId(rs.getInt("id"));
                asig.setNombre(rs.getString("nombre"));
                lista.add(asig);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Asignatura> getByProfesor(Connection conn, String query){
        List<Asignatura> lista = new ArrayList<>();
        try {
            PreparedStatement s = conn.prepareStatement("select * from asignaturas asi inner join imparten i on asi.id = i.asignatura inner join profesores p on i.profesor = p.id where p.dni = ? group by asi.id");
            s.setString(1, query);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Asignatura asig = new Asignatura();
                asig.setId(rs.getInt("id"));
                asig.setNombre(rs.getString("nombre"));
                lista.add(asig);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}
