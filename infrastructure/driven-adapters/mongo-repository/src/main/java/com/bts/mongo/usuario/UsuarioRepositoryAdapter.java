package com.bts.mongo.usuario;

import com.bts.model.usuario.Usuario;
import com.bts.model.usuario.gateways.UsuarioGateway;
import com.bts.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepositoryAdapter extends AdapterOperations<Usuario, UsuarioDocument, String, UsuarioDBRepository>
 implements UsuarioGateway
{

    public UsuarioRepositoryAdapter(UsuarioDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Usuario.class));
    }

    @Override
    public Usuario register(Usuario usuario) {
        return null;
    }

    @Override
    public Usuario validatePassword(String email, String password) throws Exception {
        return null;
    }

    @Override
    public boolean existByEmail(String email) {
        return false;
    }
}
