package com.turismo.turismoBack.repositories;

import com.turismo.turismoBack.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);

    @Query("select u from Usuario u where u.id = ?1")
    Optional<Usuario> findById(Long id);


}
