package com.bts.model.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Usuario {

    private String id;

    private String name;

    private String email;

    private String password;

    private String role;

    private LocalDateTime createdAt;

    private Boolean active;

    private BigDecimal availableBalance;

    private String notificationPreference;
}
