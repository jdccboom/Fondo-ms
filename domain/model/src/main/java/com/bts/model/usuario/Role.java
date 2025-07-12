package com.bts.model.usuario;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Role {

    private Long id;

    private String name;

}
