package com.cambio.tipocambio.service;


import com.cambio.tipocambio.dto.MonedaDto;
import com.cambio.tipocambio.entity.Moneda;

import java.util.List;

public interface IMonedaService {
    Moneda guardar(MonedaDto dto);
    List<Moneda> listar();
    Moneda buscar(Long id);
    Moneda actualizar(Long id, MonedaDto dto);
    Moneda eliminar(Long id);
}
