package com.projetobase.crud.controller.impl;

import com.projetobase.crud.controller.BaseController;
import com.projetobase.crud.dto.BaseDTO;
import com.projetobase.crud.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
public class BaseControllerImpl<
        D extends BaseDTO<ID>,
        ID extends Serializable>
        implements BaseController<D, ID> {

    private final BaseService<D, ID> _service;

    @Override
    public ResponseEntity<List<D>> getAll() {
        return ResponseEntity.ok().body(_service.getAll());
    }

    @Override
    public ResponseEntity<D> getById(ID id) {
        return ResponseEntity.ok().body(_service.getById(id));
    }

    @Override
    public ResponseEntity<D> create(D dto) {
        return null;
    }

    @Override
    public ResponseEntity<D> update(ID id, D dto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(ID id) {
        return null;
    }
}
