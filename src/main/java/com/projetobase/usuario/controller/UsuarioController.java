package com.projetobase.usuario.controller;

import com.projetobase.crud.controller.impl.BaseControllerImpl;
import com.projetobase.crud.service.BaseService;
import com.projetobase.usuario.dto.UsuarioDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends BaseControllerImpl<UsuarioDTO, Long> {

}
