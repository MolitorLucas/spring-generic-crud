package com.projetobase.crud.dto;

import java.io.Serializable;

public interface BaseDTO<ID extends Serializable> {

    ID getId();
    void setId(ID id);
}
