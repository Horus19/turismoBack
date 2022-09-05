package com.turismo.turismoBack.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "municipios")
@Getter @Setter
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String nombre;
    @JsonIgnoreProperties({"publicaciones", "hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "municipio", cascade = CascadeType.ALL )
    private List<Publicacion> publicaciones;
}
