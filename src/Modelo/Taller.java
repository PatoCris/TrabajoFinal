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
@Table(name="talleres")
public class Taller implements Serializable {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "correo")
    private String correo;
    @Column(name = "hora_entrada")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date horaEntrada;
    @Column(name = "hora_salida")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date horaSalida;
    @Column(name = "activo")
    private boolean activo;
    
    @JoinColumn(name="un_deposito")
    @OneToOne
    private Deposito unDeposito;
    
    @JoinColumn(name="un_jefe_taller")
    @OneToOne    
    private JefeTaller unJefeTaller;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Mecanico> misMecanicos = new LinkedList<>();
    
    @JoinColumn(name="una_localidad")
    @OneToOne
    private Localidad unaLocalidad;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<AgendaMensual> misAgendasMensuales = new LinkedList<>();
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Sector> misSectores = new LinkedList<>();
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Perito> misPeritos = new LinkedList<>();
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Localidad> zonasCubiertas = new LinkedList<>();

    public Taller() {
    }

    public Taller(String nombre, String direccion, String telefono, String correo, Date horaEntrada, Date horaSalida, boolean activo, Deposito unDeposito, JefeTaller unJefeTaller, Localidad unaLocalidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.activo = activo;
        this.unDeposito = unDeposito;
        this.unJefeTaller = unJefeTaller;
        this.unaLocalidad = unaLocalidad;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Deposito getUnDeposito() {
        return unDeposito;
    }

    public void setUnDeposito(Deposito unDeposito) {
        this.unDeposito = unDeposito;
    }

    public JefeTaller getUnJefeTaller() {
        return unJefeTaller;
    }

    public void setUnJefeTaller(JefeTaller unJefeTaller) {
        this.unJefeTaller = unJefeTaller;
    }

    public Localidad getUnaLocalidad() {
        return unaLocalidad;
    }

    public void setUnaLocalidad(Localidad unaLocalidad) {
        this.unaLocalidad = unaLocalidad;
    }

    public List<AgendaMensual> getMisAgendasMensuales() {
        return misAgendasMensuales;
    }

    public List<Sector> getMisSectores() {
        return misSectores;
    }

    public List<Perito> getMisPeritos() {
        return misPeritos;
    }

    public List<Localidad> getZonasCubiertas() {
        return zonasCubiertas;
    }
        
}
