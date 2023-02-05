package com.vacantes.crud_spring.service;

import com.vacantes.crud_spring.model.Estudiante_model;
import com.vacantes.crud_spring.repository.Estudiante_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class Estudiante_service {
    //INSTANCIAR AUTOMATICAMENTE MENOS EN DONDE YTO LE DIGA
    @Autowired
    Estudiante_repository estudiante_repository;

    //LISTAR TODOS LOS ESTUDIANTES
    public ArrayList<Estudiante_model> getAll(){
        return  (ArrayList<Estudiante_model>) estudiante_repository.findAll();
    }
    public ArrayList<Estudiante_model> getByDni(String dni){
        return estudiante_repository.findByDni(dni);
    }
    public Optional<Estudiante_model> get(Long id){
        return estudiante_repository.findById(id);
    }
    //GUARDAR UN ESTUDIANTE
    public Estudiante_model save(Estudiante_model e){
        return estudiante_repository.save(e);
    }
    // ELIMINAR ESTUIDIANTE
    public boolean delete(Long id){
        try {
            estudiante_repository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
