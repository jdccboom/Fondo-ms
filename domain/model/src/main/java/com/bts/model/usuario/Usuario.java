package com.bts.model.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Usuario {

    private Long id;

    private String name;

    private String email;

    private String password;

    private Role role;

    private LocalDateTime createdAt;

    private Boolean active;
}
