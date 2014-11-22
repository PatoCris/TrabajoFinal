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
@Table(name="pieza_recambio")
public class PiezaRecambio implements Serializable {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "precio")
    private double precio;
    @Column(name = "impuesto")
    private double impuesto;
    @Column(name = "garantia")
    private boolean garantia;
    @Column(name = "caracteristica")
    private String caracteristica;
    @Column(name = "meses_garantia")
    private int mesesGarantia;
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name="grupo_parte")
    @OneToOne
    private TipoReparacion grupoParte;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Modelo> vehiculosCompatibles = new LinkedList<>();
    
    //Metodos
    //isCodigo();
    public PiezaRecambio() {
    }

    public PiezaRecambio(String nombre, double precio, double impuesto, boolean garantia, String caracteristica, int mesesGarantia, boolean activo, TipoReparacion grupoParte) {
        this.nombre = nombre;
        this.precio = precio;
        this.impuesto = impuesto;
        this.garantia = garantia;
        this.caracteristica = caracteristica;
        this.mesesGarantia = mesesGarantia;
        this.activo = activo;
        this.grupoParte = grupoParte;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public boolean isGarantia() {
        return garantia;
    }

    public void setGarantia(boolean garantia) {
        this.garantia = garantia;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    public void setMesesGarantia(int mesesGarantia) {
        this.mesesGarantia = mesesGarantia;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public TipoReparacion getGrupoParte() {
        return grupoParte;
    }

    public void setGrupoParte(TipoReparacion grupoParte) {
        this.grupoParte = grupoParte;
    }

    public List<Modelo> getVehiculosCompatibles() {
        return vehiculosCompatibles;
    }

    public void setVehiculosCompatibles(List<Modelo> vehiculosCompatibles) {
        this.vehiculosCompatibles = vehiculosCompatibles;
    }
    
}