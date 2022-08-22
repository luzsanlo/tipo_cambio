package com.cambio.tipocambio.repository;

import com.cambio.tipocambio.entity.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMonedaRepository extends JpaRepository<Moneda, Long> {

    @Query("select m from Moneda m where m.estado = true")
    List<Moneda> findAll();

    @Query("select m from Moneda m where m.id = :id and m.estado = true")
    Optional<Moneda> findById(@Param("id") Long id);
}
