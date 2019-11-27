package com.example.ajax.controladores;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ajax.entidades.Doctor;
import com.example.ajax.repository.IDoctorRepository;

@Controller
@RequestMapping("doctores")
public class DoctorController {
	
	//repositorio para el manejo de datos
	@Autowired
	IDoctorRepository erDoctor;

	//listar registros
	@GetMapping (value="all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Doctor> getAllDoctor(){
		return (List<Doctor>) erDoctor.findAll();
	}
	
	//guardar
	@GetMapping(value ="save")
	@ResponseBody
	public HashMap<String,String> save(@RequestParam String direccion, @RequestParam String nombre) {
		Doctor n = new Doctor();//crear objeto de neurologo
		
		HashMap<String,String> jsonReturn = new HashMap<>();
	
		n.setNombre(nombre);
		n.setDireccion(direccion);
		//manejando cualquier excepcion de error
		try {
			erDoctor.save(n);//se guarda el registro del doctor	
			jsonReturn.put("estado","OK");
			jsonReturn.put("mensaje","Registro Guardado");		
			return jsonReturn;
		}catch(Exception e){
			jsonReturn.put("estado","ERROR");
			jsonReturn.put("mensaje","Registro no Guardado"+e.getMessage());		
			return jsonReturn;
		}
	}
	
	//eliminar
		@GetMapping("delete/{id_doctor}")
		@ResponseBody
		public HashMap<String,String> eliminar (@PathVariable Integer id_doctor) {			
			HashMap<String,String> jsonReturn = new HashMap<>();
			
			try {
				//buscar registro
				Doctor n = erDoctor.findById(id_doctor).get();
				//elimina el registro
				erDoctor.delete(n);				
				 jsonReturn.put("estado", "OK");
				 jsonReturn.put("mensaje", "Registro eliminado");
				 return jsonReturn;
			}catch(Exception e) {
				 jsonReturn.put("estado", "ERROR");
				 jsonReturn.put("mensaje", "Registro no guardado"+e.getMessage());
				 return jsonReturn;
			}
		}
		
		//modificar
		@GetMapping(value ="update/{id_doctor}")
		@ResponseBody
		public HashMap<String,String> update(
				@RequestParam Integer id_doctor,
				@RequestParam String direccion, 
				@RequestParam String nombre) {
			
			Doctor n = new Doctor();//se crea el objeto neurologo
			HashMap<String,String> jsonReturn = new HashMap<>();
			//asignando datos al objeto neurologo
			n.setId(id_doctor);
			n.setNombre(nombre);
			n.setDireccion(direccion);
			//manejando cualquier excepcion de error
			try {
				erDoctor.save(n);//se guarda el registro del doctor
				
				jsonReturn.put("estado","OK");
				jsonReturn.put("mensaje","Registro Actualizado");
				
				return jsonReturn;
			}catch(Exception e){
				jsonReturn.put("estado","ERROR");
				jsonReturn.put("mensaje","Registro no actualizado"+e.getMessage());
				return jsonReturn;
			}
		}
}