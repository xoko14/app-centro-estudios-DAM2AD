package com.xoquin.app_db_c_estudios.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xoquin.app_db_c_estudios.vo.Alumno;

public class AlumnoDAO implements Dao<Alumno> {

    @Override
    public Alumno get(Connection conn, int id) {
        Alumno al = new Alumno();
        try {
            PreparedStatement s = conn.prepareStatement("select * from alumnos where num_exp = ?");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            rs.next();
            al.setNumExp(rs.getInt("num_exp"));
            al.setDni(rs.getString("dni"));
            al.setNombre(rs.getString("nombre"));
            al.setApellidos(rs.getString("apellidos"));
            al.setFecha(rs.getDate("fecha_nac"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
    }

    @Override
    public List<Alumno> getAll(Connection conn) {
        List<Alumno> lista = new ArrayList<>();
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from alumnos");
            while (rs.next()) {
                Alumno al = new Alumno();
                al.setNumExp(rs.getInt("num_exp"));
                al.setDni(rs.getString("dni"));
                al.setNombre(rs.getString("nombre"));
                al.setApellidos(rs.getString("apellidos"));
                al.setFecha(rs.getDate("fecha_nac"));
                lista.add(al);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Alumno> getByDNI(Connection conn, String query){
        List<Alumno> lista = new ArrayList<>();
        try {
            PreparedStatement s = conn.prepareStatement("select * from alumnos where dni = ?");
            s.setString(1, query);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Alumno al = new Alumno();
                al.setNumExp(rs.getInt("num_exp"));
                al.setDni(rs.getString("dni"));
                al.setNombre(rs.getString("nombre"));
                al.setApellidos(rs.getString("apellidos"));
                al.setFecha(rs.getDate("fecha_nac"));
                lista.add(al);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Alumno> getByNombre(Connection conn, String query){
        List<Alumno> lista = new ArrayList<>();
        try {
            PreparedStatement s = conn.prepareStatement("select * from alumnos where upper(nombre) like upper(?)");
            s.setString(1, "%"+query+"%");
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Alumno al = new Alumno();
                al.setNumExp(rs.getInt("num_exp"));
                al.setDni(rs.getString("dni"));
                al.setNombre(rs.getString("nombre"));
                al.setApellidos(rs.getString("apellidos"));
                al.setFecha(rs.getDate("fecha_nac"));
                lista.add(al);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

}
