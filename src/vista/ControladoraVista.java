/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Modelo.Accesorio;
import Modelo.AgendaMensual;
import Modelo.Anomalia;
import Modelo.Cliente;
import Modelo.ControladoraPrincipal;
import Modelo.Deposito;
import Modelo.Devolucion;
import Modelo.Ejemplar;
import Modelo.Empleado;
import Modelo.Equipamiento;
import Modelo.Especialidad;
import Modelo.Estado;
import Modelo.InformePiezaPedido;
import Modelo.JefeDeposito;
import Modelo.JefeTaller;
import Modelo.Localidad;
import Modelo.Marca;
import Modelo.Mecanico;
import Modelo.Modelo;
import Modelo.Pedido;
import Modelo.Perito;
import Modelo.PiezaRecambio;
import Modelo.Proveedor;
import Modelo.Segmento;
import Modelo.Taller;
import Modelo.TipoAnomalia;
import Modelo.TipoReparacion;
import Modelo.Vehiculo;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
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
    public List<Accesorio> traerAccesoriosSinVehiculo(Vehiculo vehiculo) throws Exception{
        return cp.traerAccesoriosSinVehiculo(vehiculo);
    }
    public List<Accesorio> traerAccesoriosConVehiculo(Vehiculo vehiculo) throws Exception{
        return cp.traerAccesoriosConVehiculo(vehiculo);
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
    public List<Equipamiento> traerEquipamientosSinVehiculo(Vehiculo vehiculo) throws Exception{
        return cp.traerEquipamientosSinVehiculo(vehiculo);
    }
    public List<Equipamiento> traerEquipamientosConnVehiculo(Vehiculo vehiculo) throws Exception{
        return cp.traerEquipamientosConVehiculo(vehiculo);
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
    public void nuevoVehiculo(String dominio, String nroChasis, String nroMotor, int anio, long kmRecorrido, java.util.Date fechaCompra, java.util.Date fechaFinGarantia, long kmCubierto, boolean activo, Modelo unModelo) throws Exception {
        cp.nuevoVehiculo(dominio, nroChasis, nroMotor, anio, kmRecorrido, fechaCompra, fechaFinGarantia, kmCubierto, activo, unModelo);
    }

    public void editarVehiculo(int codigo, String dominio, String nroChasis, String nroMotor, int anio, long kmRecorrido, java.util.Date fechaCompra, java.util.Date fechaFinGarantia, long kmCubierto, boolean activo, Modelo unModelo) throws Exception {
        //recibir codigo en todos los metodos sgtes.
        cp.editarVehiculo(codigo, dominio, nroChasis, nroMotor, anio, kmRecorrido, fechaCompra, fechaFinGarantia, kmCubierto, activo, unModelo);
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
    
    public Vehiculo traerVehiculo(int codigo) throws Exception{
        return cp.traerVehiculo(codigo);
    }
    
    public void agregarAccesorioVehiculo(Accesorio accesorio, int codigo) throws Exception{
        cp.agregarAccesorioVehiculo(accesorio, codigo);
    }
    public void quitarAccesorioVehiculo(int accesorio, int codigo) throws Exception{
        cp.quitarAccesorioVehiculo(accesorio, codigo);
    }
    public void agregarEquipamientoVehiculo(Equipamiento equipamiento, int codigo) throws Exception{
        cp.agregarEquipamientoVehiculo(equipamiento, codigo);
    }
    public void quitarEquipamientoVehiculo(int equipamiento, int codigo) throws Exception{
        cp.quitarEquipamientoVehiculo(equipamiento, codigo);
    }
    public List<Vehiculo> traerVehiculosSinCliente() throws PreexistingEntityException, Exception{
        return cp.traerVehiculosSinCliente();
    }
    public List<Vehiculo> traerVehiculosConCliente(Cliente cliente) throws PreexistingEntityException, Exception{
        return cp.traerVehiculosConCliente(cliente);
    }
    public void borrarClienteVehiculo(int codigoCliente, int codigoVehiculo) throws PreexistingEntityException, Exception{
        cp.borrarClienteVehiculo(codigoCliente, codigoVehiculo);
    }

    ////////////////////// METODOS DE CLIENTE /////////////////////////////
    public void nuevoCliente(int dni, String nombre, String apellido, String direccion, String telefono, String usuario, String clave, long cuil, boolean activo, Localidad localidad) throws Exception {
        cp.nuevoCliente(dni, nombre, apellido, direccion, telefono, usuario, clave, cuil, activo, localidad);
    }

    public void editarCliente(int codigo, int dni, String nombre, String apellido, String direccion, String telefono, String usuario, String clave, long cuil, boolean activo, Localidad localidad) throws Exception {
        cp.editarCliente(codigo, dni, nombre, apellido, direccion, telefono, usuario, clave, cuil, activo, localidad);
    }

    public List<Cliente> traerClientes(boolean activo) throws Exception {
        return cp.traerClientes(activo);
    }
    public Cliente traerCliente(int codigo) throws Exception {
        return cp.traerCliente(codigo);
    }

    public List<Cliente> traerClientesBusqueda(boolean activo, String apellido, int dni) throws Exception {
        return cp.traerClientesBusqueda(activo, apellido, dni);
    }

    public void eliminarCliente(int codigo) throws Exception {
        cp.eliminarCliente(codigo);
    }
    
    public void agregarVehiculoCliente(Vehiculo vehiculo, int codigo) throws Exception{
        cp.agregarVehiculoCliente(vehiculo, codigo);
    }
    public void quitarVehiculoCliente(Vehiculo vehiculo, int codigo) throws Exception{
        cp.quitarVehiculoCliente(vehiculo, codigo);
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
    public void nuevoEjemplar(java.util.Date fecha, PiezaRecambio unaPRecambio, Proveedor unProveedor, int deposito) throws Exception {
        cp.nuevoEjemplar(fecha, unaPRecambio, unProveedor, deposito);
    }

    public void editarEjemplar(int codigo, java.util.Date fecha, PiezaRecambio unaPRecambio, Proveedor unProveedor) throws Exception {
        cp.editarEjemplar(codigo, fecha, unaPRecambio, unProveedor);
    }

    public List<Ejemplar> traerEjemplares(boolean activo) throws Exception {
        return cp.traerEjemplares(activo);
    }

    public void elminarEjemplar(int codigo, int codigoDeposito) throws Exception {
        cp.eliminarEjemplar(codigo, codigoDeposito);
    }

    public List<Ejemplar> traerEjemplarCodigo(boolean activo, int codigo) throws Exception {
        return cp.traerEjemplarCodigo(activo, codigo);
    }
    public List<Ejemplar> traerEjemplaresSinDeposito(boolean activo){
        return cp.traerEjemplaresSinDeposito(activo);
    }
    public List<Ejemplar> traerEjemplaresConDeposito(int deposito, boolean activo){
        return cp.traerEjemplaresConDeposito(deposito, activo);
    }
    public List<Ejemplar> traerEjemplaresConDeposito(int deposito, boolean activo, PiezaRecambio pieza){
        return cp.traerEjemplaresConDeposito(deposito, activo, pieza);
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
    public List<Mecanico> traerMecanicoSinTaller(){
        return cp.traerMecanicoSinTaller();
    }
    public List<Mecanico> traerMecanicoConCliente(int codigoTaller){
        return cp.traerMecanicoConCliente(codigoTaller);
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
    public void nuevaPedido(Date fecha, Date hora, String descripcion, int cantidad, boolean autorizado, boolean paraRecambio, boolean activo, JefeDeposito unJefeDeposito, JefeTaller unJefeTaller, Cliente unCliente) throws Exception {
        cp.nuevoPedido(fecha, hora, descripcion, cantidad, autorizado, paraRecambio,true, unJefeDeposito, unJefeTaller, unCliente);
    }

    public void editarEspecialidad(int codigo, Date fecha, Date hora, String descripcion, int cantidad, boolean autorizado, boolean paraRecambio, boolean activo, JefeDeposito unJefeDeposito, JefeTaller unJefeTaller, Cliente unCliente) throws Exception {
        cp.editarPedido(codigo, fecha, hora, descripcion, cantidad, autorizado, paraRecambio,true, unJefeDeposito, unJefeTaller, unCliente);
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
        ////////////////////// MÉTODOS DE LOCALIDAD ////////////////////////////
    public List<Localidad> traerLocalidades(boolean activo) throws Exception{
        return cp.traerLocalidades(activo);
    }
    public List<Localidad> traerLocalidadesNombre(boolean activo, String nombre) throws Exception{
        return cp.traerLocalidadesNombre(activo, nombre);
    }
    public List<Localidad> traerLocalidadesSinTaller(int taller) throws PreexistingEntityException, Exception{
        return cp.traerLocalidadesSinTaller(taller);
    }
    public List<Localidad> traerLocalidadesConTaller(int taller) throws PreexistingEntityException, Exception{
        return cp.traerLocalidadesConTaller(taller);
    }
    
    ///////////////////////// METODOS DE DEVOLUCION ////////////////////////////////
    public void nuevaDevolucion(Date fecha, String motivo, boolean activo, PiezaRecambio miPiezaRecambio, int codigoDeposito) throws PreexistingEntityException, Exception{
        cp.nuevaDevolucion(fecha, motivo, activo, miPiezaRecambio, codigoDeposito);
    }
    public void editarDevolucion(int codigo, Date fecha, String motivo, boolean activo, PiezaRecambio miPiezaRecambio) throws PreexistingEntityException, Exception{
        cp.editarDevolucion(codigo, fecha, motivo, activo, miPiezaRecambio);
    }
    public Devolucion traerDevolucion(int codigo) throws PreexistingEntityException, Exception{
        return cp.traerDevolucion(codigo);
    }
    public List<Devolucion> traerDevoluciones(boolean activo) throws PreexistingEntityException, Exception{
        return cp.traerDevoluciones(activo);
    }
    public void eliminarDevolucion(int codigo, int deposito) throws NonexistentEntityException, Exception{
        cp.eliminarDevolucion(codigo, deposito);
    }
    public List<Devolucion> traerDevolucionesBusqueda(boolean activo, java.util.Date fecha) throws PreexistingEntityException, Exception{
        return cp.traerDevolucionesBusqueda(activo, fecha);
    }
    public List<Devolucion> traerDevolucionSinDeposito() throws PreexistingEntityException, Exception{
        return cp.traerDevolucionesSinDeposito();
    }
    public List<Devolucion> traerDevolucionConDeposito(int deposito) throws PreexistingEntityException, Exception{
        return cp.traerDevolucionesConDeposito(deposito);
    }
    public List<Devolucion> traerDevolucionConDeposito(int deposito, String fecha) throws PreexistingEntityException, Exception{
        return cp.traerDevolucionesConDeposito(deposito, fecha);
    }
    
                /////////////////////// METODOS DE TALLER ////////////////////////////////
    public void nuevoTaller(String nombre, String direccion, String telefono, String correo, Date horaEntrada, Date horaSalida, boolean activo, JefeTaller unJefeTaller, Localidad unaLocalidad) throws PreexistingEntityException, Exception{
        cp.nuevoTaller(nombre, direccion, telefono, correo, horaEntrada, horaSalida, activo, unJefeTaller, unaLocalidad);
    }
    public void editarTaller(int codigo, String nombre, String direccion, String telefono, String correo, Date horaEntrada, Date horaSalida, boolean activo, Deposito unDeposito, JefeTaller unJefeTaller, Localidad unaLocalidad) throws PreexistingEntityException, Exception{
        cp.editarTaller(codigo, nombre, direccion, telefono, correo, horaEntrada, horaSalida, activo, unDeposito, unJefeTaller, unaLocalidad);
    }
    public List<Taller> traerTalleres(boolean activo) throws PreexistingEntityException, Exception{
        return cp.traerTalleres(activo);
    }
    public void eliminarTaller(int codigo) throws NonexistentEntityException, Exception{
            cp.eliminarTaller(codigo);
    }
    public List<Taller> traerTallerNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
        return cp.traerTallerNombre(activo, nombre);
    }   
    public Taller traerTaller(int codigo) throws PreexistingEntityException, Exception{
        return cp.traerTaller(codigo);
    }
    public void agregarZonaTaller(Localidad localidad, int codigo) throws Exception{
        cp.agregarZonaTaller(localidad, codigo);
    }
    public void quitarZonaTaller(int localidad, int codigo) throws Exception{
        cp.quitarZonaTaller(localidad, codigo);
    }
    public void agregarMecanico(int codigoMecanido, int codigoTaller) throws PreexistingEntityException, Exception{
        cp.agregarMecanico(codigoMecanido, codigoTaller);
    }
    public void quitarMecanico(int codigoMecanido, int codigoTaller) throws PreexistingEntityException, Exception{
        cp.quitarMecanico(codigoMecanido, codigoTaller);
    }
    

    ///////////////////// METODOS DE JEFE DE TALLER ////////////////////////
    public void nuevoJefeTaller(int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception {
        cp.nuevoJefeTaller(dni, nombre, apellido, telefono, direccion, cuil, activo);
    }

    public void editarJefeTaller(int codigo, int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception {
        cp.editarJefeTaller(codigo, dni, nombre, apellido, telefono, direccion, cuil, activo);
    }

    public List<JefeTaller> traerJefesTaller(boolean activo) throws Exception {
        return cp.traerJefesTaller(activo);
    }

    public void elminarJefeTaller(int codigo) throws Exception {
        cp.eliminarJefeTaller(codigo);
    }

    public List<JefeTaller> traerJefesTallerBusqueda(boolean activo, String apellido, int dni) throws Exception {
        return cp.traerJefesTallerBusqueda(activo, apellido, dni);
    }
    
    ///////////////////// METODOS DE JEFE DE DEPOSITO ////////////////////////
    public void nuevoJefeDeposito(int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception {
        cp.nuevoJefeDeposito(dni, nombre, apellido, telefono, direccion, cuil, activo);
    }

    public void editarJefeDeposito(int codigo, int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception {
        cp.editarJefeDeposito(codigo, dni, nombre, apellido, telefono, direccion, cuil, activo);
    }

    public List<JefeDeposito> traerJefesDeposito(boolean activo) throws Exception {
        return cp.traerJefesDeposito(activo);
    }

    public void elminarJefeDeposito(int codigo) throws Exception {
        cp.eliminarJefeDeposito(codigo);
    }

    public List<JefeDeposito> traerJefesDepositoBusqueda(boolean activo, String apellido, int dni) throws Exception {
        return cp.traerJefesDepositoBusqueda(activo, apellido, dni);
    }
    
    ///////////////////// METODOS DE PERITO ////////////////////////
    public void nuevoPerito(int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception {
        cp.nuevoPerito(dni, nombre, apellido, telefono, direccion, cuil, activo);
    }

    public void editarPerito(int codigo, int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception {
        cp.editarPerito(codigo, dni, nombre, apellido, telefono, direccion, cuil, activo);
    }

    public List<Perito> traerPeritos(boolean activo) throws Exception {
        return cp.traerPeritos(activo);
    }

    public void elminarPerito(int codigo) throws Exception {
        cp.eliminarPerito(codigo);
    }

    public List<Perito> traerPeritosBusqueda(boolean activo, String apellido, int dni) throws Exception {
        return cp.traerPeritosBusqueda(activo, apellido, dni);
    }
    
    public Perito traerPerito(int codigo) throws Exception {
        return cp.traerPerito(codigo);
    }

    public void agregarInforme(InformePiezaPedido unInforme, int codigo) throws Exception{
        cp.agregarInforme(unInforme, codigo);
    }
    public void quitarInforme(int informe, int codigo) throws Exception{
        cp.quitarInforme(informe, codigo);
    }

    ///////////////// METODOS DE INFORMES ////////////////////////
    public void nuevoInforme(boolean aprobado, java.util.Date fecha, boolean activo, PiezaRecambio pieza) throws Exception {
        cp.nuevoInforme(aprobado, fecha, activo, pieza);
    }
    public void editarInforme(int codigo, boolean aprobado, java.util.Date fecha, boolean activo, PiezaRecambio pieza) throws Exception {
        cp.editarInforme(codigo, aprobado, fecha, activo, pieza);
    }
    public void eliminarInforme(int codigo) throws Exception {
        cp.eliminarInforme(codigo);
    }

    public List<InformePiezaPedido> traerInformeSinVinculo(Perito unPerito) {
        return cp.traerInformeSinVinculo(unPerito);
    }

    public List<InformePiezaPedido> traerInformesConVinculo(Perito unPerito) {
        return cp.traerInformesConVinculo(unPerito);
    }

    /////////////////////// METODOS DE DEPOSITO ////////////////////////////////
    public void nuevoDeposito(String nombre, String correo, String telefono, boolean activo, JefeDeposito unJefeDeposito) throws PreexistingEntityException, Exception{
        cp.nuevoDeposito(nombre, correo, telefono, activo, unJefeDeposito);
    }
    public void editarDeposito(int codigo, String nombre, String correo, String telefono, boolean activo, JefeDeposito unJefeDeposito) throws PreexistingEntityException, Exception{
        cp.editarDeposito(codigo, nombre, correo, telefono, activo, unJefeDeposito);
    }
    public void eliminarDeposito(int codigo) throws NonexistentEntityException, Exception{
        cp.eliminarDeposito(codigo);
    }
    public Deposito traerDeposito(int codigo) throws NonexistentEntityException, Exception{
        return cp.traerDeposito(codigo);
    }
    public int ultimoDeposito() throws NonexistentEntityException, Exception{
        return cp.ultimoDeposito();
    }
    
    /////////////////////// METODOS DE AGENDA MENSUAL ////////////////////////////////
    public void nuevaAgendaMensual(String nombre, int anio, int nroMes, boolean activo, int codigoTaller) throws PreexistingEntityException, Exception{
        cp.nuevaAgendaMensual(nombre, anio, nroMes, activo, codigoTaller);
    }
    public void editarAgendaMensual(int codigo, String nombre, int anio, int nroMes, boolean activo) throws PreexistingEntityException, Exception{
        cp.editarAgendaMensual(codigo, nombre, anio, nroMes, activo);
    }
    public void eliminarAgendaMensual(int codigo, int codigoTaller) throws NonexistentEntityException, Exception{
        cp.eliminarAgendaMensual(codigo, codigoTaller);
    }
    public AgendaMensual traerAgendaMensual(int codigo) throws NonexistentEntityException, Exception{
        return cp.traerAgendaMensual(codigo);
    }
    public int ultimoAgendaMensual() throws NonexistentEntityException, Exception{
        return cp.ultimoAgendaMensual();
    }
    
    public List<AgendaMensual> traerAgendaMensual(boolean activo) throws NonexistentEntityException, Exception{
        return cp.traerAgendaMensual(activo);
    }
    
    public List<AgendaMensual> traerAgendaMensualAnio(boolean activo, int anio) throws NonexistentEntityException, Exception{
        return cp.traerAgendaMensualAnio(activo, anio);
    }
    public List<AgendaMensual> traerAgendaMensualSinTaller() throws NonexistentEntityException, Exception{
        return cp.traerAgendaMensualSinTaller();
    }
    
    public List<AgendaMensual> traerAgendaMensualConTaller(int codigoTaller) throws NonexistentEntityException, Exception{
        return cp.traerAgendaMensualConTaller(codigoTaller);
    }
}
