package Modelo;


import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="agenda_mensual")
public class AgendaMensual implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "anio")
    private int anio;
    @Column(name = "nro_mes")
    private int nroMes;
    @Column(name = "activo")
    private boolean activo;
   
    @OneToMany
    private List<Turno> misTurnos= new LinkedList<>();
    @OneToMany
    private List<Modulo> misModulos = new LinkedList<>();

    //Metodos
    //buscarModuloDisponible();
    public AgendaMensual() {
    }

    public AgendaMensual(int codigo, String nombre, int anio, int nroMes, boolean activo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.anio = anio;
        this.nroMes = nroMes;
        this.activo = activo;
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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getNroMes() {
        return nroMes;
    }

    public void setNroMes(int nroMes) {
        this.nroMes = nroMes;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Turno> getMisTurnos() {
        return misTurnos;
    }

    public List<Modulo> getMisModulos() {
        return misModulos;
    }
   
    
}
