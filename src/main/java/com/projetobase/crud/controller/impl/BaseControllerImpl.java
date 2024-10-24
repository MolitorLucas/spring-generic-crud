package com.projetobase.crud.controller.impl;

import com.projetobase.crud.controller.BaseController;
import com.projetobase.crud.dto.BaseDTO;
import com.projetobase.crud.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class BaseControllerImpl<
        D extends BaseDTO<ID>,
        ID extends Serializable>
        implements BaseController<D, ID> {

    @Autowired
    protected BaseService<D, ID> _service;

    @GetMapping
    @Override
    public ResponseEntity<List<D>> getAll() {
        return ResponseEntity.ok().body(_service.getAll());
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<D> getById(@PathVariable ID id) {
        return ResponseEntity.ok().body(_service.getById(id));
    }

    @PostMapping
    @Override
    public ResponseEntity<D> create(@RequestBody D dto) {
        return ResponseEntity.ok().body(_service.create(dto));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<D> update(@PathVariable ID id, @RequestBody D dto) {
        return ResponseEntity.ok().body(_service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete( @PathVariable ID id) {
        return ResponseEntity.ok().build();
    }
}
