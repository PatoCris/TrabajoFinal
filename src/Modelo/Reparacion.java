package Modelo;


import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="reparaciones")
public class Reparacion extends Servicio implements Serializable{
    @Column(name = "cubierto_garantia")
    private boolean cubiertoGarantia;
    @Column(name = "cantidad_total_modulos")
    private int cantidadTotalModulos;
    @JoinColumn(name="un_tipo_reparacion")
    @OneToOne
    private TipoReparacion unTipoReparacion;
    @OneToMany
    private List<Proceso> misProcesos= new LinkedList<>();
    @OneToMany
    private List<Anomalia> misAnomalias = new LinkedList<>();

    public Reparacion() {
    }

    public Reparacion(boolean cubiertoGarantia, int cantidadTotalModulos, TipoReparacion unTipoReparacion, int codigo, String nombre, String descripcion, double costo, double impuesto, boolean activo) {
        super(codigo, nombre, descripcion, costo, impuesto, activo);
        this.cubiertoGarantia = cubiertoGarantia;
        this.cantidadTotalModulos = cantidadTotalModulos;
        this.unTipoReparacion = unTipoReparacion;
    }



    public boolean isCubiertoGarantia() {
        return cubiertoGarantia;
    }

    public void setCubiertoGarantia(boolean cubiertoGarantia) {
        this.cubiertoGarantia = cubiertoGarantia;
    }

    public int getCantidadTotalModulos() {
        return cantidadTotalModulos;
    }

    public void setCantidadTotalModulos(int cantidadTotalModulos) {
        this.cantidadTotalModulos = cantidadTotalModulos;
    }

    public void setUnTipoReparacion(TipoReparacion unTipoReparacion) {
        this.unTipoReparacion = unTipoReparacion;
    }

    public TipoReparacion getUnTipoReparacion() {
        return unTipoReparacion;
    }

    public List<Proceso> getMisProcesos() {
        return misProcesos;
    }

    public List<Anomalia> getMisAnomalias() {
        return misAnomalias;
    }
    
    
}
