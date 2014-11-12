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
@Table(name="anomalias")
public class Anomalia implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "nivel_seguridad")
    private String nivelSeveridad;
    @Column(name = "acrivo")
    private boolean activo;
    @JoinColumn(name="un_tipo_anomalia")
    @OneToOne
    private TipoAnomalia unTipoAnomalia;

    public Anomalia() {
    }

    public Anomalia(String descripcion, String nivelSeveridad, boolean activo, TipoAnomalia unTipoAnomalia) {
        this.descripcion = descripcion;
        this.nivelSeveridad = nivelSeveridad;
        this.activo = activo;
        this.unTipoAnomalia = unTipoAnomalia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivelSeveridad() {
        return nivelSeveridad;
    }

    public void setNivelSeveridad(String nivelSeveridad) {
        this.nivelSeveridad = nivelSeveridad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public TipoAnomalia getUnTipoAnomalia() {
        return unTipoAnomalia;
    }

    public void setUnTipoAnomalia(TipoAnomalia unTipoAnomalia) {
        this.unTipoAnomalia = unTipoAnomalia;
    }
}
