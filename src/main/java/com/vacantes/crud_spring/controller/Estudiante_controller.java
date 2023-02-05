package com.vacantes.crud_spring.controller;

import com.vacantes.crud_spring.model.Estudiante_model;
import com.vacantes.crud_spring.service.Estudiante_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/estudiantes")
public class Estudiante_controller {
    @Autowired
    Estudiante_service estudiante_service;

    @GetMapping()
    public ArrayList<Estudiante_model> listar_todos(){
        return estudiante_service.getAll();
    }

    @GetMapping(path = "/{id}")  //poir aqui podemos pasar datos dinamicos via url
    public Optional<Estudiante_model> consultar_por_id(@PathVariable("id") Long id){
        return estudiante_service.get(id);
    }

    @GetMapping(path = "/consultar")  //poir aqui podemos pasar datos dinamicos via url
    public ArrayList<Estudiante_model> consultar_por_dni(@RequestParam("dni") String dni){
        return estudiante_service.getByDni(dni);
    }


    //CONTROLASDOR PPARA GUARDAR (muy importante especificar el requestBody que es el cuerpo de la solicitud via postman)
    @PostMapping()
    public Estudiante_model registrar(@RequestBody Estudiante_model e){
        return estudiante_service.save(e);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Long id){
        boolean res = estudiante_service.delete(id);
        Map datos = new HashMap<>();
        if(!res){

            datos.put("mensaje","el id:"+id + " No existen en los registros");
            datos.put("respuesta", res);
        }else {

            datos.put("mensaje","Datos eliminados con exito");
            datos.put("respuesta", res);
        }


        return  new ResponseEntity<Object>(datos, HttpStatus.OK);

    }
}
