package com.projetobase.crud.mapper;


import com.projetobase.crud.dto.BaseDTO;
import com.projetobase.crud.model.BaseModel;
import org.mapstruct.Mapper;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface BaseMapper<T extends BaseModel<ID>, ID extends Serializable, D extends BaseDTO<ID>> {

    D toDTO(T t);
    T toEntity(D dto);
    default List<D> toDTOList(List<T> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
    default List<T> toEntityList(List<D> dtoList) {
        return dtoList.stream().map(this::toEntity).toList();
    }
}
