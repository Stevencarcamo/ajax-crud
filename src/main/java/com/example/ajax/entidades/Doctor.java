package com.example.ajax.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_doctor;
    private String  nombre;
    private String  direccion;

   public Doctor() {
    super();
}

public Doctor(Integer id_doctor, String nombre, String direccion) {
	super();
	this.id_doctor = id_doctor;
	this.nombre = nombre;
	this.direccion = direccion;
}

public Integer getId() {
	return id_doctor;
}

public void setId(Integer id) {
	this.id_doctor = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}
}