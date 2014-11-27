package Modelo;


import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="tipo_diagnostico")
public class TipoDiagnostico implements Serializable {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad_modulos")
    private int catidadModulos;
    @Column(name = "activo")
    private boolean activo;
    @OneToMany
    private List<Proceso> misProcesos = new LinkedList<>();

    public TipoDiagnostico() {
    }

    public TipoDiagnostico( String nombre, String descripcion, boolean activo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
//        this.catidadModulos = catidadModulos;
        this.activo = true;
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

    public int getCatidadModulos() {
        return catidadModulos;
    }

    public void setCatidadModulos(int catidadModulos) {
        this.catidadModulos = catidadModulos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Proceso> getMisProcesos() {
        return misProcesos;
    }
    
    

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
