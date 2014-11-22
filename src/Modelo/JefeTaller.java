package Modelo;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.Entity;
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
@Table(name="jefe_taller")
public class JefeTaller extends Empleado implements Serializable{

    public JefeTaller() {
    }
    
    
    //autorizarPedidoPieza();

    public JefeTaller(int codigo, int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) {
        super(dni, nombre, apellido, telefono, direccion, cuil, activo);
    }

    @Override
    public String toString() {
        return "Jefe de Taller";
    }

    
}
