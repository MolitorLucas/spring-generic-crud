package com.projetobase.usuario.mapper;

import com.projetobase.crud.mapper.BaseMapper;
import com.projetobase.usuario.dto.UsuarioDTO;
import com.projetobase.usuario.model.Usuario;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UsuarioMapper extends BaseMapper<Usuario, Long, UsuarioDTO> {
}
