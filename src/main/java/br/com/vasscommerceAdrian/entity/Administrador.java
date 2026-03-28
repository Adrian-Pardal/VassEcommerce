package br.com.vasscommerceAdrian.entity;

import br.com.vasscommerceAdrian.dto.AdministradorDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrador")
public class Administrador extends UsuarioEntity {

    public Administrador() {}

    public Administrador(AdministradorDto dto) {
        super(dto);
    }
}
