package com.projetobase.crud.mapper;


import com.projetobase.crud.dto.BaseDTO;
import com.projetobase.crud.model.BaseModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;


public interface BaseMapper<T extends BaseModel<ID>,
                            ID extends Serializable,
                            D extends BaseDTO<ID>
                           > {
    D toDTO(T t);
    T toEntity(D dto);
    List<D> toDTOList(List<T> entityList);
    List<T> toEntityList(List<D> dtoList);
}
