package com.bts.api.auth.response;

import com.bts.model.usuario.RoleType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetail {

    private Long id;
    private String name;
    private String email;
    private RoleType role;

}
