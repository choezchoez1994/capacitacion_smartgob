package com.capacitacion.demo.repository.carlos;

import com.capacitacion.demo.entity.Persona;
import com.capacitacion.demo.entity.carlos.CargaFamiliar;
import com.capacitacion.demo.entity.carlos.TipoProcedimiento;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoProcedimientoRepo extends JpaRepository<TipoProcedimiento, Long> {


    boolean existsByCodigo(String codigo);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END " +
            "FROM CatalogoContratacion c " +
            "WHERE c.idCatalogoContratacion = :idCatalogo " +
            "AND c.padre.idCatalogoContratacion = :idPadre")
    boolean esHijoDePadre(@Param("idCatalogo") Long idCatalogo,
                          @Param("idPadre") int idPadre);
}
