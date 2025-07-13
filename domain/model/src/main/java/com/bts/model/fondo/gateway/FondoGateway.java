package com.bts.model.fondo.gateway;

import com.bts.model.common.exception.ErrorException;
import com.bts.model.fondo.Fondo;
import com.bts.model.transaccion.Transaccion;

import java.util.List;

public interface FondoGateway {
    Fondo save(Fondo fondo);
    Fondo findById(String id) throws ErrorException;
    List<Fondo> findAll();
}
