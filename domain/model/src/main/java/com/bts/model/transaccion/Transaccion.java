package com.bts.model.transaccion;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Transaccion {

    private String transaccionId;
    private String clienteId;
    private String fondoId;
    private String tipo;
    private BigDecimal monto;
    private LocalDateTime fecha;

}
