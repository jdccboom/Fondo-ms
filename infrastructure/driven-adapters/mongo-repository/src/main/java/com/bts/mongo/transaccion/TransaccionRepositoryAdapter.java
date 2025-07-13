package com.bts.mongo.transaccion;

import com.bts.model.common.PageRequests;
import com.bts.model.transaccion.ListTransaccionDTO;
import com.bts.model.transaccion.Transaccion;
import com.bts.model.transaccion.TransaccionFilters;
import com.bts.model.transaccion.gateway.TransaccionGateway;
import com.bts.mongo.helper.AdapterOperations;
import lombok.extern.slf4j.Slf4j;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class TransaccionRepositoryAdapter extends AdapterOperations<Transaccion, TransaccionDocument, String, TransaccionDBRepository>
 implements TransaccionGateway
{

    public TransaccionRepositoryAdapter(TransaccionDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Transaccion.class));
    }

    @Override
    public ListTransaccionDTO findByFilters(TransaccionFilters filters, PageRequests pageRequests) throws Exception {
        try {
            Pageable pageable = PageRequest.of(
                    pageRequests.getPage(),
                    pageRequests.getSize(),
                    pageRequests.getSort() != null && !pageRequests.getSort().isEmpty()
                            ? Sort.by(pageRequests.getSort())
                            : Sort.unsorted()
            );
            Page<TransaccionDocument> transaccionDocuments = repository.findByTransaccionIdOrClienteIdOrTipoOrFondoIdAllIgnoreCase(
                    filters.getTransaccionId(),
                    filters.getClienteId(),
                    filters.getTipo(),
                    filters.getFondoId(),
                    pageable);

            ListTransaccionDTO listMovieDTO = ListTransaccionDTO.builder()
                    .transacciones(transaccionDocuments.map(this::toEntity).toList())
                    .totalItems(transaccionDocuments.getTotalElements())
                    .page(transaccionDocuments.getNumber())
                    .build();

            log.info("Lista de transacciones: {}", listMovieDTO.getTotalItems());
            return listMovieDTO;
        } catch (Exception e) {
            log.info("Error listing transaccion by: {}", filters);
            throw new Exception(e);
        }
    }
}
