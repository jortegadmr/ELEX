package com.soltel.elex.model;

import java.time.LocalDate;
import javax.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class documentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruta;

    private String nombre;

    private String descripcion;

    private LocalDate fecha;

    // Constructor, getters y setters
    
    @ManyToOne
    @JoinColumn(name = "tipo")
    private actuaciones actuacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
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

    public actuaciones getActuacion() {
        return actuacion;
    }

    public void setActuacion(actuaciones actuacion) {
        this.actuacion = actuacion;
    }

    

    
}
