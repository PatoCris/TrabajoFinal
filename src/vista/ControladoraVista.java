/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Modelo.Accesorio;
import Modelo.Anomalia;
import Modelo.Cliente;
import Modelo.ControladoraPrincipal;
import Modelo.Ejemplar;
import Modelo.Empleado;
import Modelo.Equipamiento;
import Modelo.Especialidad;
import Modelo.Estado;
import Modelo.JefeDeposito;
import Modelo.JefeTaller;
import Modelo.Marca;
import Modelo.Mecanico;
import Modelo.Modelo;
import Modelo.Pedido;
import Modelo.Perito;
import Modelo.PiezaRecambio;
import Modelo.Proveedor;
import Modelo.Segmento;
import Modelo.TipoAnomalia;
import Modelo.TipoReparacion;
import Modelo.Vehiculo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author cristian
 */
class ControladoraVista {

    private ControladoraPrincipal cp = new ControladoraPrincipal();

    ///////////////// METODOS DE ACCESORIO ////////////////////////
    public void nuevoAccesorio(String nombre, String descrpcion) throws Exception {
        cp.nuevoAccesorio(nombre, descrpcion);
    }

    public void editarAccesorio(int codigo, String nombre, String descrpcion) throws Exception {
        cp.editarAccesorio(codigo, nombre, descrpcion);
    }

    public List<Accesorio> traerAccesorios(boolean activo) throws Exception {
        return cp.traerAccesorios(activo);
    }

    public void elminarAccesorios(int codigo) throws Exception {
        cp.eliminarAccesorio(codigo);
    }

    public List<Accesorio> traerAccesoriosNombre(boolean activo, String nombre) throws Exception {
        return cp.traerAccesoriosNombre(activo, nombre);
    }

    ///////////////// METODOS DE MARCA ////////////////////////
    public void nuevaMarca(String nombre, String descrpcion) throws Exception {
        cp.nuevaMarca(nombre, descrpcion);
    }

    public void editarMarca(int codigo, String nombre, String descrpcion) throws Exception {
        cp.editarMarca(codigo, nombre, descrpcion);
    }

    public List<Marca> traerMarcas(boolean activo) throws Exception {
        return cp.traerMarcas(activo);
    }

    public void eliminarMarca(int codigo) throws Exception {
        cp.eliminarMarca(codigo);
    }

    public List<Marca> traerMarcasNombre(boolean activo, String nombre) throws Exception {
        return cp.traerMarcasNombre(activo, nombre);
    }

    ///////////////// METODOS DE TIPO REPARACION ////////////////////////
    public void nuevoTipoReparacion(String nombre, String descrpcion) throws Exception {
        cp.nuevoTipoReparacion(nombre, descrpcion);
    }

    public void editarTipoReparacion(int codigo, String nombre, String descrpcion) throws Exception {
        cp.editarTipoReparacion(codigo, nombre, descrpcion);
    }

    public List<TipoReparacion> traerTipoReparacion(boolean activo) throws Exception {
        return cp.traerTipoReparacion(activo);
    }

    public void elminarTipoRepracion(int codigo) throws Exception {
        cp.eliminarTipoReparacion(codigo);
    }

    public List<TipoReparacion> traerTipoReparacionNombre(boolean activo, String nombre) throws Exception {
        return cp.traerTipoReparacionNombre(activo, nombre);
    }

    ///////////////// METODOS DE TIPO REPARACION ////////////////////////
    public void nuevaAnomalia(String descrpcion, String nivelSeveridad, TipoAnomalia tipoAnomalia, boolean activo) throws Exception {
        cp.nuevaAnomalia(nivelSeveridad, descrpcion, tipoAnomalia, activo);
    }

    public void editarAnomalia(int codigo, String descrpcion, String nivelSeveridad, TipoAnomalia tipoAnomalia) throws Exception {
        cp.editarAnomalia(codigo, descrpcion, nivelSeveridad, tipoAnomalia);
    }

    public List<Anomalia> traerAnomalias(boolean activo) throws Exception {
        return cp.traerAnomalias(activo);
    }

