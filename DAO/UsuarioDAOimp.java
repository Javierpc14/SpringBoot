package com.example.InicioSesion.DAO;

import com.example.InicioSesion.Modelo.Alumno;
import com.example.InicioSesion.Modelo.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class UsuarioDAOimp implements UsuarioDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> listarUser() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteUser(int id) {
        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);

    }

    @Override
    public void addUser(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public Usuario findByNombreAndContrasena(String nombre, String contrasena) {
        return entityManager.createQuery("SELECT usuario FROM Usuario usuario WHERE usuario.nombre = :nombre AND usuario.contrasena = :contrasena", Usuario.class)
                .setParameter("nombre", nombre)
                .setParameter("contrasena", contrasena)
                .getSingleResult();
    }

}
