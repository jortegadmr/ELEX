package com.soltel.elex.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "expedientes")
public class ExpedientesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private Integer expediente;
	
	private LocalDate fecha;

    private String numero;

    private String materia;

    private Boolean estado;

    private String responsable;
    
    private String responsable2;

    private String descripcion;

    private String condicion;

    private BigDecimal precio;

    private String consejeria;
    
    @ManyToOne
    @JoinColumn(name = "tipo")
    private TipoExpedienteModel tipoExpediente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getExpediente() {
		return expediente;
	}

	public void setExpediente(Integer expediente) {
		this.expediente = expediente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getResponsable2() {
		return responsable2;
	}

	public void setResponsable2(String responsable2) {
		this.responsable2 = responsable2;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getConsejeria() {
		return consejeria;
	}

	public void setConsejeria(String consejeria) {
		this.consejeria = consejeria;
	}
    
    
}
