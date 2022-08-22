package com.cambio.tipocambio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {

    @NotNull
    private Long monedaOrigen;

    @NotNull
    private Long monedaDestino;

    @NotNull
    private BigDecimal cantidad;
}
