package com.bts.mongo.transaccion;

import com.bts.model.transaccion.Transaccion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface TransaccionDBRepository extends MongoRepository<TransaccionDocument, String> , QueryByExampleExecutor<TransaccionDocument> {
    List<Transaccion> findByClienteIdAndFondoId(String clienteId, String fondoId);
}
