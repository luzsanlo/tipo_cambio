package com.cambio.tipocambio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipo_cambio")
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "moneda_origen", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Moneda monedaOrigen;

    @JoinColumn(name = "moneda_destino", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Moneda monedaDestino;

    @Column(name = "factor")
    private BigDecimal factor;

    @Column(name = "usuario_creacion")
    private String usuarioCreacion;

    @Column(name = "usuario_actualizacion")
    private String usuarioActualizacion;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    @Column(name = "estado")
    private Boolean estado;
}
