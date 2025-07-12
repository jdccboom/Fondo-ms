package com.bts.mongo.cliente;

import com.bts.model.cliente.Cliente;
import com.bts.model.cliente.gateway.ClienteGateway;
import com.bts.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepositoryAdapter extends AdapterOperations<Cliente, ClienteDocument, String, ClienteDBRepository>
 implements ClienteGateway
{

    public ClienteRepositoryAdapter(ClienteDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Cliente.class));
    }
}
