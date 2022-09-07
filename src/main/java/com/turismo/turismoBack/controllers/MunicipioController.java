package com.turismo.turismoBack.controllers;

import com.turismo.turismoBack.models.entity.Municipio;
import com.turismo.turismoBack.models.entity.Usuario;
import com.turismo.turismoBack.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api")
public class MunicipioController {

    private MunicipioService municipioService;

    @GetMapping("/municipios")
    public ResponseEntity<List<Municipio>> findAll() {
        var municipios = municipioService.findAll();
        if (municipios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(municipios);
    }

    @GetMapping("/municipioByID")
    public ResponseEntity<Municipio> findById(@RequestParam Long id) {
        var municipio = municipioService.findById(id);
        if (municipio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(municipio);
    }

    @Autowired
    public void setMunicipioService(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }
}
