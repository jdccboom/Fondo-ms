package com.bts.model.cliente.gateway;

import com.bts.model.cliente.Cliente;

public interface ClienteGateway {
    Cliente findById(String id);
}
