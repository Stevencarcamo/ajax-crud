package com.example.ajax.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.ajax.entidades.Persona;

@Repository
public interface IPersonaRepository extends CrudRepository<Persona, Integer>{

}
