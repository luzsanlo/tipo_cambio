package com.cambio.tipocambio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private String monedaOrigen;

    private String monedaDestino;

    private BigDecimal cantidad;

    private BigDecimal resultado;
}
