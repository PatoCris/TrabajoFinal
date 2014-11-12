/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Persistencia.ControladoraPersistencia;
import java.util.Date;
import java.util.List;
import vista.frmMenu;

/**
 *
 * @author cristian
 */
public class ControladoraPrincipal {
    private Accesorio unAccesorio = new Accesorio();
    private Marca unaMarca = new Marca();
    private TipoReparacion unTipoReparacion = new TipoReparacion();
    private TipoAnomalia unTipoAnomalia = new TipoAnomalia();
    private Anomalia unaAnomalia = new Anomalia();
    private Equipamiento unEquipamiento = new Equipamiento();
    private Segmento unSegmento = new Segmento();
    private Modelo unModelo = new Modelo();
    private Estado unEstado = new Estado();
    private Especialidad unaEspecialidad = new Especialidad();
    private Empleado unEmpleado = new Empleado();
    private Vehiculo unVehiculo = new Vehiculo();
 
    ///////////// CONTROLADORA PERSISTENCIA ////////////////
    private ControladoraPersistencia cp = new ControladoraPersistencia();
    
    ///////////// MÉTODOS DE ACCESORIO ///////////////////
    public void nuevoAccesorio(String nombre, String descripcion) throws Exception{
        unAccesorio = new Accesorio(nombre, descripcion, true);
        cp.crearAccesorio(unAccesorio);
    }

    public void editarAccesorio(int codigo, String nombre, String descripcion) throws Exception{
        unAccesorio = cp.traerAccesorio(codigo);
        unAccesorio.setNombre(nombre);
        unAccesorio.setDescripcion(descripcion);
        cp.editarAccesorio(unAccesorio);
    }
    public List<Accesorio> traerAccesorios(boolean activo) throws Exception{
        return cp.traerAccesorios(activo);
    }
    public void eliminarAccesorio(int codigo) throws Exception{
        unAccesorio = cp.traerAccesorio(codigo);
        unAccesorio.setActivo(false);
        cp.editarAccesorio(unAccesorio);
    }
    public List<Accesorio> traerAccesoriosNombre(boolean activo, String nombre) throws Exception{
        return cp.traerAccesoriosNombre(activo, nombre);
    }
    
    ///////////// MÉTODOS DE MARCA ///////////////////
    public void nuevaMarca(String nombre, String descripcion) throws Exception{
        unaMarca = new Marca(nombre, descripcion, true);
        cp.nuevaMarca(unaMarca);
    }
    public void editarMarca(int codigo, String nombre, String descripcion) throws Exception{
        unaMarca = cp.traerMarca(codigo);
        unaMarca.setNombre(nombre);
        unaMarca.setDescripcion(descripcion);
        cp.editarMarca(unaMarca);
    }
    public List<Marca> traerMarcas(boolean activo) throws Exception{
        return cp.traerMarcas(activo);
    }
    public void eliminarMarca(int codigo) throws Exception{
        unaMarca = cp.traerMarca(codigo);
        unaMarca.setActivo(false);
        cp.editarMarca(unaMarca);
    }
    public List<Marca> traerMarcasNombre(boolean activo, String nombre) throws Exception{
        return cp.traerMarcasNombre(activo, nombre);
    }
    
    ///////////////// MÉTODOS DE TIPO REPARACION ///////////////////
    public void nuevoTipoReparacion(String nombre, String descripcion) throws Exception{
        unTipoReparacion = new TipoReparacion(nombre, descripcion, true);
        cp.nuevoTipoReparacion(unTipoReparacion);
    }
    public void editarTipoReparacion(int codigo, String nombre, String descripcion) throws Exception{
        unTipoReparacion = cp.traerTR(codigo);
        unTipoReparacion.setNombre(nombre);
        unTipoReparacion.setDescripcion(descripcion);
        cp.editarTipoReparacion(unTipoReparacion);
    }
    public List<TipoReparacion> traerTipoReparacion(boolean activo) throws Exception{
        return cp.traerTipoReparacion(activo);
    }
    public void eliminarTipoReparacion(int codigo) throws Exception{
        unTipoReparacion = cp.traerTR(codigo);
        unTipoReparacion.setActivo(false);
        cp.editarTipoReparacion(unTipoReparacion);
    }
    public List<TipoReparacion> traerTipoReparacionNombre(boolean activo, String nombre) throws Exception{
        return cp.traerTipoReparacionNombre(activo, nombre);
    }
    
