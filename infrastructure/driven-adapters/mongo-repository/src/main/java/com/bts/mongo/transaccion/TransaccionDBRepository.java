package com.bts.mongo.transaccion;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface TransaccionDBRepository extends MongoRepository<TransaccionDocument, String> , QueryByExampleExecutor<TransaccionDocument> {
}
