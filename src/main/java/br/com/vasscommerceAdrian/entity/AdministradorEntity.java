package br.com.vasscommerceAdrian.entity;

import br.com.vasscommerceAdrian.dto.AdministradorRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrador")
public class AdministradorEntity extends UsuarioEntity {

    public AdministradorEntity() {}

    public AdministradorEntity(AdministradorRequestDto dto) {
        super(dto);
    }
}
