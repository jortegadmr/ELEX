package com.soltel.elex.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "documentos")
public class DocumentosModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String nombre;

    private String descripcion;

    private LocalDate fecha;

    @Lob
    private byte[] archivo;

    @ManyToOne
    @JoinColumn(name = "tipo")
    private ActuacionesModel actuacion;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public byte[] getArchivo() {
		return archivo;
	}

	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}

	public ActuacionesModel getActuacion() {
		return actuacion;
	}

	public void setActuacion(ActuacionesModel actuacion) {
		this.actuacion = actuacion;
	}
    
    
}
