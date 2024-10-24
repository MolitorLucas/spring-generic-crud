package com.projetobase.usuario.dto;

import com.projetobase.crud.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UsuarioDTO implements BaseDTO<Long> {

    private Long id;

    private String nome;
}