    public void elminarAnomalia(int codigo) throws Exception {
        cp.eliminarAnomalia(codigo);
    }

    public List<Anomalia> traerAnomaliasBusqueda(boolean activo, String nivel, TipoAnomalia tipo) throws Exception {
        return cp.traerAnomaliasBusqueda(activo, nivel, tipo);
    }

    ///////////////// METODOS DE MARCA ////////////////////////
    public void nuevoTipoAnomalia(String nombre) throws Exception {
        cp.nuevoTipoAnomalia(nombre);
    }

    public void editarTipoAnomalia(int codigo, String nombre) throws Exception {
        cp.editarTipoAnomalia(codigo, nombre);
    }

    public List<TipoAnomalia> traerTipoAnomalia(boolean activo) throws Exception {
        return cp.traerTipoAnomalia(activo);
    }

    public void elminarTipoAnomalia(int codigo) throws Exception {
        cp.eliminarTipoAnomalia(codigo);
    }

    public List<TipoAnomalia> traerTipoAnomaliaNombre(boolean activo, String nombre) throws Exception {
        return cp.traerTipoAnomaliaNombre(activo, nombre);
    }

    ///////////////////// METODOS DE EQUIPAMIENTO ////////////////////////
    public void nuevoEquipamiento(String nombre, String descrpcion) throws Exception {
        cp.nuevoEquipamiento(nombre, descrpcion);
    }

    public void editarEquipamiento(int codigo, String nombre, String descrpcion) throws Exception {
        cp.editarEquipamiento(codigo, nombre, descrpcion);
    }

    public List<Equipamiento> traerEquipamientos(boolean activo) throws Exception {
        return cp.traerEquipamientos(activo);
    }

    public void elminarEquipamiento(int codigo) throws Exception {
        cp.eliminarEquipamiento(codigo);
    }

    public List<Equipamiento> traerEquipamientosNombre(boolean activo, String nombre) throws Exception {
        return cp.traerEquipamientosNombre(activo, nombre);
    }

    ///////////////////// METODOS DE SEGMENTO ////////////////////////
    public void nuevoSegmento(String nombre, String descrpcion) throws Exception {
        cp.nuevoSegmento(nombre, descrpcion);
    }

    public void editarSegmento(int codigo, String nombre, String descrpcion) throws Exception {
        cp.editarSegmento(codigo, nombre, descrpcion);
    }

    public List<Segmento> traerSegmentos(boolean activo) throws Exception {
        return cp.traerSegmentos(activo);
    }

    public void elminarSegmento(int codigo) throws Exception {
        cp.eliminarSegmento(codigo);
    }

    public List<Segmento> traerSegmentosNombre(boolean activo, String nombre) throws Exception {
        return cp.traerSegmentosNombre(activo, nombre);
    }

    ///////////////////// METODOS DE MODELO ////////////////////////
    public void nuevoModelo(String nombre, String descrpcion, Marca marca, Segmento segmento) throws Exception {
        cp.nuevoModelo(nombre, descrpcion, marca, segmento);
    }

    public void editarModelo(int codigo, String nombre, String descrpcion, Marca marca, Segmento segmento) throws Exception {
        cp.editarModelo(codigo, nombre, descrpcion, marca, segmento);
    }

    public List<Modelo> traerModelo(boolean activo) throws Exception {
        return cp.traerModelos(activo);
    }

    public void elminarModelo(int codigo) throws Exception {
        cp.eliminarModelo(codigo);
    }

    public List<Modelo> traerModelosNombre(boolean activo, String nombre) throws Exception {
        return cp.traerModelosNombre(activo, nombre);
    }

    public List<Modelo> traerModelosSinVinculo(PiezaRecambio pieza) throws Exception{
        return cp.traerModelosSinVinculo(pieza);
    }
    public List<Modelo> traerModelosConVinculo(PiezaRecambio pieza) throws Exception{
        return cp.traerModelosConVinculo(pieza);
    }

