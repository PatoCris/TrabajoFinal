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
@Table(name="depositos")
public class Deposito implements Serializable {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "correo")
    private String correo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "activo")
    private boolean activo;
    
    @JoinColumn(name="un_jefe_deposito")
    @OneToOne
    private JefeDeposito unJefeDeposito;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Ejemplar> misEjemplares = new LinkedList<>();
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Devolucion> misDevoluciones = new LinkedList<>();
    
    
    //Metodos
    //buscarPieza()
    public Deposito() {
    }

    public Deposito(String nombre, String correo, String telefono, boolean activo, JefeDeposito unJefeDeposito) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.activo = activo;
        this.unJefeDeposito = unJefeDeposito;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public JefeDeposito getUnJefeDeposito() {
        return unJefeDeposito;
    }

    public void setUnJefeDeposito(JefeDeposito unJefeDeposito) {
        this.unJefeDeposito = unJefeDeposito;
    }

    public List<Ejemplar> getMisEjemplares() {
        return misEjemplares;
    }

    public void setMisEjemplares(List<Ejemplar> misEjemplares) {
        this.misEjemplares = misEjemplares;
    }

    public List<Devolucion> getMisDevoluciones() {
        return misDevoluciones;
    }

    public void setMisDevoluciones(List<Devolucion> misDevoluciones) {
        this.misDevoluciones = misDevoluciones;
    }
}
