package com.example.InicioSesion.Controller;

import com.example.InicioSesion.DAO.AlumnosDAO;
import com.example.InicioSesion.DAO.UsuarioDAO;
import com.example.InicioSesion.Modelo.Alumno;
import com.example.InicioSesion.Modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class Controlador {

    @Autowired
    AlumnosDAO alumnosDAO;
    @Autowired
    UsuarioDAO usuarioDAO;

    @GetMapping("/listarAlumno")
    public List<Alumno> listarAlumno() {return alumnosDAO.listarAlumno();}

    @GetMapping("/listarUser")
    public List<Usuario> listarUser() {return usuarioDAO.listarUser();}

    @DeleteMapping("/eliminarAlumno/{id}")
    public void delete(@PathVariable int id){
        alumnosDAO.deleteAlumno(id);
    }

    @PostMapping("/añadirAlumno")
    public void add(@RequestBody Alumno alumno){
        alumnosDAO.addAlumno(alumno);
    }

    @PostMapping("/añadirUser")
    public void add(@RequestBody Usuario usuario){
        usuarioDAO.addUser(usuario);
    }

    @PostMapping("/login")
    public RedirectView login(@RequestParam("nombre") String username, @RequestParam("password") String password) {
        Usuario usuario = usuarioDAO.findByNombreAndContrasena(username, password);

        if (usuario != null) {
            return new RedirectView("/alumno.html");
        } else {
            return new RedirectView("/index.html");
        }
    }

}
