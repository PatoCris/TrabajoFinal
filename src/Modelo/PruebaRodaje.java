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
@Table(name="prueba_rodaje")
public class PruebaRodaje implements Serializable {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @Column(name = "hora")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date hora;
    @Column(name = "km_recorrido")
    private long kmRecorrido;
    @Column(name = "activo")
    private boolean activo;
    @OneToMany
    private List<ReposicionCarburador> misReposiciones = new LinkedList<>();
    @OneToMany
    private List<Vehiculo> misVehiculos = new LinkedList<>();

    public PruebaRodaje() {
    }

    public PruebaRodaje(int codigo, Date fecha, Date hora, long kmRecorrido, boolean activo) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.kmRecorrido = kmRecorrido;
        this.activo = activo;
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

    public long getKmRecorrido() {
        return kmRecorrido;
    }

    public void setKmRecorrido(long kmRecorrido) {
        this.kmRecorrido = kmRecorrido;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<ReposicionCarburador> getMisReposiciones() {
        return misReposiciones;
    }

    public List<Vehiculo> getMisVehiculos() {
        return misVehiculos;
    }
    
    
}
