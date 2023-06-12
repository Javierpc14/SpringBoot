package com.example.InicioSesion.DAO;

import com.example.InicioSesion.Modelo.Alumno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class AlumnosDAOimp implements AlumnosDAO{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Alumno> listarAlumno() {
        String query = "FROM Alumno";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteAlumno(int id) {
        Alumno alumno = entityManager.find(Alumno.class,id);
        entityManager.remove(alumno);

    }

    @Override
    public void addAlumno(Alumno alumno) {
        entityManager.merge(alumno);
    }
}
