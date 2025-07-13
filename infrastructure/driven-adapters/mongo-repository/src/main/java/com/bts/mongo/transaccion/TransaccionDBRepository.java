package com.bts.mongo.transaccion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface TransaccionDBRepository extends MongoRepository<TransaccionDocument, String> , QueryByExampleExecutor<TransaccionDocument> {

    Page<TransaccionDocument> findByTransaccionIdOrClienteIdOrTipoOrFondoIdAllIgnoreCase(
            String transaccionId,
            String clienteId,
            String tipo,
            String fondoId,
            Pageable pageable
    );
}
