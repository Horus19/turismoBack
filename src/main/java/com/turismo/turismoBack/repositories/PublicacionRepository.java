package com.turismo.turismoBack.repositories;

import com.turismo.turismoBack.models.entity.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
    List<Publicacion> findByPrecio(Double precio);

    List<Publicacion> findByTituloContaining(String titulo);

    @Query("SELECT p FROM Publicacion p WHERE p.titulo = ?1")
    List<Publicacion> findByTitulo(String titulo);


    @Query("select p from Publicacion p where p.precio between ?1 and ?2")
    List<Publicacion> findByPrecioBetween(Double precio1, Double precio2);

    @Query("select p from Publicacion p where p.municipio.id = ?1")
    List<Publicacion> findByMunicipio(Long id);

    List<Publicacion> findByUsuarioId(Long id);
}

