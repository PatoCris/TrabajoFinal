package Modelo;


import java.io.Serializable;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

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
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    @Column(name = "hora")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date hora;
    
    @Column(name = "activo")
    private boolean activo;
    
    @Column(name = "descripcion")
    private String descripcion;

    @OneToOne
    private Estado unEstado;
    
    @OneToOne
    private Proceso unProceso;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Ejemplar> misEjemplares= new LinkedList<>();
    
    public Detalle(){
    }

    public Detalle(Date fecha, Date hora, boolean activo, String descripcion, Estado unEstado, Proceso unProceso) {
        this.fecha = fecha;
        this.hora = hora;
        this.activo = activo;
        this.descripcion = descripcion;
        this.unEstado = unEstado;
        this.unProceso = unProceso;
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

    public Proceso getUnProceso() {
        return unProceso;
    }

    public void setUnProceso(Proceso unProceso) {
        this.unProceso = unProceso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMisEjemplares(List<Ejemplar> misEjemplares) {
        this.misEjemplares = misEjemplares;
    }
}
