package com.bts.mongo.transaccion;

import com.bts.model.transaccion.Transaccion;
import com.bts.model.transaccion.gateway.TransaccionGateway;
import com.bts.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransaccionRepositoryAdapter extends AdapterOperations<Transaccion, TransaccionDocument, String, TransaccionDBRepository>
 implements TransaccionGateway
{

    public TransaccionRepositoryAdapter(TransaccionDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Transaccion.class));
    }

    @Override
    public List<Transaccion> findByClienteIdAndFondoId(String clienteId, String fondoId) {
        return repository.findByClienteIdAndFondoId(clienteId, fondoId);
    }
}
