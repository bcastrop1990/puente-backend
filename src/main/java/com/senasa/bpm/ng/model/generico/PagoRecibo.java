package com.senasa.bpm.ng.model.generico;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagoRecibo {
    private String codigoTipoPago;
    private String tipoPago;
    private String codigoBanco;
    private String banco;
    private String codigoCtaCte;
    private String cuentaCorriente;
    private String numeroBoleta;
    private Date fecha;
    private String monto;
    private String editable;
    private String fecRecibo;
}