    ///////////////////// METODOS DE EMPLEADO ////////////////////////
    public void nuevoEmpleado(int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception {
        cp.nuevoEmpleado(dni, nombre, apellido, telefono, direccion, cuil, activo);
    }

    public void editarEmpleado(int codigo, int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception {
        cp.editarEmpleado(codigo, dni, nombre, apellido, telefono, direccion, cuil, activo);
    }

    public List<Empleado> traerEmpleados(boolean activo) throws Exception {
        return cp.traerEmpleados(activo);
    }

    public void elminarEmpleado(int codigo) throws Exception {
        cp.eliminarEmpleado(codigo);
    }

    public List<Empleado> traerEmpladosBusqueda(boolean activo, String apellido, int dni) throws Exception {
        return cp.traerEmpleadossBusqueda(activo, apellido, dni);
    }

    ///////////////// METODOS DE ESPECIALIDAD ////////////////////////
    public void nuevaEspecialidad(String nombre, String descripcion) throws Exception {
        cp.nuevaEspecialidad(nombre, descripcion);
    }

    public void editarEspecialidad(int codigo, String nombre, String descripcion) throws Exception {
        cp.editarEspecialidad(codigo, nombre, descripcion);
    }

    public List<Especialidad> trerEspecialidades(boolean activo) throws Exception {
        return cp.traerEspecialidad(activo);
    }

    public List<Especialidad> traerEspecialidadesNombre(boolean activo, String nombre) throws Exception {
        return cp.traerEspecialidadesNombre(activo, nombre);
    }

    public void eliminarEspecialidad(int codigo) throws Exception {
        cp.eliminarEspecialidad(codigo);
    }
    
    public List<Especialidad> traerEspecialidadesSinVinculo(Mecanico unMecanico) throws Exception{
        return cp.traerEspecialidadesSinVinculo(unMecanico);
    }
    public List<Especialidad> traerEspecialidadesConVinculo(Mecanico unMecanico) throws Exception{
        return cp.traerEspecialidadesConVinculo(unMecanico);
    }

    ///////////////// METODOS DE ESTADOS ////////////////////////
    public void nuevoEstado(String nombre, String descripcion) throws Exception {
        cp.nuevoEstado(nombre, descripcion);
    }

    public void editarEstado(int codigo, String nombre, String descripcion) throws Exception {
        cp.editarEstado(codigo, nombre, descripcion);
    }

    public List<Estado> trerEstados(boolean activo) throws Exception {
        return cp.traerEstado(activo);
    }

    public List<Estado> traerEstadosNombre(boolean activo, String nombre) throws Exception {
        return cp.traerEstadosNombre(activo, nombre);
    }

    public void eliminarEstado(int codigo) throws Exception {
        cp.eliminarEstado(codigo);
    }

    /////////////////////////// METODOS DE VEHICULO ////////////////////////////
    public void nuevoVehiculo(String dominio, String nroChasis, String nroMotor, int anio, long kmRecorrido, Date fechaCompra, boolean activo, Modelo unModelo) throws Exception {
        cp.nuevoVehiculo(dominio, nroChasis, nroMotor, anio, kmRecorrido, fechaCompra, activo, unModelo);
    }

    public void editarVehiculo(String dominio, String nroChasis, String nroMotor, int anio, long kmRecorrido, Date fechaCompra, boolean activo, Modelo unModelo) throws Exception {
        //recibir codigo en todos los metodos sgtes.
        cp.editarVehiculo(dominio, nroChasis, nroMotor, anio, kmRecorrido, fechaCompra, activo, unModelo);
    }

    public List<Vehiculo> traerVehiculos(boolean activo) throws Exception {
        return cp.traerVehiculos(activo);
    }

    public void elminarVehiculo(int codigo) throws Exception {
        cp.eliminarVehiculo(codigo);
    }

    public List<Vehiculo> traerVehiculoDominio(boolean activo, String dominio) throws Exception {
        return cp.traerVehiculoDominio(activo, dominio);
    }

    ////////////////////// METODOS DE CLIENTE /////////////////////////////
    public void nuevoCliente(int dni, String nombre, String apellido, String direccion, String telefono, String usuario, String clave, long cuil, boolean activo) throws Exception {
        cp.nuevoCliente(dni, nombre, apellido, direccion, telefono, usuario, clave, cuil, activo);
    }

    public void editarCliente(int codigo, int dni, String nombre, String apellido, String direccion, String telefono, String usuario, String clave, long cuil, boolean activo) throws Exception {
        cp.editarCliente(codigo, dni, nombre, apellido, direccion, telefono, usuario, clave, cuil, activo);
    }

    public List<Cliente> traerClientes(boolean activo) throws Exception {
        return cp.traerClientes(activo);
    }

    public List<Cliente> traerClientesBusqueda(boolean activo, String apellido, int dni) throws Exception {
        return cp.traerClientesBusqueda(activo, apellido, dni);
    }

    public void eliminarCliente(int codigo) throws Exception {
        cp.eliminarCliente(codigo);
    }

    ////////////////////// METODOS DE PIEZA RECAMBIO /////////////////////////////
    public void nuevaPiezaRecambio(String nombre, double precio, double impuesto, boolean garantia, String caracteristica, int mesesGarantia, boolean activo, TipoReparacion grupoParte) throws Exception {
        cp.nuevaPiezaRecambio(nombre, precio, impuesto, garantia, caracteristica, mesesGarantia, activo, grupoParte);
    }

    public void editarPiezaRecambio(int codigo, String nombre, double precio, double impuesto, boolean garantia, String caracteristica, int mesesGarantia, boolean activo, TipoReparacion grupoParte) throws Exception {
        cp.editarPiezaRecambio(codigo, nombre, precio, impuesto, garantia, caracteristica, mesesGarantia, activo, grupoParte);
    }

    public List<PiezaRecambio> traerPiezaRecambios(boolean activo) throws Exception {
        return cp.traerPiezaRecambios(activo);
    }

    public List<PiezaRecambio> traerPiezaRecambiosBusqueda(boolean activo, String nombre, TipoReparacion tipo) throws Exception {
        return cp.traerPiezaRecambiosBusqueda(activo, nombre, tipo);
    }

    public void eliminarPiezaRecambio(int codigo) throws Exception {
        cp.eliminarPiezaRecambio(codigo);
    }

    public PiezaRecambio traerPiezaRecambio(int codigo) throws Exception {
        return cp.traerPiezaRecambio(codigo);
    }

    public void agregarVehiculoCompatible(Modelo modelo, int codigo) throws Exception{
        cp.agregarVehiculoCompatible(modelo, codigo);
    }
    public void quitarVehiculoCompatible(int modelo, int codigo) throws Exception{
        cp.quitarVehiculoCompatible(modelo, codigo);
    }
    //Para subir la ultima version 

    
    ///////////////// METODOS DE PROVEEDOR ////////////////////////
    public void nuevoProveedor(String nombre, String rs, String domicilio, String telefono, long cuit) throws Exception {
        cp.nuevoProveedor(nombre, rs, domicilio, telefono, cuit);
    }

    public void editarProveedor(int codigo, String nombre, String rs, String domicilio, String telefono, long cuit) throws Exception {
        cp.editarProveedor(codigo, nombre, rs, domicilio, telefono, cuit);
    }

    public List<Proveedor> traerProveedores(boolean activo) throws Exception {
        return cp.traerProveedor(activo);
    }

    public void elminarProveedor(int codigo) throws Exception {
        cp.eliminarProveedor(codigo);
    }

    public List<Proveedor> traerProveedorNombre(boolean activo, String nombre) throws Exception {
        return cp.traerProveedorNombre(activo, nombre);
    }
    
    ///////////////// METODOS DE EJEMPLAR //////////////////////////
    public void nuevoEjemplar(java.util.Date fecha, PiezaRecambio unaPRecambio, Proveedor unProveedor) throws Exception {
        cp.nuevoEjemplar(fecha, unaPRecambio, unProveedor);
    }

    public void editarEjemplar(int codigo, java.util.Date fecha, PiezaRecambio unaPRecambio, Proveedor unProveedor) throws Exception {
        cp.editarEjemplar(codigo, fecha, unaPRecambio, unProveedor);
    }

    public List<Ejemplar> traerEjemplares(boolean activo) throws Exception {
        return cp.traerEjemplares(activo);
    }

    public void elminarEjemplar(int codigo) throws Exception {
        cp.eliminarEjemplar(codigo);
    }

    public List<Ejemplar> traerEjemplarCodigo(boolean activo, int codigo) throws Exception {
        return cp.traerEjemplarCodigo(activo, codigo);
    }

///////////////////// METODOS DE MECANICO ////////////////////////
    public void nuevoMecanico(int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception {
        cp.nuevoMecanico(dni, nombre, apellido, telefono, direccion, cuil, activo);
    }

    public void editarMecanico(int codigo, int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception {
        cp.editarMecanico(codigo, dni, nombre, apellido, telefono, direccion, cuil, activo);
    }

    public List<Mecanico> traerMecanicos(boolean activo) throws Exception {
        return cp.traerMecanicos(activo);
    }

    public void elminarMecanico(int codigo) throws Exception {
        cp.eliminarEmpleado(codigo);
    }

    public List<Mecanico> traerMecanicosBusqueda(boolean activo, String apellido, int dni) throws Exception {
        return cp.traerMecanicosBusqueda(activo, apellido, dni);
    }
    
    public Mecanico traerMecanico(int codigo) throws Exception {
        return cp.traerMecanico(codigo);
    }

    public void agregarEspecialidad(Especialidad unaEspecialidad, int codigo) throws Exception{
        cp.agregarEspecialidad(unaEspecialidad, codigo);
    }
    public void quitarEspecialidad(int especialidad, int codigo) throws Exception{
        cp.quitarEspecialidad(especialidad, codigo);
    }

    public void agregarPedido(Pedido unPedido, int codigo) throws Exception{
        cp.agregarPedido(unPedido, codigo);
    }
    public void quitarPedido(int pedido, int codigo) throws Exception{
        cp.quitarPedido(pedido, codigo);
    }
    
    ///////////////// METODOS DE PEDIDOS ////////////////////////
    public void nuevaPedido(Date fecha, Date hora, String descripcion, int cantidad, boolean autorizado, boolean paraRecambio, boolean activo, Perito unPerito, JefeDeposito unJefeDeposito, JefeTaller unJefeTaller, Cliente unCliente) throws Exception {
        cp.nuevoPedido(fecha, hora, descripcion, cantidad, autorizado, paraRecambio,true, unPerito, unJefeDeposito, unJefeTaller, unCliente);
    }

    public void editarEspecialidad(int codigo, Date fecha, Date hora, String descripcion, int cantidad, boolean autorizado, boolean paraRecambio, boolean activo, Perito unPerito, JefeDeposito unJefeDeposito, JefeTaller unJefeTaller, Cliente unCliente) throws Exception {
        cp.editarPedido(codigo, fecha, hora, descripcion, cantidad, autorizado, paraRecambio,true, unPerito, unJefeDeposito, unJefeTaller, unCliente);
    }

    public List<Pedido> trerPedidos(boolean activo) throws Exception {
        return cp.traerPedidos(activo);
    }

    public List<Pedido> traerPedidosCodigo(boolean activo, int codigo) throws Exception {
        return cp.traerPedidosCodigo(activo, codigo);
    }

    public void eliminarPedido(int codigo) throws Exception {
        cp.eliminarPedido(codigo);
    }
    
    public List<Pedido> traerPedidosSinVinculo(Mecanico unMecanico) throws Exception{
        return cp.traerPedidosSinVinculo(unMecanico);
    }
    public List<Pedido> traerPedidosConVinculo(Mecanico unMecanico) throws Exception{
        return cp.traerPedidosConVinculo(unMecanico);
    }
    
}
