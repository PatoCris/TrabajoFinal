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
@Table(name="pedidos")
public class Pedido implements Serializable {
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
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "autorizado")
    private boolean autorizado;
    @Column(name = "para_recambio")
    private boolean paraRecambio;
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name="un_perito")
    @OneToOne
    private Perito unPerito;
    @JoinColumn(name="un_jefe_deposito")
    @OneToOne
    private JefeDeposito unJefeDeposito;
    @JoinColumn(name="un_jefe_taller")
    @OneToOne
    private JefeTaller unJefeTaller;
    @JoinColumn(name="un_cliente")
    @OneToOne
    @ManyToOne
    private Cliente unCliente;

    public Pedido() {
    }

    public Pedido(int codigo, Date fecha, Date hora, String descripcion, int cantidad, boolean autorizado, boolean paraRecambio, boolean activo, Perito unPerito, JefeDeposito unJefeDeposito, JefeTaller unJefeTaller, Cliente unCliente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.autorizado = autorizado;
        this.paraRecambio = paraRecambio;
        this.activo = activo;
        this.unPerito = unPerito;
        this.unJefeDeposito = unJefeDeposito;
        this.unJefeTaller = unJefeTaller;
        this.unCliente = unCliente;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }

    public boolean isParaRecambio() {
        return paraRecambio;
    }

    public void setParaRecambio(boolean paraRecambio) {
        this.paraRecambio = paraRecambio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Perito getUnPerito() {
        return unPerito;
    }

    public void setUnPerito(Perito unPerito) {
        this.unPerito = unPerito;
    }

    public JefeDeposito getUnJefeDeposito() {
        return unJefeDeposito;
    }

    public void setUnJefeDeposito(JefeDeposito unJefeDeposito) {
        this.unJefeDeposito = unJefeDeposito;
    }

    public JefeTaller getUnJefeTaller() {
        return unJefeTaller;
    }

    public void setUnJefeTaller(JefeTaller unJefeTaller) {
        this.unJefeTaller = unJefeTaller;
    }

    public Cliente getUnCliente() {
        return unCliente;
    }

    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }
    
}
