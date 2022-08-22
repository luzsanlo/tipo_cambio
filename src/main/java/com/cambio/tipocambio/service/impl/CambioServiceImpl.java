package com.cambio.tipocambio.service.impl;

import com.cambio.tipocambio.dto.RequestDto;
import com.cambio.tipocambio.dto.ResponseDto;
import com.cambio.tipocambio.dto.TipoCambioDto;
import com.cambio.tipocambio.entity.TipoCambio;
import com.cambio.tipocambio.repository.ICambioRepository;
import com.cambio.tipocambio.service.ICambioService;
import com.cambio.tipocambio.service.IMonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CambioServiceImpl implements ICambioService {

    @Autowired
    public ICambioRepository repo;

    @Autowired
    private IMonedaService monedaService;

    @Override
    public TipoCambio guardar(TipoCambioDto dto) {
        TipoCambio tc = new TipoCambio();
        tc.setMonedaOrigen(monedaService.buscar(dto.getMonedaOrigen()));
        tc.setMonedaDestino(monedaService.buscar(dto.getMonedaDestino()));
        tc.setFactor(dto.getFactor());
        tc.setFechaCreacion(new Date());
        tc.setEstado(Boolean.TRUE);

        return repo.save(tc);
    }

    @Override
    public List<TipoCambio> listar() {
        return repo.findAll();
    }

    @Override
    public TipoCambio buscar(Long id) {
        Optional<TipoCambio> tc = repo.findById(id);
        if(tc.isEmpty()) {
            throw new IllegalArgumentException("El tipo de cambio con id [" + id + "], no existe.");
        }
        return tc.get();
    }

    @Override
    public TipoCambio actualizar(Long id, TipoCambioDto dto) {
        TipoCambio tc = buscar(id);
        tc.setMonedaOrigen(monedaService.buscar(dto.getMonedaOrigen()));
        tc.setMonedaDestino(monedaService.buscar(dto.getMonedaDestino()));
        tc.setFactor(dto.getFactor());
        tc.setFechaActualizacion(new Date());

        return repo.save(tc);
    }

    @Override
    public TipoCambio eliminar(Long id) {
        TipoCambio tc = buscar(id);
        tc.setFechaActualizacion(new Date());
        tc.setEstado(Boolean.FALSE);

        return repo.save(tc);
    }

    @Override
    public ResponseDto realizarOperacion(RequestDto dto) {
        Optional<TipoCambio> tc = repo.find(dto.getMonedaOrigen(), dto.getMonedaDestino());
        if(tc.isEmpty()) {
            throw new IllegalArgumentException("El tipo de cambio no existe.");
        }
        TipoCambio tipoCambio = tc.get();
        BigDecimal value = dto.getCantidad().multiply(tipoCambio.getFactor());

        return new ResponseDto(
                tipoCambio.getMonedaOrigen().getNombre(),
                tipoCambio.getMonedaDestino().getNombre(),
                dto.getCantidad(),
                value
        );
    }
}
