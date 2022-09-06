package com.turismo.turismoBack.services;

import com.turismo.turismoBack.models.entity.Publicacion;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicacionService {
    public Publicacion savePublicacion(Publicacion publicacion);

    List<Publicacion> findAll();

    public Publicacion findById(Long id);

    public void deletePublicacion(Long id);

    public Publicacion updatePublicacion(Publicacion publicacion);




    public List<Publicacion> findByTitulo(String titulo);

    public List<Publicacion> findByTituloContaining(String titulo);
    public List<Publicacion> findByPrecio(Double precio);

    public List<Publicacion> findByPrecioBetween(Double precio1, Double precio2);

    public List<Publicacion> findByMunicipio(Long id);

    public List<Publicacion> findByUsuario(Long id);

}
