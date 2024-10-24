package com.projetobase.crud.service.impl;

import com.projetobase.crud.dto.BaseDTO;
import com.projetobase.crud.mapper.BaseMapper;
import com.projetobase.crud.model.BaseModel;
import com.projetobase.crud.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class BaseServiceImpl<
                             T extends BaseModel<ID>,
                             D extends BaseDTO<ID>,
                             ID extends Serializable
                            > implements BaseService<D, ID> {

    @Autowired
    protected JpaRepository<T, ID> _repository;
    @Autowired
    protected BaseMapper<T, ID, D> _mapper;

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
