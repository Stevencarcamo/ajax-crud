package com.example.ajax.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ajax.entidades.Doctor;

@Repository
public interface IDoctorRepository extends CrudRepository <Doctor,Integer>{
}