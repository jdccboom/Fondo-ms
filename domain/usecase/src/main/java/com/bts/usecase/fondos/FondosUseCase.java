package com.bts.usecase.fondos;

import com.bts.model.fondo.Fondo;
import com.bts.model.fondo.gateway.FondoGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FondosUseCase {

    private final FondoGateway fondoGateway;

    public Fondo suscribir(Fondo fondo) {
        return fondoGateway.save(fondo);
    }


}
