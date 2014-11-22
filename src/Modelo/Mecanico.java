package Modelo;


import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
@Table(name="mecanicos")
public class Mecanico extends Empleado implements Serializable{
    @OneToMany
    private List<Especialidad> misEspecialidades = new LinkedList<>();
    @OneToMany
    private List<Pedido> misPedidos = new LinkedList<>();
    
    //crearPedido();

    public Mecanico() {
    }

    public Mecanico(int codigo, int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) {
        super(dni, nombre, apellido, telefono, direccion, cuil, activo);
    }
        @Override
    public String toString() {
        return "Mecánico";
    }
}
