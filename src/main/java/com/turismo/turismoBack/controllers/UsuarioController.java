package com.turismo.turismoBack.controllers;

import com.turismo.turismoBack.models.entity.Usuario;
import com.turismo.turismoBack.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UsuarioController {

    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> findAll() {
        var usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/usuarioByID")
    public ResponseEntity<Usuario> findById(@RequestParam Long id) {
        var usuario = usuarioService.findById(id);
        if (usuario == null) {
            return new ResponseEntity("No existe el usuario con id " + id, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(usuario);
    }


    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
