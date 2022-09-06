package com.turismo.turismoBack.services;

import com.turismo.turismoBack.models.entity.Publicacion;
import com.turismo.turismoBack.repositories.MunicipioRepository;
import com.turismo.turismoBack.repositories.PublicacionRepository;
import com.turismo.turismoBack.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionServiceImpl implements PublicacionService {

    private PublicacionRepository publicacionRepository;

    private MunicipioRepository municipioRepository;

    private UsuarioRepository usuarioRepository;


    @Override
    public void savePublicacion(Publicacion publicacion) {

    }

    @Override
    public List<Publicacion> findAll() {
        return (List<Publicacion>) publicacionRepository.findAll();
    }

    @Override
    public Publicacion findById(Long id) {
        return publicacionRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePublicacion(Long id) {
        publicacionRepository.deleteById(id);
    }

    @Override
    public void updatePublicacion(Publicacion publicacion) {
        publicacionRepository.save(publicacion);
    }

    @Override
    public List<Publicacion> findByTitulo(String titulo) {
        return publicacionRepository.findByTitulo(titulo);
    }

    @Override
    public List<Publicacion> findByTituloContaining(String titulo) {
        return publicacionRepository.findByTituloContaining(titulo);
    }

    @Override
    public List<Publicacion> findByPrecio(Double precio) {
        return publicacionRepository.findByPrecio(precio);
    }

    @Override
    public List<Publicacion> findByPrecioBetween(Double precio1, Double precio2) {
        return publicacionRepository.findByPrecioBetween(precio1, precio2);
    }

    @Override
    public List<Publicacion> findByMunicipio(Long id) {
        return publicacionRepository.findByMunicipio(id);
    }

    @Override
    public List<Publicacion> findByUsuario(Long id) {
        return publicacionRepository.findByUsuarioId(id);
    }

    @Autowired
    public void setPublicacionRepository(PublicacionRepository publicacionRepository) {
        this.publicacionRepository = publicacionRepository;
    }

    @Autowired
    public void setMunicipioRepository(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}

