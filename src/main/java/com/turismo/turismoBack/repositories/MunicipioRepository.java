package com.turismo.turismoBack.repositories;

import com.turismo.turismoBack.models.entity.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
    @Query("select m from Municipio m where m.id = ?1")
    Optional<Municipio> findById(Long id);
}

