package com.turismo.turismoBack.models.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class publicacionDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private Double precio;
    private Long usuario_id;
    private Long municipio_id;
}
