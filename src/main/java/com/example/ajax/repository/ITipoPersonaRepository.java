package com.example.ajax.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.ajax.entidades.TipoPersona;

@Repository
public interface ITipoPersonaRepository extends CrudRepository<TipoPersona, Integer>{

}
