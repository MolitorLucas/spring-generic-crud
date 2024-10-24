package com.projetobase.usuario.service;

import com.projetobase.crud.mapper.BaseMapper;
import com.projetobase.crud.service.BaseService;
import com.projetobase.crud.service.impl.BaseServiceImpl;
import com.projetobase.usuario.dto.UsuarioDTO;
import com.projetobase.usuario.mapper.UsuarioMapper;
import com.projetobase.usuario.model.Usuario;
import com.projetobase.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseServiceImpl<Usuario, UsuarioDTO, Long> {

}
