package com.capacitacion.demo.repository.carlos;

import com.capacitacion.demo.entity.Persona;
import com.capacitacion.demo.entity.carlos.CargaFamiliar;
import com.capacitacion.demo.entity.carlos.ItemPac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemPacRepo extends JpaRepository<ItemPac, Long> {


    List<ItemPac> findByPeriodo(Integer anio);
}
