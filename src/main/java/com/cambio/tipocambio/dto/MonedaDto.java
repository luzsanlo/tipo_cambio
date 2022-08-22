package com.cambio.tipocambio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonedaDto {

    @NotNull
    private String nombre;

    @NotNull
    private String codigo;
}
