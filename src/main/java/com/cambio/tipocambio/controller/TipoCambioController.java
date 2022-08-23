package com.cambio.tipocambio.controller;

import com.cambio.tipocambio.dto.RequestDto;
import com.cambio.tipocambio.dto.ResponseDto;
import com.cambio.tipocambio.dto.TipoCambioDto;
import com.cambio.tipocambio.entity.TipoCambio;
import com.cambio.tipocambio.service.ICambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tipo_cambio")
public class TipoCambioController {

    @Autowired private ICambioService service;

    @GetMapping
    public ResponseEntity<List<TipoCambio>> listar() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoCambio> buscar(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscar(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TipoCambio> guardar(@Valid @RequestBody TipoCambioDto dto) {
        return new ResponseEntity<>(service.guardar(dto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoCambio> actualizar(@PathVariable Long id, @Valid @RequestBody TipoCambioDto dto) {
        return new ResponseEntity<>(service.actualizar(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoCambio> actualizar(@PathVariable Long id) {
        return new ResponseEntity<>(service.eliminar(id), HttpStatus.OK);
    }

    @PostMapping("/operacion")
    public ResponseEntity<ResponseDto> realizarCambio(@Valid @RequestBody RequestDto dto) {
        return new ResponseEntity<>(service.realizarOperacion(dto), HttpStatus.OK);
    }
}
