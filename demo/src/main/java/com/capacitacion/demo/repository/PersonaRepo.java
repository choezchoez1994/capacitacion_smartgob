package com.capacitacion.demo.repository;

import com.capacitacion.demo.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepo extends JpaRepository<Persona, Long> {

    Persona findPersonaByCedula(String cedula);

    List<Persona> findAllByApellido(String apellido);

}
