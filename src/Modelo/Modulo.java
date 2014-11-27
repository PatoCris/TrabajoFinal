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
@Table(name="modulos")
public class Modulo implements Serializable {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "hora_inicio")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "hora_fin")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaFin;
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @Column(name = "nro_modulo")
    private int nroModulo;
    @Column(name = "libre")
    private boolean libre;
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name="un_mecanico")
    @OneToOne
    private Mecanico unMecanico;

    public Modulo() {
    }

    public Modulo(Date horaInicio, Date horaFin, Date fecha, int nroModulo, boolean libre, boolean activo, Mecanico unMecanico) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fecha = fecha;
        this.nroModulo = nroModulo;
        this.libre = libre;
        this.activo = activo;
        this.unMecanico = unMecanico;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNroModulo() {
        return nroModulo;
    }

    public void setNroModulo(int nroModulo) {
        this.nroModulo = nroModulo;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Mecanico getUnMecanico() {
        return unMecanico;
    }

    public void setUnMecanico(Mecanico unMecanico) {
        this.unMecanico = unMecanico;
    }

  
}
