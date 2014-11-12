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
@Table(name="vehiculos")
public class Vehiculo implements Serializable {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "dominio")
    private String dominio;
    @Column(name = "nro_chasis")
    private String nroChasis;
    @Column(name = "nro_motor")
    private String nroMotor;
    @Column(name = "anio")
    private int anio;
    @Column(name = "km_recorrido")
    private long kmRecorrido;
    @Column(name = "fecha_comra")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCompra;
    @Column(name = "activo")
    private boolean activo;
    @Column(name = "una_garantia")
    private Garantia unaGarantia;
    @Column(name = "un_modelo")
    private Modelo unModelo;
    @OneToMany
    private List<Accesorio> misAccesorios = new LinkedList<>();
    @OneToMany(mappedBy = "miCurso")
    private List<EstadoVehiculo> misEstados = new LinkedList<>();
    
    //METODOS
    //isDominio();
    public Vehiculo() {
    }

    public Vehiculo(int codigo, String dominio, String nroChasis, String nroMotor, int anio, long kmRecorrido, Date fechaCompra, boolean activo, Garantia unaGarantia, Modelo unModelo) {
        this.codigo = codigo;
        this.dominio = dominio;
        this.nroChasis = nroChasis;
        this.nroMotor = nroMotor;
        this.anio = anio;
        this.kmRecorrido = kmRecorrido;
        this.fechaCompra = fechaCompra;
        this.activo = activo;
        this.unaGarantia = unaGarantia;
        this.unModelo = unModelo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getNroChasis() {
        return nroChasis;
    }

    public void setNroChasis(String nroChasis) {
        this.nroChasis = nroChasis;
    }

    public String getNroMotor() {
        return nroMotor;
    }

    public void setNroMotor(String nroMotor) {
        this.nroMotor = nroMotor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public long getKmRecorrido() {
        return kmRecorrido;
    }

    public void setKmRecorrido(long kmRecorrido) {
        this.kmRecorrido = kmRecorrido;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Garantia getUnaGarantia() {
        return unaGarantia;
    }

    public void setUnaGarantia(Garantia unaGarantia) {
        this.unaGarantia = unaGarantia;
    }

    public Modelo getUnModelo() {
        return unModelo;
    }

    public void setUnModelo(Modelo unModelo) {
        this.unModelo = unModelo;
    }

    public List<Accesorio> getMisAccesorios() {
        return misAccesorios;
    }

    public List<EstadoVehiculo> getMisEstados() {
        return misEstados;
    }

    public void setMisAccesorios(List<Accesorio> misAccesorios) {
        this.misAccesorios = misAccesorios;
    }

    public void setMisEstados(List<EstadoVehiculo> misEstados) {
        this.misEstados = misEstados;
    }
    
    
}
