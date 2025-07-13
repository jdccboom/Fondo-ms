package com.bts.model.transaccion.gateway;

import com.bts.model.common.PageRequests;
import com.bts.model.transaccion.ListTransaccionDTO;
import com.bts.model.transaccion.Transaccion;
import com.bts.model.transaccion.TransaccionFilters;

public interface TransaccionGateway {
    ListTransaccionDTO findByFilters(TransaccionFilters filters, PageRequests pageRequests) throws Exception;
}
