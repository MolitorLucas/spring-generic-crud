package com.projetobase.crud.service;

import com.projetobase.crud.dto.BaseDTO;
import com.projetobase.crud.model.BaseModel;
import com.projetobase.crud.repository.BaseRepository;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends BaseModel<ID>, ID extends Serializable, D extends BaseDTO<ID>, R extends BaseRepository<T, ID>> {

    List<D> getAll();
    D getById(ID id);
    D create(D dto);
    D update(ID id, D dto);
    void delete(ID id);

}
