package com.turismo.turismoBack.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String username;

    @Column(length = 60)
    private String password;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(unique = true)
    private String email;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name="usuarios_roles", joinColumns= @JoinColumn(name="usuario_id"),
//            inverseJoinColumns=@JoinColumn(name="role_id"),
//            uniqueConstraints= {@UniqueConstraint(columnNames= {"usuario_id", "role_id"})})
//
//    private List<Role> roles;
//
//    @JsonIgnoreProperties({"usuario", "hibernateLazyInitializer", "handler"})
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
//    private List<Publicacion> publicaciones;
}
