package com.capacitacion.demo.repository;

import com.capacitacion.demo.entity.Persona;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepo extends JpaRepository<Persona, Long> {

    Persona findPersonaByCedula(String cedula);

    @Query(value = "SELECT DATE_PART('year', AGE(fecha_nacimineto)) FROM prueba.persona WHERE cedula = :cedula",
            nativeQuery = true)
    Integer getEdadByCedula(@Param("cedula") String cedula);

    List<Persona> findAllByApellido(String apellido);

}
