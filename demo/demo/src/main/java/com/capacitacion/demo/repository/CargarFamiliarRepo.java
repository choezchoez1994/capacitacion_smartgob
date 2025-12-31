package com.capacitacion.demo.repository;

import com.capacitacion.demo.entity.CargaFamiliar;
import com.capacitacion.demo.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CargarFamiliarRepo extends JpaRepository<CargaFamiliar, Long> {

    boolean existsByEmpleadoAndCarga(Persona empleado, Persona carga);

    Optional<CargaFamiliar> findByEmpleadoAndCarga(Persona empleado, Persona carga);
}
