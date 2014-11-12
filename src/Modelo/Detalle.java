package Modelo;


import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;
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
@Table(name="detalles")
public class Detalle implements Serializable {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "hora")
    private Date hora;
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name="un_estado")
    @OneToOne
    private Estado unEstado;
    @OneToMany
    private List<Ejemplar> misEjemplares= new LinkedList<>();
    
    public Detalle(){
    }

    public Detalle(int codigo, Date fecha, Date hora, boolean activo, Estado unEstado) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.activo = activo;
        this.unEstado = unEstado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Estado getUnEstado() {
        return unEstado;
    }

    public void setUnEstado(Estado unEstado) {
        this.unEstado = unEstado;
    }

    public List<Ejemplar> getMisEjemplares() {
        return misEjemplares;
    }
    
}
