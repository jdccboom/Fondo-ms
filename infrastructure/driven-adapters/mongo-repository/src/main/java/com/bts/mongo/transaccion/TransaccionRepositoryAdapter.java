package com.bts.mongo.transaccion;

import com.bts.model.transaccion.Transaccion;
import com.bts.model.transaccion.gateway.TransaccionGateway;
import com.bts.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TransaccionRepositoryAdapter extends AdapterOperations<Transaccion, TransaccionDocument, String, TransaccionDBRepository>
 implements TransaccionGateway
{

    public TransaccionRepositoryAdapter(TransaccionDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Transaccion.class));
    }
}
