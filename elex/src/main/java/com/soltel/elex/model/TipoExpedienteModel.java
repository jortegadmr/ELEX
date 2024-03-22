package com.soltel.elex.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_expediente")
public class TipoExpedienteModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String nombre;

	// ------------------ Constructor ------------------
	public TipoExpedienteModel() { }
		
		public TipoExpedienteModel(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	// ------------------ Getter y Setter ------------------
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
