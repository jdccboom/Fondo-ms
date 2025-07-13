package com.bts.model.transaccion.gateway;

import com.bts.model.transaccion.Transaccion;

import java.util.List;

public interface TransaccionGateway {
    Transaccion save(Transaccion transaccion);
    List<Transaccion> findByClienteIdAndFondoId(String clienteId, String fondoId);
}
