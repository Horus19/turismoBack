package com.turismo.turismoBack.services;

import com.turismo.turismoBack.models.entity.Usuario;
import com.turismo.turismoBack.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioServiceImpl implements UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}

