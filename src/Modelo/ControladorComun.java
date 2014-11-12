/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Persistencia.ControladoraPersistencia;

/**
 *
 * @author cristian
 */
public class ControladorComun {
    private ControladoraPersistencia cp = new ControladoraPersistencia();
    private Empleado unEmpleado;

    public ControladorComun() {
    }
    ////////////////////////////// METODOS EMPLEADO ///////////////////////////////
    public Empleado nuevoEmpleado (int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception{
        unEmpleado = new Empleado(dni, nombre, apellido, telefono, direccion, cuil, activo);
        return unEmpleado;
    }
    
    public Empleado editarEmpleado(int codigo, int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception{
        unEmpleado = cp.traerEmpleado(codigo);
        unEmpleado.setDni(dni);
        unEmpleado.setNombre(nombre);
        unEmpleado.setApellido(apellido);
        unEmpleado.setTelefono(telefono);
        unEmpleado.setDireccion(direccion);
        unEmpleado.setCuil(cuil);
        return unEmpleado;
    }
    public void eliminarEmpleado(int codigo) throws Exception{
        unEmpleado = cp.traerEmpleado(codigo);
        unEmpleado.setActivo(false);
    }
}
