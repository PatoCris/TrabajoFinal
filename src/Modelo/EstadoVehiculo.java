package Modelo;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="estado_vehiculo")
public class EstadoVehiculo implements Serializable {
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
    @Column(name = "detalle")
    private String detalle;
    @Column(name = "kilometraje")
    private long kilometraje;
    @Column(name = "carroceria")
    private boolean carroceria;
    @Column(name = "motor")
    private boolean motor;
    @Column(name = "electricidad")
    private boolean electricidad;
    @Column(name = "luminaria")
    private boolean luminaria;
    @Column(name = "electronica")
    private boolean electronica;
    @Column(name = "nuematico")
    private boolean neumatico;
    @Column(name = "amortiguacion")
    private boolean amortiguacion;
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name="un_vehiculo")
    @OneToOne
    @ManyToOne
    private Vehiculo unVehiculo;
    @JoinColumn(name="mi_estado_ingreso")
    @OneToOne
    private EstadoVehiculo miEstadoIngreso;

    public EstadoVehiculo() {
    }

    public EstadoVehiculo(int codigo, Date fecha, Date hora, String detalle, long kilometraje, boolean carroceria, boolean motor, boolean electricidad, boolean luminaria, boolean electronica, boolean neumatico, boolean amortiguacion, boolean activo, Vehiculo unVehiculo, EstadoVehiculo miEstadoIngreso) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.detalle = detalle;
        this.kilometraje = kilometraje;
        this.carroceria = carroceria;
        this.motor = motor;
        this.electricidad = electricidad;
        this.luminaria = luminaria;
        this.electronica = electronica;
        this.neumatico = neumatico;
        this.amortiguacion = amortiguacion;
        this.activo = activo;
        this.unVehiculo = unVehiculo;
        this.miEstadoIngreso = miEstadoIngreso;
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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public long getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(long kilometraje) {
        this.kilometraje = kilometraje;
    }

    public boolean isCarroceria() {
        return carroceria;
    }

    public void setCarroceria(boolean carroceria) {
        this.carroceria = carroceria;
    }

    public boolean isMotor() {
        return motor;
    }

    public void setMotor(boolean motor) {
        this.motor = motor;
    }

    public boolean isElectricidad() {
        return electricidad;
    }

    public void setElectricidad(boolean electricidad) {
        this.electricidad = electricidad;
    }

    public boolean isLuminaria() {
        return luminaria;
    }

    public void setLuminaria(boolean luminaria) {
        this.luminaria = luminaria;
    }

    public boolean isElectronica() {
        return electronica;
    }

    public void setElectronica(boolean electronica) {
        this.electronica = electronica;
    }

    public boolean isNeumatico() {
        return neumatico;
    }

    public void setNeumatico(boolean neumatico) {
        this.neumatico = neumatico;
    }

    public boolean isAmortiguacion() {
        return amortiguacion;
    }

    public void setAmortiguacion(boolean amortiguacion) {
        this.amortiguacion = amortiguacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Vehiculo getUnVehiculo() {
        return unVehiculo;
    }

    public void setUnVehiculo(Vehiculo unVehiculo) {
        this.unVehiculo = unVehiculo;
    }

    public EstadoVehiculo getMiEstadoIngreso() {
        return miEstadoIngreso;
    }

    public void setMiEstadoIngreso(EstadoVehiculo miEstadoIngreso) {
        this.miEstadoIngreso = miEstadoIngreso;
    }
   
    
}
