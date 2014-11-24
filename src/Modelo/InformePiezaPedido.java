package Modelo;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="informe_pieza_pedido")
public class InformePiezaPedido implements Serializable {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "aprobado")
    private boolean aprobado;
    @Column(name = "hora")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date hora;
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fecha;
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name="una_pieza")
    @OneToOne
    private PiezaRecambio unaPieza; 

    public InformePiezaPedido() {
    }

    public InformePiezaPedido( boolean aprobado, java.util.Date fecha, boolean activo, PiezaRecambio unaPieza) {
        this.aprobado = aprobado;
        this.fecha = fecha;
        this.activo = activo;
        this.unaPieza = unaPieza;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public java.util.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.util.Date fecha) {
        this.fecha = fecha;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public PiezaRecambio getUnaPieza() {
        return unaPieza;
    }

    public void setUnaPieza(PiezaRecambio unaPieza) {
        this.unaPieza = unaPieza;
    }
    
    
}
