package com.turismo.turismoBack.services;

import com.turismo.turismoBack.models.entity.Municipio;
import com.turismo.turismoBack.repositories.MunicipioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MunicipioServiceImpl implements MunicipioService {
    private MunicipioRepository municipioRepository;

    public MunicipioServiceImpl(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

    @Override
    public void saveMunicipio(Municipio municipio) {
        this.municipioRepository.save(municipio);
    }

    @Override
    public Municipio findById(Long id) {
        return municipioRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMunicipio(Long id) {
        municipioRepository.deleteById(id);
    }

    @Override
    public void updateMunicipio(Municipio municipio) {
        municipioRepository.save(municipio);
    }

    @Override
    public List<Municipio> findAll() {
        return municipioRepository.findAll();
    }
}

