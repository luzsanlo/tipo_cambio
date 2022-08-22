package com.cambio.tipocambio.service;

import com.cambio.tipocambio.dto.RequestDto;
import com.cambio.tipocambio.dto.ResponseDto;
import com.cambio.tipocambio.dto.TipoCambioDto;
import com.cambio.tipocambio.entity.TipoCambio;

import java.util.List;

public interface ICambioService {
    TipoCambio guardar(TipoCambioDto dto);
    List<TipoCambio> listar();
    TipoCambio buscar(Long id);
    TipoCambio actualizar(Long id, TipoCambioDto dto);
    TipoCambio eliminar(Long id);
    ResponseDto realizarOperacion(RequestDto dto);
}