    ///////////////// MÉTODOS DE ANOMALIA ///////////////////
    public void nuevaAnomalia(String nivelSeveridad, String descripcion, TipoAnomalia tipoAnomalia, boolean activo) throws Exception{
        unaAnomalia = new Anomalia(descripcion, nivelSeveridad, activo, tipoAnomalia);
        cp.nuevoAnomalia(unaAnomalia);
    }
    public void editarAnomalia(int codigo, String descripcion, String nivelSeveridad, TipoAnomalia tipoAnomalia) throws Exception{
        unaAnomalia = cp.traerAnomalia(codigo);
        unaAnomalia.setDescripcion(descripcion);
        unaAnomalia.setNivelSeveridad(nivelSeveridad);
        unaAnomalia.setUnTipoAnomalia(unTipoAnomalia);
        cp.editarAnomalia(unaAnomalia);
    }
    public List<Anomalia> traerAnomalias(boolean activo) throws Exception{
        return cp.traerAnomalias(activo);
    }
    public void eliminarAnomalia(int codigo) throws Exception{
        unaAnomalia = cp.traerAnomalia(codigo);
        unaAnomalia.setActivo(false);
        cp.editarAnomalia(unaAnomalia);
    }
    public List<Anomalia> traerAnomaliasBusqueda(boolean activo, String nivel, TipoAnomalia tipo) throws Exception{
        return cp.traerAnomaliasBusqueda(activo, nivel, tipo);
    }
    
    ////////////////// MÉTODOS DE TIPO ANOMALIA /////////////////////////
    public void nuevoTipoAnomalia(String nombre) throws Exception{
        unTipoAnomalia = new TipoAnomalia(nombre, true);
        cp.nuevoTipoAnomalia(unTipoAnomalia);
    }
    public void editarTipoAnomalia(int codigo, String nombre) throws Exception{
        unTipoAnomalia = cp.traerTA(codigo);
        unTipoAnomalia.setNombre(nombre);
        cp.editarTipoAnomalia(unTipoAnomalia);
    }
    public List<TipoAnomalia> traerTipoAnomalia(boolean activo) throws Exception{
        return cp.traerTipoAnomalia(activo);
    }
    public void eliminarTipoAnomalia(int codigo) throws Exception{
        unTipoAnomalia = cp.traerTA(codigo);
        unTipoAnomalia.setActivo(false);
        cp.editarTipoAnomalia(unTipoAnomalia);
    }
    public List<TipoAnomalia> traerTipoAnomaliaNombre(boolean activo, String nombre) throws Exception{
        return cp.traerTipoAnomaliaNombre(activo, nombre);
    }
    
    ////////////////// MÉTODOS DE EQUIPAMIENTO ////////////////////////
    public void nuevoEquipamiento(String nombre, String descripcion) throws Exception{
        unEquipamiento = new Equipamiento(nombre, descripcion, true);
        cp.nuevoEquipamiento(unEquipamiento);
    }
    public void editarEquipamiento(int codigo, String nombre, String descripcion) throws Exception{
        unEquipamiento = cp.traerEquipamiento(codigo);
        unEquipamiento.setNombre(nombre);
        unEquipamiento.setDescripcion(descripcion);
        cp.editarEquipamiento(unEquipamiento);
    }
    public List<Equipamiento> traerEquipamientos(boolean activo) throws Exception{
        return cp.traerEquipamientos(activo);
    }
    public void eliminarEquipamiento(int codigo) throws Exception{
        unEquipamiento = cp.traerEquipamiento(codigo);
        unEquipamiento.setActivo(false);
        cp.editarEquipamiento(unEquipamiento);
    }
    public List<Equipamiento> traerEquipamientosNombre(boolean activo, String nombre) throws Exception{
        return cp.traerEquipamientosNombre(activo, nombre);
    }
    
