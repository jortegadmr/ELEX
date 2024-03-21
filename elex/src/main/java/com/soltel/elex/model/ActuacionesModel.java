package com.soltel.elex.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table (name= "actuaciones")
public class ActuacionesModel {

	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private LocalDate fecha;

    private String descripcion;

    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "codigoExpediente")
    private ExpedientesModel expediente;

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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public ExpedientesModel getExpediente() {
		return expediente;
	}

	public void setExpediente(ExpedientesModel expediente) {
		this.expediente = expediente;
	}
    
    
}
