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
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

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
        Optional<T> entityOptional = this._repository.findById(id);
        if (entityOptional.isPresent()) {
            T entity = this._mapper.toEntity(dto);
            entity.setId(id);
            return this._mapper.toDTO(
                    this._repository.save(entity)
            );
        }
        throw new RuntimeException("Objeto do tipo " + ((Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName() + " não encontrado");
    }

    @Override
    public D create(D dto) {
        T entity = this._mapper.toEntity(dto);
        return this._mapper.toDTO(
                this._repository.save(entity)
        );
    }
}
