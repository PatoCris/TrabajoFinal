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
@Table(name="devoluciones")
public class Devolucion implements Serializable {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @Column(name = "motivo")
    private String motivo;
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name="mi_pieza_recambio")
    @OneToOne
    private PiezaRecambio miPiezaRecambio;

    public Devolucion() {
    }

    public Devolucion(int codigo, Date fecha, String motivo, boolean activo, PiezaRecambio miPiezaRecambio) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.motivo = motivo;
        this.activo = activo;
        this.miPiezaRecambio = miPiezaRecambio;
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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public PiezaRecambio getMiPiezaRecambio() {
        return miPiezaRecambio;
    }

    public void setMiPiezaRecambio(PiezaRecambio miPiezaRecambio) {
        this.miPiezaRecambio = miPiezaRecambio;
    }
    
    
}
