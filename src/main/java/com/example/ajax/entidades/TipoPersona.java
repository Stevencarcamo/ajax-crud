package com.example.ajax.entidades;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoPersona {

	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    private String tipo;

	    public TipoPersona() {
	        super();
	    }

	    public TipoPersona(Integer id, String tipo) {
	        this.id=id;
	        this.tipo=tipo;
	    }


	    public void setId(Integer id) {
	        this.id = id;
	    }
	    
	    public Integer getId() {
	        return id;
	    }

	    public void setTipo(String tipo) {
	        this.tipo = tipo;
	    }

	    public String getTipo() {
	        return tipo;
	    }
	
}
