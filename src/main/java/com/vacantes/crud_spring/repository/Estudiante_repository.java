package com.vacantes.crud_spring.repository;

import com.vacantes.crud_spring.model.Estudiante_model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface Estudiante_repository extends CrudRepository<Estudiante_model,Long> {
    public abstract ArrayList<Estudiante_model> findByDni( String dni);
}
