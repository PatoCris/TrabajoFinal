package Modelo;


import java.io.Serializable;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="diagnosticos")
public class Diagnostico extends Servicio implements Serializable{
    @JoinColumn(name="mi_pieza_recambio")
    @OneToOne
    private TipoDiagnostico unTipoDiagnostico;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Anomalia> misAnomalias= new LinkedList<>();

    public Diagnostico() {
    }

    public Diagnostico(TipoDiagnostico unTipoDiagnostico, String nombre, String descripcion, double costo, double impuesto, boolean activo) {
        super( nombre, descripcion, costo, impuesto, activo);
        this.unTipoDiagnostico = unTipoDiagnostico;
    }
    

    public Diagnostico(TipoDiagnostico unTipoDiagnostico) {
        this.unTipoDiagnostico = unTipoDiagnostico;
    }

    public TipoDiagnostico getUnTipoDiagnostico() {
        return unTipoDiagnostico;
    }

    public List<Anomalia> getMisAnomalias() {
        return misAnomalias;
    }

    public void setMisAnomalias(List<Anomalia> misAnomalias) {
        this.misAnomalias = misAnomalias;
    }

    public void setUnTipoDiagnostico(TipoDiagnostico unTipoDiagnostico) {
        this.unTipoDiagnostico = unTipoDiagnostico;
    }

    @Override
    public String toString() {
        return getNombre();
    }

    
}
