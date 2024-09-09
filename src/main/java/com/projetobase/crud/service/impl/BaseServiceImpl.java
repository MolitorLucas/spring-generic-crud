package com.projetobase.crud.service.impl;

import com.projetobase.crud.dto.BaseDTO;
import com.projetobase.crud.mapper.BaseMapper;
import com.projetobase.crud.model.BaseModel;
import com.projetobase.crud.repository.BaseRepository;
import com.projetobase.crud.service.BaseService;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class BaseServiceImpl<T extends BaseModel<ID>,
                             ID extends Serializable,
                             D extends BaseDTO<ID>,
                             M extends BaseMapper<T, ID, D>,
                             R extends BaseRepository<T, ID>
                            > implements BaseService<T, ID, D, R> {

    private final R _repository;
    private final M _mapper;

    @Override
    public List<D> getAll() {
        return this._mapper.toDTOList(
                this._repository.findAll()
        );
    }

    @Override
    public D getById(ID id) {
        return this._mapper.toDTO(
                this._repository.findById(id)
                        .orElseThrow(RuntimeException::new)
        );
    }

    @Override
    public void delete(ID id) {
        this._repository.deleteById(id);
    }

    @Override
    public D update(ID id, D dto) {
        T entity = this._repository.findById(id).orElseThrow(RuntimeException::new);

        return this._mapper.toDTO(
                this._repository.save(this._mapper.toEntity(dto))
        );
    }

    @Override
    public D create(D dto) {
        T entity = this._mapper.toEntity(dto);
        return this._mapper.toDTO(
                this._repository.save(entity)
        );
    }
}
