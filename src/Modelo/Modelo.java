package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="modelos")
public class Modelo implements Serializable {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name="un_marca")
    @OneToOne
    private Marca unaMarca;
    @JoinColumn(name="un_segmento")
    @OneToOne
    private Segmento unSegmento;

    public Modelo() {
    }

    public Modelo(String nombre, String descripcion, boolean activo, Marca unaMarca, Segmento unSegmento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
        this.unaMarca = unaMarca;
        this.unSegmento = unSegmento;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Marca getUnaMarca() {
        return unaMarca;
    }

    public void setUnaMarca(Marca unaMarca) {
        this.unaMarca = unaMarca;
    }

    public Segmento getUnSegmento() {
        return unSegmento;
    }

    public void setUnSegmento(Segmento unSegmento) {
        this.unSegmento = unSegmento;
    }
}
