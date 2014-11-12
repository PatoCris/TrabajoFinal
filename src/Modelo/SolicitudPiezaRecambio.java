package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="solicitud_pieza_recambio")
public class SolicitudPiezaRecambio implements Serializable {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nivel_importancia")
    private String nivelImportancia;
    @Column(name = "tiempo_espera")
    private String tiempoEspera;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name="un_proveedor")
    @OneToOne
    private Proveedor unProveedor;
    @JoinColumn(name="una_pieza_recambio")
    @OneToOne
    private PiezaRecambio unaPiezaRecambio;
    @JoinColumn(name="un_informe_pieza_pedido")
    @OneToOne
    private InformePiezaPedido unInformePiezaPedido;

    public SolicitudPiezaRecambio() {
    }

    public SolicitudPiezaRecambio(int codigo, String nombre, String nivelImportancia, String tiempoEspera, int cantidad, boolean activo, Proveedor unProveedor, PiezaRecambio unaPiezaRecambio, InformePiezaPedido unInformePiezaPedido) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelImportancia = nivelImportancia;
        this.tiempoEspera = tiempoEspera;
        this.cantidad = cantidad;
        this.activo = activo;
        this.unProveedor = unProveedor;
        this.unaPiezaRecambio = unaPiezaRecambio;
        this.unInformePiezaPedido = unInformePiezaPedido;
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

    public String getNivelImportancia() {
        return nivelImportancia;
    }

    public void setNivelImportancia(String nivelImportancia) {
        this.nivelImportancia = nivelImportancia;
    }

    public String getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(String tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Proveedor getUnProveedor() {
        return unProveedor;
    }

    public void setUnProveedor(Proveedor unProveedor) {
        this.unProveedor = unProveedor;
    }

    public PiezaRecambio getUnaPiezaRecambio() {
        return unaPiezaRecambio;
    }

    public void setUnaPiezaRecambio(PiezaRecambio unaPiezaRecambio) {
        this.unaPiezaRecambio = unaPiezaRecambio;
    }

    public InformePiezaPedido getUnInformePiezaPedido() {
        return unInformePiezaPedido;
    }

    public void setUnInformePiezaPedido(InformePiezaPedido unInformePiezaPedido) {
        this.unInformePiezaPedido = unInformePiezaPedido;
    }


}
