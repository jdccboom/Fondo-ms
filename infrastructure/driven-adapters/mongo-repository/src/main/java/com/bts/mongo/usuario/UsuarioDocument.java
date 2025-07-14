package com.bts.mongo.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "usuarios")
public class UsuarioDocument {

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("email")
    private String email;

    @Field("password")
    private String password;

    @Field("role")
    private String role;

    @Field("createdAt")
    private LocalDateTime createdAt;

    @Field("active")
    private Boolean active;

    @Field("availableBalance")
    private BigDecimal availableBalance;

    @Field("notificationPreference")
    private String notificationPreference;

}