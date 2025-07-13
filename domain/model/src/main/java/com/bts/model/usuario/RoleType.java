package com.bts.model.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleType {
    Admin("ADMIN"), Client("CLIENTE");

    private final String name;
}