        ////////////////// MÉTODOS DE SEGMENTO ////////////////////////
    public void nuevoSegmento(String nombre, String descripcion) throws Exception{
        unSegmento = new Segmento(nombre, descripcion, true);
        cp.nuevoSegmento(unSegmento);
    }
    public void editarSegmento(int codigo, String nombre, String descripcion) throws Exception{
        unSegmento = cp.traerSegmento(codigo);
        unSegmento.setNombre(nombre);
        unSegmento.setDescripcion(descripcion);
        cp.editarSegmento(unSegmento);
    }
    public List<Segmento> traerSegmentos(boolean activo) throws Exception{
        return cp.traerSegmentos(activo);
    }
    public void eliminarSegmento(int codigo) throws Exception{
        unSegmento = cp.traerSegmento(codigo);
        unSegmento.setActivo(false);
        cp.editarSegmento(unSegmento);
    }
    public List<Segmento> traerSegmentosNombre(boolean activo, String nombre) throws Exception{
        return cp.traerSegmentosNombre(activo, nombre);
    }
    //AAAAAACAAAAAAAAAA TENGO QUE SEGUIIIIIIIIIIIIIIIIIIIIIIIIRRRRRRRRRRRRRRRRRRRRR
    ////////////////// MÉTODOS DE MODELO ////////////////////////
    public void nuevoModelo(String nombre, String descripcion, Marca marca, Segmento segmento) throws Exception{
        unModelo = new Modelo(nombre, descripcion, true, marca, segmento);
        cp.nuevoModelo(unModelo);
    }
    public void editarModelo(int codigo, String nombre, String descripcion, Marca marca, Segmento segmento) throws Exception{
        unModelo = cp.traerModelo(codigo);
        unModelo.setDescripcion(descripcion);
        unModelo.setNombre(nombre);
        unModelo.setUnaMarca(marca);
        unModelo.setUnSegmento(segmento);
        cp.editarModelo(unModelo);
    }
    public List<Modelo> traerModelos(boolean activo) throws Exception{
        return cp.traerModelos(activo);
    }
    public void eliminarModelo(int codigo) throws Exception{
        unModelo = cp.traerModelo(codigo);
        unModelo.setActivo(false);
        cp.editarModelo(unModelo);
    }
    public List<Modelo> traerModelosNombre(boolean activo, String nombre) throws Exception{
        return cp.traerModelosNombre(activo, nombre);
    }
    
