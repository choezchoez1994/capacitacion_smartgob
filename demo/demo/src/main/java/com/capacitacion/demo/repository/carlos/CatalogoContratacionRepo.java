package com.capacitacion.demo.repository.carlos;

import com.capacitacion.demo.entity.Persona;
import com.capacitacion.demo.entity.carlos.CargaFamiliar;
import com.capacitacion.demo.entity.carlos.CatalogoContratacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatalogoContratacionRepo extends JpaRepository<CatalogoContratacion, Long> {

    boolean existsByCodigo(String codigo);
}
