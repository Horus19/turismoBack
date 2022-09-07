package com.turismo.turismoBack.services;

import com.turismo.turismoBack.models.entity.Municipio;

import java.util.List;

public interface MunicipioService {

    public void saveMunicipio(Municipio municipio);

    public Municipio findById(Long id);

    public void deleteMunicipio(Long id);

    public void updateMunicipio(Municipio municipio);

    public List<Municipio> findAll();

}
