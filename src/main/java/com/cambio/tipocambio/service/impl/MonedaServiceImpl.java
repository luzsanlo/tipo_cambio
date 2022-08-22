package com.cambio.tipocambio.service.impl;

import com.cambio.tipocambio.dto.MonedaDto;
import com.cambio.tipocambio.entity.Moneda;
import com.cambio.tipocambio.repository.IMonedaRepository;
import com.cambio.tipocambio.service.IMonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MonedaServiceImpl implements IMonedaService {

    @Autowired
    public IMonedaRepository repo;

    @Override
    public Moneda guardar(MonedaDto dto) {
        Moneda moneda = new Moneda();
        moneda.setCodigo(dto.getCodigo());
        moneda.setNombre(dto.getNombre());
        moneda.setFechaCreacion(new Date());
        moneda.setEstado(Boolean.TRUE);

        return repo.save(moneda);
    }

    @Override
    public List<Moneda> listar() {
        return repo.findAll();
    }

    @Override
    public Moneda buscar(Long id) {
       Optional<Moneda> moneda = repo.findById(id);
       if(moneda.isEmpty()) {
           throw new IllegalArgumentException("La moneda con id [" + id + "], no existe.");
       }
       return moneda.get();
    }

    @Override
    public Moneda actualizar(Long id, MonedaDto dto) {
        Moneda moneda = buscar(id);
        moneda.setNombre(dto.getNombre());
        moneda.setCodigo(dto.getCodigo());
        moneda.setFechaActualizacion(new Date());

        return repo.save(moneda);
    }

    @Override
    public Moneda eliminar(Long id) {
        Moneda moneda = buscar(id);
        moneda.setFechaActualizacion(new Date());
        moneda.setEstado(Boolean.FALSE);

        return repo.save(moneda);
    }
}
