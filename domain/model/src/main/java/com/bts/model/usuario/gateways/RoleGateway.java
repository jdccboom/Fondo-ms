package com.bts.model.usuario.gateways;

import com.bts.model.usuario.Role;

public interface RoleGateway {
    Role getRole(String roleName);
}
