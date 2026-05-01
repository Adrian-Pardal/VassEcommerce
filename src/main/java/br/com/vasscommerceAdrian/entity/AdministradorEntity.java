package br.com.vasscommerceAdrian.entity;

import br.com.vasscommerceAdrian.dto.AdministradorRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrador")
public class Administrador extends UsuarioEntity {

    public Administrador() {}

    public Administrador(AdministradorRequestDto dto) {
        super(dto);
    }
}
