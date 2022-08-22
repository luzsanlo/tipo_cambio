package com.cambio.tipocambio.controller;

import com.cambio.tipocambio.dto.MonedaDto;
import com.cambio.tipocambio.entity.Moneda;
import com.cambio.tipocambio.service.IMonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/moneda")
public class MonedaController {

    @Autowired private IMonedaService service;

    @GetMapping
    public ResponseEntity<List<Moneda>> listar() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moneda> buscar(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscar(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Moneda> guardar(@Valid @RequestBody MonedaDto dto) {
        return new ResponseEntity<>(service.guardar(dto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Moneda> actualizar(@PathVariable Long id, @Valid @RequestBody MonedaDto dto) {
        return new ResponseEntity<>(service.actualizar(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Moneda> actualizar(@PathVariable Long id) {
        return new ResponseEntity<>(service.eliminar(id), HttpStatus.OK);
    }
}
