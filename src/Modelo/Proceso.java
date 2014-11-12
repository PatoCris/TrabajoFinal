package Modelo;


import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
@Entity
@Table(name="precesos")
public class Proceso implements Serializable {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad_modulos")
    private int cantidadModulos;
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name="una_especialidad")
    @OneToOne
    private Especialidad unaEspecialidad;
    @OneToMany
    private List<PiezaRecambio> misPiezasRecambios= new LinkedList<>();
    

    public Proceso() {
    }

    public Proceso(int codigo, String nombre, String descripcion, int cantidadModulos, boolean activo, Especialidad unaEspecialidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadModulos = cantidadModulos;
        this.activo = activo;
        this.unaEspecialidad = unaEspecialidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public int getCantidadModulos() {
        return cantidadModulos;
    }

    public void setCantidadModulos(int cantidadModulos) {
        this.cantidadModulos = cantidadModulos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Especialidad getUnaEspecialidad() {
        return unaEspecialidad;
    }

    public void setUnaEspecialidad(Especialidad unaEspecialidad) {
        this.unaEspecialidad = unaEspecialidad;
    }

    public List<PiezaRecambio> getMisPiezasRecambios() {
        return misPiezasRecambios;
    }
    
    
}
