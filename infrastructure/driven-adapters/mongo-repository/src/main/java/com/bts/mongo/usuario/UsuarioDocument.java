package com.bts.mongo.usuario;

import com.bts.model.usuario.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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

    @Field("nombre")
    private String nombre;

    @Field("email")
    private String email;

    @Field("password")
    private String password;

    @Field("role")
    private Role role;

    @Field("createdAt")
    private LocalDateTime createdAt;

    @Field("active")
    private Boolean active;

}