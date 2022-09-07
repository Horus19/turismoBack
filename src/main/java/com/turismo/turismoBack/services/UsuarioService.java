package com.turismo.turismoBack.services;

import com.turismo.turismoBack.models.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    public void saveUsuario(Usuario usuario);

    public Usuario findByUsername(String username);

    public Usuario findById(Long id);

    public void deleteUsuario(Long id);

    public void updateUsuario(Usuario usuario);

    public List<Usuario> findAll();
}

