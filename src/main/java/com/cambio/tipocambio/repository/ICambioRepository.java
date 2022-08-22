package com.cambio.tipocambio.repository;

import com.cambio.tipocambio.entity.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICambioRepository extends JpaRepository<TipoCambio, Long> {

    @Query("select tc from TipoCambio tc where tc.estado = true")
    List<TipoCambio> findAll();

    @Query("select tc from TipoCambio tc where tc.id = :id and tc.estado = true")
    Optional<TipoCambio> findById(@Param("id") Long id);

    @Query("select tc from TipoCambio tc where tc.monedaOrigen.id = :origen and tc.monedaDestino.id = :destino and tc.estado = true")
    Optional<TipoCambio> find(@Param("origen") Long origen, @Param("destino") Long destino);
}
