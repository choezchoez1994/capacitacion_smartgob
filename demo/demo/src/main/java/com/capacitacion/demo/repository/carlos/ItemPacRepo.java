package com.capacitacion.demo.repository.carlos;

import com.capacitacion.demo.entity.Persona;
import com.capacitacion.demo.entity.carlos.CargaFamiliar;
import com.capacitacion.demo.entity.carlos.ItemPac;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemPacRepo extends JpaRepository<ItemPac, Long> {


    List<ItemPac> findByPeriodo(Integer anio);

    List<ItemPac> findByEstado(String estado);

    @Query("SELECT p " +
            "FROM ItemPac p " +
            "WHERE p.periodo = :periodo " +
            "AND p.estado = :estado")
    List<ItemPac>  obtenerPorPeriodoYEstado(@Param("periodo") int periodo,
                          @Param("estado") String estado);
}