    ////////////////// MÉTODOS DE EMPLEADO ////////////////////////
    public void nuevoEmpleado (int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception{
        unEmpleado = new Empleado(dni, nombre, apellido, telefono, direccion, cuil, activo);
        cp.nuevoEmpleado(unEmpleado);
    }
    public void editarEmpleado(int codigo, int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception{
        unEmpleado = cp.traerEmpleado(codigo);
        unEmpleado.setDni(dni);
        unEmpleado.setNombre(nombre);
        unEmpleado.setApellido(apellido);
        unEmpleado.setTelefono(telefono);
        unEmpleado.setDireccion(direccion);
        unEmpleado.setCuil(cuil);
        cp.editarEmpleado(unEmpleado);
    }
    public List<Empleado> traerEmpleados(boolean activo) throws Exception{
        return cp.traerEmpleados(activo);
    }
    public void eliminarEmpleado(int codigo) throws Exception{
        unEmpleado = cp.traerEmpleado(codigo);
        unEmpleado.setActivo(false);
        cp.editarEmpleado(unEmpleado);
    }
    public List<Empleado> traerEmpleadossBusqueda(boolean activo, String apellido, int dni) throws Exception{
        return cp.traerEmpleadosBusqueda(activo, apellido, dni);
    }
    
    ///////////////// METODOS DE ESPECIALIDAD ///////////////////
    public void nuevaEspecialidad(String nombre, String descripcion) throws Exception{
        unaEspecialidad = new Especialidad(nombre, descripcion, true);
        cp.nuevaEspecialidad(unaEspecialidad);
    }
    public void editarEspecialidad(int codigo, String nombre, String descripcion) throws Exception{
        unaEspecialidad = cp.traerEspecialidad(codigo);
        unaEspecialidad.setNombre(nombre);
        unaEspecialidad.setDescripcion(descripcion);
        cp.editarEspecialidad(unaEspecialidad);
    }
    public List<Especialidad> traerEspecialidad(boolean activo) throws Exception{
        return cp.traerEspecialidades(activo);
    }
    public List<Especialidad> traerEspecialidadesNombre(boolean activo, String nombre)throws Exception{
        return cp.traerEspecialidadesNombre(activo, nombre);
    }
    public void eliminarEspecialidad(int codigo) throws Exception{
        unaEspecialidad = cp.traerEspecialidad(codigo);
        unaEspecialidad.setActivo(false);
        cp.editarEspecialidad(unaEspecialidad);
    }
    
     ///////////////// METODOS DE ESTADO ///////////////////
    public void nuevoEstado(String nombre, String descripcion) throws Exception{
        unEstado = new Estado(nombre, descripcion, true);
        cp.nuevoEstado(unEstado);
    }
    public void editarEstado(int codigo, String nombre, String descripcion) throws Exception{
        unEstado = cp.traerEstado(codigo);
        unEstado.setNombre(nombre);
        unEstado.setDescripcion(descripcion);
        cp.editarEstado(unEstado);
    }
    public List<Estado> traerEstado(boolean activo) throws Exception{
        return cp.traerEstados(activo);
    }
    public List<Estado> traerEstadosNombre(boolean activo, String nombre)throws Exception{
        return cp.traerEstadosNombre(activo, nombre);
    }
    public void eliminarEstado(int codigo) throws Exception{
        unEstado = cp.traerEstado(codigo);
        unEstado.setActivo(false);
        cp.editarEstado(unEstado);
    }
    
    ///////////// MÉTODOS DE VEHICULO ///////////////////
    public void nuevoVehiculo(String dominio, String nroChasis, String nroMotor, int anio, long kmRecorrido, Date fechaCompra, boolean activo, Modelo unModelo) throws Exception{
        unVehiculo = new Vehiculo(dominio, nroChasis, nroMotor, anio, kmRecorrido, fechaCompra, true, unModelo);
        cp.crearVehiculo(unVehiculo);
    }
    public void editarVehiculo(String dominio, String nroChasis, String nroMotor, int anio, long kmRecorrido, Date fechaCompra, boolean activo, Modelo unModelo) throws Exception{
        unVehiculo = cp.traerVehiculo(anio);
        unVehiculo.setDominio(dominio);
        unVehiculo.setNroChasis(nroChasis);
        unVehiculo.setNroMotor(nroMotor);
        unVehiculo.setAnio(anio);
        unVehiculo.setKmRecorrido(kmRecorrido);
        unVehiculo.setFechaCompra(fechaCompra);
        unVehiculo.setUnModelo(unModelo);
        cp.editarVehiculo(unVehiculo);
    }
    public List<Vehiculo> traerVehiculos(boolean activo) throws Exception{
        return cp.traerVehiculos(activo);
    }
    public void eliminarVehiculo(int codigo) throws Exception{
        unVehiculo = cp.traerVehiculo(codigo);
        unVehiculo.setActivo(false);
        cp.editarVehiculo(unVehiculo);
    }
    public List<Vehiculo> traerVehiculoDominio(boolean activo, String dominio) throws Exception{
        return cp.traerVehiculoDominio(activo, dominio);
    }
    
    
    /////////////////// METODO MAIN ///////////////////////////
        public static void main(String[] args) {
            frmMenu miMenuPrincipal = new frmMenu();
            miMenuPrincipal.setVisible(true);
    }
}