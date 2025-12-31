package com.capacitacion.demo.repository.jose;

import com.capacitacion.demo.entity.jose.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepo extends JpaRepository<Empleado, Long> {

    boolean existsByCorreoInstitucional(String correoInstitucional);

}
