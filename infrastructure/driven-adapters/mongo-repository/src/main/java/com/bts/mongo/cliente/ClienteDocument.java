package com.bts.mongo.cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clientes")
public class ClienteDocument {

    @Id
    private String clienteId;

    @Field("nombre")
    private String nombre;

    @Field("saldoDisponible")
    private BigDecimal saldoDisponible;

    @Field("preferenciaNotificacion")
    private String preferenciaNotificacion;

}