package com.example.InicioSesion.DAO;

import com.example.InicioSesion.Modelo.Alumno;

import java.util.List;

public interface AlumnosDAO {

    List<Alumno> listarAlumno();

    void deleteAlumno(int id);

    void addAlumno(Alumno alumno);

}
