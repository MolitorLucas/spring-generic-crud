package com.projetobase.crud.repository;

import com.projetobase.crud.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BaseRepository<T extends BaseModel<ID>, ID extends Serializable>  extends JpaRepository<T, ID> {
}
