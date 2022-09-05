package com.turismo.turismoBack.Mappers;

public class publicacionMapper {
    public static com.turismo.turismoBack.models.DTO.publicacionDTO toPublicacionDTO(com.turismo.turismoBack.models.entity.Publicacion publicacion){
        com.turismo.turismoBack.models.DTO.publicacionDTO publicacionDTO = new com.turismo.turismoBack.models.DTO.publicacionDTO();
        publicacionDTO.setId(publicacion.getId());
        publicacionDTO.setTitulo(publicacion.getTitulo());
        publicacionDTO.setDescripcion(publicacion.getDescripcion());
        publicacionDTO.setPrecio(publicacion.getPrecio());
        publicacionDTO.setUsuario_id(publicacion.getUsuario().getId());
        publicacionDTO.setMunicipio_id(publicacion.getMunicipio().getId());
        return publicacionDTO;
    }

    public static com.turismo.turismoBack.models.entity.Publicacion toPublicacion(com.turismo.turismoBack.models.DTO.publicacionDTO publicacionDTO){
        com.turismo.turismoBack.models.entity.Publicacion publicacion = new com.turismo.turismoBack.models.entity.Publicacion();
        publicacion.setId(publicacionDTO.getId());
        publicacion.setTitulo(publicacionDTO.getTitulo());
        publicacion.setDescripcion(publicacionDTO.getDescripcion());
        publicacion.setPrecio(publicacionDTO.getPrecio());
        return publicacion;
    }
}
