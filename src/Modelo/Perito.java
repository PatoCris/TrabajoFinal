package Modelo;


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
@Table(name="peritos")
public class Perito extends Empleado{
    @OneToMany
    private List<InformePiezaPedido> misInformesPPedido = new LinkedList<>();
  
    //solicitarAutorizacion();
    public Perito() {
    }
    
    public Perito(int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) {
        super(dni, nombre, apellido, telefono, direccion, cuil, activo);
    }

    public List<InformePiezaPedido> getMisInformesPPedido() {
        return misInformesPPedido;
    }
    
        @Override
    public String toString() {
        return super.getNombre()+" "+super.getApellido();
    }
}
