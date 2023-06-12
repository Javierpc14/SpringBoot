package com.example.InicioSesion.DAO;

import com.example.InicioSesion.Modelo.Alumno;
import com.example.InicioSesion.Modelo.Usuario;

import java.util.List;

public interface UsuarioDAO {

    List<Usuario> listarUser();

    void deleteUser(int id);

    void addUser(Usuario usuario);

    Usuario findByNombreAndContrasena(String nombre, String contrasena);
}
