package com.turismo.turismoBack.controllers;

import com.turismo.turismoBack.models.entity.Publicacion;
import com.turismo.turismoBack.services.MunicipioService;
import com.turismo.turismoBack.services.PublicacionService;
import com.turismo.turismoBack.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PublicacionController {

    private PublicacionService publicacionService;


    @GetMapping("/publicaciones")
    public ResponseEntity<List<Publicacion>> findAll() {
        var publicaciones = publicacionService.findAll();
        if (publicaciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(publicaciones);
    }

    @GetMapping("/publicacionByID")
    public ResponseEntity<Publicacion> findById(@RequestParam Long id) {
        var publicacion = publicacionService.findById(id);
        if (publicacion == null) {
            return new ResponseEntity("No existe la publicacion con id " + id, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(publicacion);
    }

    @GetMapping("/publicacionByTitulo")
    public ResponseEntity<List<Publicacion>> findByTitulo(@RequestParam String titulo) {
        var publicaciones = publicacionService.findByTituloContaining(titulo);
        if (publicaciones.isEmpty()) {
            return new ResponseEntity("No existe la publicacion con titulo " + titulo, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(publicaciones);
    }


    @GetMapping("/publicacionByPrecioBetween")
    public ResponseEntity<List<Publicacion>> findByPrecioBetween(@RequestParam Double precio1, @RequestParam Double precio2) {
        var publicaciones = publicacionService.findByPrecioBetween(precio1, precio2);
        if (publicaciones.isEmpty()) {
            return new ResponseEntity("No existe la publicacion con precio entre " + precio1 + " y " + precio2, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(publicaciones);
    }

    @GetMapping("/publicacionByIDUsuario")
    public ResponseEntity<List<Publicacion>> findByIDUsuario(@RequestParam Long id) {
        var publicaciones = publicacionService.findByUsuario(id);
        if (publicaciones.isEmpty()) {
            return new ResponseEntity("No existe la publicacion con usuario id " + id, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(publicaciones);
    }

    @GetMapping("/publicacionByIDMunicipio")
    public ResponseEntity<List<Publicacion>> findByIDMunicipio(@RequestParam Long id) {
        var publicaciones = publicacionService.findByMunicipio(id);
        if (publicaciones.isEmpty()) {
            return new ResponseEntity("No existe la publicacion con municipio id " + id, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(publicaciones);
    }

    @PostMapping("/publicacion")
    public ResponseEntity<Publicacion> create(@RequestBody Publicacion publicacion) {
        var publicacionDB = publicacionService.savePublicacion(publicacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(publicacionDB);
    }

    @PutMapping("/publicacion")
    public ResponseEntity<Publicacion> update(@RequestBody Publicacion publicacion) {
        var publicacionDB = publicacionService.updatePublicacion(publicacion);
        if (publicacionDB == null) {
            return new ResponseEntity("No existe la publicacion con id " + publicacion.getId(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(publicacionDB);
    }


    @DeleteMapping("/publicaciones/{id}")
    public ResponseEntity<Publicacion> deletePublicacion(@PathVariable Long id) {
        var publicacion = publicacionService.findById(id);
        if (publicacion == null) {
            return ResponseEntity.notFound().build();
        }
        publicacionService.deletePublicacion(id);
        return ResponseEntity.ok(publicacion);
    }





    @Autowired
    public void setPublicacionService(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

}
