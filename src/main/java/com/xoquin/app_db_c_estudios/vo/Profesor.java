package com.xoquin.app_db_c_estudios.vo;

public class Profesor {
    private int id;
    private String dni;
    private String nombre;
    private String apellidos;
    private int idDept;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getIdDept() {
        return this.idDept;
    }

    public void setIdDept(int idDept) {
        this.idDept = idDept;
    }

}
