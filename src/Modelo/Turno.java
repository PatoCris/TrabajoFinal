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
import javax.persistence.JoinColumn;
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
@Table(name="turnos")
public class Turno implements Serializable {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fecha;
    @Column(name = "hora")
    @Temporal(javax.persistence.TemporalType.TIME)
    private java.util.Date hora;
    @Column(name = "fechaFin")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaFin;
    @Column(name = "horaFin")
    @Temporal(javax.persistence.TemporalType.TIME)
    private java.util.Date horaFin;
    @Column(name = "activo")
    private boolean activo;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Modulo> misModulos = new LinkedList<>();
    @JoinColumn(name="un_servicio")
    @OneToOne
    private Servicio unServicio;
    @JoinColumn(name="un_vehiculo")
    @OneToOne
    private Vehiculo unVehiculo;
    @JoinColumn(name="un_cliente")
    @OneToOne
    private Cliente unCliente;
    
     @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Detalle> misDetalles = new LinkedList<>();

    public Turno() {
    }

    public Turno(boolean activo, Servicio unServicio, Vehiculo unVehiculo, Cliente unCliente) {
        this.activo = activo;
        this.unServicio = unServicio;
        this.unVehiculo = unVehiculo;
        this.unCliente = unCliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public java.util.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.util.Date fecha) {
        this.fecha = fecha;
    }

    public java.util.Date getHora() {
        return hora;
    }

    public void setHora(java.util.Date hora) {
        this.hora = hora;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Servicio getUnServicio() {
        return unServicio;
    }

    public void setUnServicio(Servicio unServicio) {
        this.unServicio = unServicio;
    }

    public Vehiculo getUnVehiculo() {
        return unVehiculo;
    }

    public void setUnVehiculo(Vehiculo unVehiculo) {
        this.unVehiculo = unVehiculo;
    }

    public Cliente getUnCliente() {
        return unCliente;
    }

    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }

    public List<Modulo> getMisModulos() {
        return misModulos;
    }

    public void setMisModulos(List<Modulo> misModulos) {
        this.misModulos = misModulos;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public List<Detalle> getMisDetalles() {
        return misDetalles;
    }

    public void setMisDetalles(List<Detalle> misDetalles) {
        this.misDetalles = misDetalles;
    }

    
}
