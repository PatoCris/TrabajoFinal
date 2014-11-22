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
@Table(name="ejemplares")
public class Ejemplar implements Serializable {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "fecha_ingreso")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name="una_pieza_recambio")
    @OneToOne
    private PiezaRecambio unaPiezaRecambio;
    @JoinColumn(name="un_proveedor")
    @OneToOne
    private Proveedor unProveedor;

    public Ejemplar() {
    }

    public Ejemplar(Date fechaIngreso, PiezaRecambio unaPiezaRecambio, Proveedor unProveedor, boolean activo) {
        this.fechaIngreso = fechaIngreso;
        this.unaPiezaRecambio = unaPiezaRecambio;
        this.unProveedor = unProveedor;
        this.activo = activo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public PiezaRecambio getUnaPiezaRecambio() {
        return unaPiezaRecambio;
    }

    public void setUnaPiezaRecambio(PiezaRecambio unaPiezaRecambio) {
        this.unaPiezaRecambio = unaPiezaRecambio;
    }

    public Proveedor getUnProveedor() {
        return unProveedor;
    }

    public void setUnProveedor(Proveedor unProveedor) {
        this.unProveedor = unProveedor;
    }
    
    
}
