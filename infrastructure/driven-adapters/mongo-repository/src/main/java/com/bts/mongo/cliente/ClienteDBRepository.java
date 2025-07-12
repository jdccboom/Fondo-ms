package com.bts.mongo.cliente;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ClienteDBRepository extends MongoRepository<ClienteDocument, String> , QueryByExampleExecutor<ClienteDocument> {
}
