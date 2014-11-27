/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Persistencia.ControladoraPersistencia;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import vista.UtilVista;
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
    private Cliente unCliente = new Cliente();
    private PiezaRecambio unaPiezaRecambio = new PiezaRecambio();
    private Proveedor unProveedor = new Proveedor();
    private Ejemplar unEjemplar = new Ejemplar();
    private Mecanico unMecanico = new Mecanico();
    private Pedido unPedido = new Pedido();
    private JefeTaller unJefeTaller = new JefeTaller();
    private JefeDeposito unJefeDeposito = new JefeDeposito();
    private Perito unPerito = new Perito();
    private InformePiezaPedido unInforme = new InformePiezaPedido();

    private TipoDiagnostico unTipoDiagnostico = new TipoDiagnostico();
    private Proceso unProceso = new Proceso();
    private Diagnostico unDiagnostico = new Diagnostico();
    private Turno unTurno = new Turno();
            

    private vista.UtilVista util = new UtilVista();

 
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
    public List<Accesorio> traerAccesoriosSinVehiculo(Vehiculo vehiculo) throws Exception{
        return cp.traerAccesoriosSinVehiculo(vehiculo);
    }
    public List<Accesorio> traerAccesoriosConVehiculo(Vehiculo vehiculo) throws Exception{
        return cp.traerAccesoriosConVehiculo(vehiculo);
    }
    
    ////////////////////// MÉTODOS DE MARCA /////////////////////////////
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
    public List<Anomalia> traerAnomaliasSinVinculoConDiagnostico(Diagnostico unDiagnostico){
        return cp.traerAnomaliasSinVinculoConDiagnostico(unDiagnostico);
    }
    
    public List<Anomalia> traerAnomaliasVinculadoDiagnostico(Diagnostico unDiagnostico){
        return cp.traerAnomaliasVinculadoDiagnostico(unDiagnostico);
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
    public List<Equipamiento> traerEquipamientosSinVehiculo(Vehiculo vehiculo) throws Exception{
        return cp.traerEquipamientosSinVehiculo(vehiculo);
    }
    public List<Equipamiento> traerEquipamientosConVehiculo(Vehiculo vehiculo) throws Exception{
        return cp.traerEquipamientosConVehiculo(vehiculo);
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

    ////////////////////// MÉTODOS DE MODELO ////////////////////////////
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
    public List<Modelo> traerModelosSinVinculo(PiezaRecambio pieza) throws Exception{
        return cp.traerModelosSinVinculo(pieza);
    }
    public List<Modelo> traerModelosConVinculo(PiezaRecambio pieza) throws Exception{
        return cp.traerModelosConVinculo(pieza);
    }
    
    ////////////////// MÉTODOS DE EMPLEADO ////////////////////////
    public void nuevoEmpleado (int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception{
        if(cp.existeEmpleado(dni)){
            throw new Exception ("Error: Ya existe un Empleado con ese DNI.");
        }else{
            unEmpleado = new Empleado(dni, nombre, apellido, telefono, direccion, cuil, activo);
            cp.nuevoEmpleado(unEmpleado);
        }
    }
    public void editarEmpleado(int codigo, int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception{
        if(cp.existeEmpleado(dni, codigo)){
            throw new Exception ("Error: Ya existe otro Empleado con ese DNI.");
        }else{
            unEmpleado = cp.traerEmpleado(codigo);
            unEmpleado.setDni(dni);
            unEmpleado.setNombre(nombre);
            unEmpleado.setApellido(apellido);
            unEmpleado.setTelefono(telefono);
            unEmpleado.setDireccion(direccion);
            unEmpleado.setCuil(cuil);
            cp.editarEmpleado(unEmpleado);
        }    
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
    public List<Especialidad> traerEspecialidadesSinVinculo(Mecanico unMecanico) throws Exception{
        return cp.traerEspecialidadesSinVinculo(unMecanico);
    }
    public List<Especialidad> traerEspecialidadesConVinculo(Mecanico unMecanico) throws Exception{
        return cp.traerEspecialidadesConVinculo(unMecanico);
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
    
    ////////////////////////// MÉTODOS DE VEHICULO ///////////////////////////////////
    public void nuevoVehiculo(String dominio, String nroChasis, String nroMotor, int anio, long kmRecorrido, java.util.Date fechaCompra, java.util.Date fechaFinGarantia, long kmCubierto, boolean activo, Modelo unModelo) throws Exception{
        unVehiculo = new Vehiculo(dominio, nroChasis, nroMotor, anio, kmRecorrido, fechaCompra, fechaFinGarantia, kmCubierto, activo, unModelo);
        cp.crearVehiculo(unVehiculo);
    }
    public void editarVehiculo(int codigo, String dominio, String nroChasis, String nroMotor, int anio, long kmRecorrido, java.util.Date fechaCompra, java.util.Date fechaFinGarantia, long kmCubierto, boolean activo, Modelo unModelo) throws Exception{
        unVehiculo = cp.traerVehiculo(codigo);//-> tenes que recibir codigo desde la controladora vista.
        unVehiculo.setDominio(dominio);
        unVehiculo.setNroChasis(nroChasis);
        unVehiculo.setNroMotor(nroMotor);
        unVehiculo.setAnio(anio);
        unVehiculo.setKmRecorrido(kmRecorrido);
        unVehiculo.setFechaCompra(fechaCompra);
        unVehiculo.setFechaFinGarantia(fechaFinGarantia);
        unVehiculo.setKmRecorrido(kmRecorrido);
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
    public Vehiculo traerVehiculo(int codigo) throws Exception{
        return cp.traerVehiculo(codigo);
    }
    public void agregarAccesorioVehiculo(Accesorio accesorio, int codigo) throws Exception{
        Vehiculo vehiculo = cp.traerVehiculo(codigo);
        vehiculo.getMisAccesorios().add(accesorio);
        cp.editarVehiculo(vehiculo);
    }
    public void quitarAccesorioVehiculo(int accesorio, int codigo) throws Exception{
        Vehiculo vehiculo = cp.traerVehiculo(codigo);
        vehiculo.getMisAccesorios().remove(accesorio);
        cp.editarVehiculo(vehiculo);
    }
    public void agregarEquipamientoVehiculo(Equipamiento equipamiento, int codigo) throws Exception{
        Vehiculo vehiculo = cp.traerVehiculo(codigo);
        vehiculo.getMisEquipamientos().add(equipamiento);
        cp.editarVehiculo(vehiculo);
    }
    public void quitarEquipamientoVehiculo(int equipamiento, int codigo) throws Exception{
        Vehiculo vehiculo = cp.traerVehiculo(codigo);
        vehiculo.getMisEquipamientos().remove(equipamiento);
        cp.editarVehiculo(vehiculo);
    }
    public List<Vehiculo> traerVehiculosSinCliente() throws PreexistingEntityException, Exception{
        return cp.traerVehiculosSinCliente();
    }
    public List<Vehiculo> traerVehiculosConCliente(Cliente cliente) throws PreexistingEntityException, Exception{
        return cp.traerVehiculosConCliente(cliente);
    }
    
    //////////////////////// MÉTODOS DE CLIENTE /////////////////////////////
    public void nuevoCliente(int dni, String nombre, String apellido, String direccion, String telefono, String usuario, String clave, long cuil, boolean activo, Localidad localidad) throws Exception{
        if(!cp.existeCliente(dni)){
            unCliente = new Cliente(dni, nombre, apellido, direccion, telefono, usuario, clave, cuil, activo, localidad);
            cp.nuevoCliente(unCliente);
        }else{
            throw new Exception("Ya existe un Cliente con ese dni.");
        }
    }
    public void editarCliente(int codigo, int dni, String nombre, String apellido, String direccion, String telefono, String usuario, String clave, long cuil, boolean activo, Localidad localidad) throws Exception{
        if(!cp.existeCliente(dni, codigo)){
            unCliente = cp.traerCliente(codigo);
            unCliente.setDni(dni);
            unCliente.setNombre(nombre);
            unCliente.setApellido(apellido);
            unCliente.setDireccion(direccion);
            unCliente.setTelefono(telefono);
            unCliente.setUsuario(usuario);
            unCliente.setClave(clave);
            unCliente.setCuil(cuil);
            unCliente.setLocalidad(localidad);
            cp.editarCliente(unCliente);
        }else{
            throw new Exception("Ya existe otro Cliente con ese dni.");
        }
    }
    public List<Cliente> traerClientes(boolean activo) throws Exception{
        return cp.traerClientes(activo);
    }
    public Cliente traerCliente(int codigo) throws Exception{
        return cp.traerCliente(codigo);
    }
    public void eliminarCliente(int codigo) throws Exception{
        unCliente = cp.traerCliente(codigo);
        unCliente.setActivo(false);
        cp.editarCliente(unCliente);
    }
    public List<Cliente> traerClientesBusqueda(boolean activo, String apellido, int dni) throws Exception{
        return cp.traerClientesBusqueda(activo, apellido, dni);
    }
    public void agregarVehiculoCliente(Vehiculo vehiculo, int codigo) throws Exception{
        Cliente cliente = cp.traerCliente(codigo);
        cliente.getMisVehiculos().add(vehiculo);
        cp.editarCliente(cliente);
    }
    public void quitarVehiculoCliente(Vehiculo vehiculo, int codigo) throws Exception{
        Cliente cliente = cp.traerCliente(codigo);
        List<Vehiculo> vehiculos = cliente.getMisVehiculos();
        int tamanio = vehiculos.size();
        int i = 0;
        for (i=0; i < tamanio; i++) {
            if(vehiculos.get(i).getCodigo() == vehiculo.getCodigo()){
                vehiculos.remove(i);
                tamanio = tamanio - 1;
            }
        }
        cliente.setMisVehiculos(vehiculos);
        cp.editarCliente(cliente);
    }
    public void borrarClienteVehiculo(int codigoCliente, int codigoVehiculo) throws PreexistingEntityException, Exception{
        cp.borrarClienteVehiculo(codigoCliente, codigoVehiculo);
    }
    
    //////////////////////// MÉTODOS DE PIEZA RECAMBIO /////////////////////////////
    public void nuevaPiezaRecambio(String nombre, double precio, double impuesto, boolean garantia, String caracteristica, int mesesGarantia, boolean activo, TipoReparacion grupoParte) throws Exception{
        unaPiezaRecambio = new PiezaRecambio(nombre, precio, impuesto, garantia, caracteristica, mesesGarantia, activo, grupoParte);
        cp.nuevaPiezaRecambio(unaPiezaRecambio);
    }
    public void editarPiezaRecambio(int codigo, String nombre, double precio, double impuesto, boolean garantia, String caracteristica, int mesesGarantia, boolean activo, TipoReparacion grupoParte) throws Exception{
        unaPiezaRecambio = cp.traerPiezaRecambio(codigo);
        unaPiezaRecambio.setNombre(nombre);
        unaPiezaRecambio.setPrecio(precio);
        unaPiezaRecambio.setImpuesto(impuesto);
        unaPiezaRecambio.setGarantia(garantia);
        unaPiezaRecambio.setCaracteristica(caracteristica);
        unaPiezaRecambio.setMesesGarantia(mesesGarantia);
        unaPiezaRecambio.setActivo(activo);
        unaPiezaRecambio.setGrupoParte(grupoParte);
        cp.editarPiezaRecambio(unaPiezaRecambio);
    }
    public List<PiezaRecambio> traerPiezaRecambios(boolean activo) throws Exception{
        return cp.traerPiezaRecambios(activo);
    }
    public void eliminarPiezaRecambio(int codigo) throws Exception{
        unaPiezaRecambio = cp.traerPiezaRecambio(codigo);
        unaPiezaRecambio.setActivo(false);
        cp.editarPiezaRecambio(unaPiezaRecambio);
    }
    public List<PiezaRecambio> traerPiezaRecambiosBusqueda(boolean activo, String nombre, TipoReparacion tipo) throws Exception{
        return cp.traerPiezaRecambiosBusqueda(activo, nombre, tipo);
    }
    public PiezaRecambio traerPiezaRecambio(int codigo) throws Exception{
        return cp.traerPiezaRecambio(codigo);
    }

    public void agregarVehiculoCompatible(Modelo modelo, int codigo) throws Exception{
        PiezaRecambio pieza = cp.traerPiezaRecambio(codigo);
        pieza.getVehiculosCompatibles().add(modelo);
        cp.editarPiezaRecambio(pieza);
    }
    public void quitarVehiculoCompatible(int modelo, int codigo) throws Exception{
        PiezaRecambio pieza = cp.traerPiezaRecambio(codigo);
        pieza.getVehiculosCompatibles().remove(modelo);
        cp.editarPiezaRecambio(pieza);
    }
    public List<PiezaRecambio> traerPiezasSinVinculoConProceso(Proceso unProceso) {
        return cp.traerPiezasSinVinculoConProceso(unProceso);
    }

    public List<PiezaRecambio> traerPiezasConVinculoConProceso(Proceso unProceso) {
        return cp.traerPiezasConVinculoConProceso(unProceso);
    }
    
         ///////////////// METODOS DE PROVEEDOR ///////////////////
    public void nuevoProveedor(String nombre, String rs, String direccion,  String telefono, long cuit) throws Exception{
        unProveedor = new Proveedor(nombre, rs, direccion, telefono, cuit, true);
        cp.nuevoProveedor(unProveedor);
    }
    public void editarProveedor(int codigo, String nombre, String rs, String direccion,  String telefono, long cuit) throws Exception{
        unProveedor = cp.traerProveedor(codigo);
        unProveedor.setNombre(nombre);
        unProveedor.setRazonSocial(rs);
        unProveedor.setDireccion(direccion);
        unProveedor.setTelefono(telefono);
        unProveedor.setCuit(cuit);
        cp.editarProveedor(unProveedor);
    }
    public List<Proveedor> traerProveedor(boolean activo) throws Exception{
        return cp.traerProveedores(activo);
    }
    public List<Proveedor> traerProveedorNombre(boolean activo, String nombre)throws Exception{
        return cp.traerProveedorNombre(activo, nombre);
    }
    public void eliminarProveedor(int codigo) throws Exception{
        unProveedor = cp.traerProveedor(codigo);
        unProveedor.setActivo(false);
        cp.editarProveedor(unProveedor);
    }
    
        ///////////// MÉTODOS DE EJEMPLAR ///////////////////
    public void nuevoEjemplar(java.util.Date fechaIng, PiezaRecambio unaPRecambio, Proveedor unProveedor, int deposito) throws Exception{
        unEjemplar = new Ejemplar(fechaIng, unaPRecambio, unProveedor, true);
        cp.nuevoEjemplar(unEjemplar);
        Deposito miDeposito = cp.traerDeposito(deposito);
        int codigoEjemplar = cp.ultimaEjemplar();
        Ejemplar ejemplar = cp.traerEjemplar(codigoEjemplar);
        miDeposito.getMisEjemplares().add(ejemplar);
        cp.editarDeposito(miDeposito);
    }

    public void editarEjemplar(int codigo, java.util.Date fechaIng, PiezaRecambio unaPRecambio, Proveedor unProveedor) throws Exception{
        unEjemplar = cp.traerEjemplar(codigo);
        unEjemplar.setFechaIngreso(fechaIng);
        unEjemplar.setUnaPiezaRecambio(unaPiezaRecambio);
        unEjemplar.setUnProveedor(unProveedor);
        cp.editarEjemplar(unEjemplar);
    }
    public List<Ejemplar> traerEjemplares(boolean activo) throws Exception{
        return cp.traerEjemplares(activo);
    }
    public void eliminarEjemplar(int codigo, int codigoDeposito) throws Exception{
        Ejemplar unEjemplar1 = cp.traerEjemplar(codigo);
        unEjemplar1.setActivo(false);
        cp.editarEjemplar(unEjemplar);
        Deposito deposito = cp.traerDeposito(codigoDeposito);
        List<Ejemplar> ejemplares = deposito.getMisEjemplares();
        int tamanio = ejemplares.size();
        int i = 0;
        for (i=0; i < tamanio; i++) {
            if(ejemplares.get(i).getCodigo() == unEjemplar1.getCodigo()){
                ejemplares.remove(i);
                tamanio = tamanio - 1;
            }
        }
        deposito.setMisEjemplares(ejemplares);
        cp.editarDeposito(deposito);
        
    }
    public List<Ejemplar> traerEjemplarCodigo(boolean activo, int codigo) throws Exception{
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
    
    ////////////////// MÉTODOS DE MECANICO ////////////////////////
    public void nuevoMecanico (int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception{
        if(cp.existeMecanico(dni)){
            throw new Exception ("Error: Ya existe un Mecanico con ese DNI.");
        }else{
            unMecanico = new Mecanico(dni, nombre, apellido, telefono, direccion, cuil, activo);
            cp.nuevoMecanico(unMecanico);
        }
    }
    public void editarMecanico(int codigo, int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception{
        if(cp.existeMecanico(dni, codigo)){
            throw new Exception ("Error: Ya existe otro Mecanico con ese DNI.");
        }else{
            unMecanico = (Mecanico) cp.traerMecanico(codigo);
            unMecanico.setDni(dni);
            unMecanico.setNombre(nombre);
            unMecanico.setApellido(apellido);
            unMecanico.setTelefono(telefono);
            unMecanico.setDireccion(direccion);
            unMecanico.setCuil(cuil);
            cp.editarEmpleado(unMecanico);
        }    
    }
    public List<Mecanico> traerMecanicos(boolean activo) throws Exception{
        return cp.traerMecanicos(activo);
    }
    public void eliminarMecanico(int codigo) throws Exception{
        unMecanico = (Mecanico) cp.traerMecanico(codigo);
        unMecanico.setActivo(false);
        cp.editarMecanico(unMecanico);
    }
    public List<Mecanico> traerMecanicosBusqueda(boolean activo, String apellido, int dni) throws Exception{
        return cp.traerMecanicosBusqueda(activo, apellido, dni);
    }
    
    public Mecanico traerMecanico(int codigo) throws Exception{
        return cp.traerMecanico(codigo);
    }

    public void agregarEspecialidad(Especialidad unaEspecialidad, int codigo) throws Exception{
        unMecanico = cp.traerMecanico(codigo);
        unMecanico.getMisEspecialidades().add(unaEspecialidad);
        cp.editarMecanico(unMecanico);
    }
    public void quitarEspecialidad(int especialidad, int codigo) throws Exception{
        unMecanico = cp.traerMecanico(codigo);
        unMecanico.getMisEspecialidades().remove(especialidad);
        cp.editarMecanico(unMecanico);
    }
    
    public void agregarPedido(Pedido unPedido, int codigo) throws Exception{
        unMecanico = cp.traerMecanico(codigo);
        unMecanico.getMisPedidos().add(unPedido);
        cp.editarMecanico(unMecanico);
    }
    public void quitarPedido(int pedido, int codigo) throws Exception{
        unMecanico = cp.traerMecanico(codigo);
        unMecanico.getMisPedidos().remove(pedido);
        cp.editarMecanico(unMecanico);
    }
    public List<Mecanico> traerMecanicoSinTaller(){
        return cp.traerMecanicoSinTaller();
    }
    public List<Mecanico> traerMecanicoConCliente(int codigoTaller){
        return cp.traerMecanicoConCliente(codigoTaller);
    }
    public void agregarMecanico(int codigoMecanido, int codigoTaller) throws PreexistingEntityException, Exception{
        Taller taller = cp.traerTaller(codigoTaller);
        Mecanico mecanico = cp.traerMecanico(codigoMecanido);
        taller.getMisMecanicos().add(mecanico);
        cp.editarTaller(taller);
    }
    public void quitarMecanico(int codigoMecanido, int codigoTaller) throws PreexistingEntityException, Exception{
        Taller taller = cp.traerTaller(codigoTaller);
        List<Mecanico> mecanicos = taller.getMisMecanicos();
        int tamanio = mecanicos.size();
        int i = 0;
        for (i=0; i < tamanio; i++) {
            if(mecanicos.get(i).getCodigo() == codigoMecanido){
                mecanicos.remove(i);
                tamanio = tamanio - 1;
            }
        }
        taller.setMisMecanicos(mecanicos);
        cp.editarTaller(taller);
    }
    
    
    ///////////////// METODOS DE PEDIDO ///////////////////

    public void nuevoPedido(java.util.Date fecha, java.util.Date hora, String descripcion, int cantidad, boolean autorizado, boolean paraRecambio, boolean activo, JefeDeposito unJefeDeposito, JefeTaller unJefeTaller, Cliente unCliente, PiezaRecambio unaPieza, Vehiculo unVehiculo) throws Exception{
        unPedido = new Pedido(fecha, hora, descripcion, cantidad, autorizado, paraRecambio,true, unJefeDeposito, unJefeTaller, unCliente, unaPieza, unVehiculo);
        cp.nuevoPedido(unPedido);
    }
    public void editarPedido(int codigo, java.util.Date fecha, java.util.Date hora, String descripcion, int cantidad, boolean autorizado, boolean paraRecambio, boolean activo, JefeDeposito unJefeDeposito, JefeTaller unJefeTaller, Cliente unCliente, PiezaRecambio unaPieza, Vehiculo unVehiculo) throws Exception{
        unPedido = cp.traerPedido(codigo);
        unPedido.setFecha(fecha);
        unPedido.setHora(hora);
        unPedido.setDescripcion(descripcion);
        unPedido.setCantidad(cantidad);
        unPedido.setParaRecambio(paraRecambio);
        unPedido.setActivo(activo);
        unPedido.setUnJefeDeposito(unJefeDeposito);
        unPedido.setUnJefeTaller(unJefeTaller);
        unPedido.setUnCliente(unCliente);
        unPedido.setUnaPieza(unaPieza);
        unPedido.setUnVehiculo(unVehiculo);
        cp.editarPedido(unPedido);
    }
    public void nuevoPedido(Date fecha, Date hora, String descripcion, int cantidad, boolean autorizado, boolean paraRecambio, boolean activo, JefeDeposito unJefeDeposito, JefeTaller unJefeTaller, Cliente unCliente) throws Exception{
        Pedido unPedido1 = new Pedido(fecha, hora, descripcion, cantidad, autorizado, paraRecambio,true, unJefeDeposito, unJefeTaller, unCliente);
        cp.nuevoPedido(unPedido1);
    }
    public void editarPedido(int codigo, Date fecha, Date hora, String descripcion, int cantidad, boolean autorizado, boolean paraRecambio, boolean activo, JefeDeposito unJefeDeposito, JefeTaller unJefeTaller, Cliente unCliente) throws Exception{
        Pedido unPedido1 = cp.traerPedido(codigo);
        unPedido1.setFecha(fecha);
        unPedido1.setHora(hora);
        unPedido1.setDescripcion(descripcion);
        unPedido1.setCantidad(cantidad);
        unPedido1.setParaRecambio(paraRecambio);
        unPedido1.setActivo(activo);
        unPedido1.setUnJefeDeposito(unJefeDeposito);
        unPedido1.setUnJefeTaller(unJefeTaller);
        unPedido1.setUnCliente(unCliente);
        //faltan todos los set
        cp.editarPedido(unPedido1);

    }
    public List<Pedido> traerPedidos(boolean activo) throws Exception{
        return cp.traerPedidos(activo);
    }
    public List<Pedido> traerPedidosCodigo(boolean activo, int codigo)throws Exception{
        return cp.traerPedidosCodigo(activo, codigo);
    }
    public void eliminarPedido(int codigo) throws Exception{
        Pedido unPedido1 = cp.traerPedido(codigo);
        unPedido1.setActivo(false);
        cp.editarPedido(unPedido1);
    }
    public List<Pedido> traerPedidosSinVinculo(Mecanico unMecanico) throws Exception{
        return cp.traerPedidosSinVinculo(unMecanico);
    }
    public List<Pedido> traerPedidosConVinculo(Mecanico unMecanico) throws Exception{
        return cp.traerPedidosConVinculo(unMecanico);
    }
    public List<Pedido> traerPedidosDeVehiculo(String dominio){
        return cp.traerPedidosDeVehiculo(dominio);
    }
    public Pedido traerPedido(int codigo) throws Exception{
        return cp.traerPedido(codigo);
    }    
    public void agregarInfoAPedido(Pedido unPedido, InformePiezaPedido unInforme) throws Exception{
        unPedido.setUnInforme(unInforme);
        cp.editarPedido(unPedido);
    }

    ////////////////// MÉTODOS DE JEFE DE TALLER ////////////////////////
    public void nuevoJefeTaller (int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception{
        if(cp.existeJefeTaller(dni)){
            throw new Exception ("Error: Ya existe un Jefe de taller con ese DNI.");
        }else{
            JefeTaller unJefeTaller1 = new JefeTaller(dni, nombre, apellido, telefono, direccion, cuil, activo);
            cp.nuevoJefeTaller(unJefeTaller1);
        }
    }
    public void editarJefeTaller(int codigo, int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception{
        if(cp.existeJefeTaller(dni, codigo)){
            throw new Exception ("Error: Ya existe otro Jefe con ese DNI.");
        }else{
            JefeTaller unJefeTaller1 = cp.traerJefeTaller(codigo);
            unJefeTaller1.setDni(dni);
            unJefeTaller1.setNombre(nombre);
            unJefeTaller1.setApellido(apellido);
            unJefeTaller1.setTelefono(telefono);
            unJefeTaller1.setDireccion(direccion);
            unJefeTaller1.setCuil(cuil);
            cp.editarJefeTaller(unJefeTaller1);
        }    
    }
    public List<JefeTaller> traerJefesTaller(boolean activo) throws Exception{
        return cp.traerJefesTaller(activo);
    }
    public void eliminarJefeTaller(int codigo) throws Exception{
        JefeTaller unJefeTaller1 = cp.traerJefeTaller(codigo);
        unJefeTaller1.setActivo(false);
        cp.editarJefeTaller(unJefeTaller1);
    }
    public List<JefeTaller> traerJefesTallerBusqueda(boolean activo, String apellido, int dni) throws Exception{
        return cp.traerJefesTallerBusqueda(activo, apellido, dni);
    }
    
    ////////////////// MÉTODOS DE JEFE DE DEPOSITO ////////////////////////
    public void nuevoJefeDeposito (int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception{
        if(cp.existeJefeDeposito(dni) != null){
            throw new Exception ("Error: Ya existe un empleado con ese DNI.");
        }else{
            JefeDeposito unJefeDeposito1 = new JefeDeposito(dni, nombre, apellido, telefono, direccion, cuil, activo);
            cp.nuevoJefeDeposito(unJefeDeposito1);
        }
    }
    public void editarJefeDeposito(int codigo, int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception{
        if(cp.existeJefeDeposito(dni, codigo)){
            throw new Exception ("Error: Ya existe otro Jefe con ese DNI.");
        }else{
            JefeDeposito unJefeDeposito1 = cp.traerJefeDeposito(codigo);
            unJefeDeposito1.setDni(dni);
            unJefeDeposito1.setNombre(nombre);
            unJefeDeposito1.setApellido(apellido);
            unJefeDeposito1.setTelefono(telefono);
            unJefeDeposito1.setDireccion(direccion);
            unJefeDeposito1.setCuil(cuil);
            cp.editarJefeDeposito(unJefeDeposito1);
        }    
    }
    public List<JefeDeposito> traerJefesDeposito(boolean activo) throws Exception{
        return cp.traerJefeDeposito(activo);
    }
    public void eliminarJefeDeposito(int codigo) throws Exception{
        JefeDeposito unJefeDeposito1 = cp.traerJefeDeposito(codigo);
        unJefeDeposito1.setActivo(false);
        cp.editarJefeDeposito(unJefeDeposito1);
    }
    public List<JefeDeposito> traerJefesDepositoBusqueda(boolean activo, String apellido, int dni) throws Exception{
        return cp.traerJefesDepositoBusqueda(activo, apellido, dni);
    }
    public JefeDeposito existeJefeDeposito(int dni) throws Exception{
        return cp.existeJefeDeposito(dni);
    }
    
    ////////////////// MÉTODOS DE PERITO ////////////////////////
    public void nuevoPerito (int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception{
        if(cp.existePerito(dni)){
            throw new Exception ("Error: Ya existe un Perito con ese DNI.");
        }else{
           Perito unPerito1 = new Perito(dni, nombre, apellido, telefono, direccion, cuil, activo);
            cp.nuevoPerito(unPerito1);
        }
    }
    public void editarPerito(int codigo, int dni, String nombre, String apellido, String telefono, String direccion, long cuil, boolean activo) throws Exception{
        if(cp.existePerito(dni, codigo)){
            throw new Exception ("Error: Ya existe otro Perito con ese DNI.");
        }else{
            Perito unPerito1 = (Perito) cp.traerPerito(codigo);
            unPerito1.setDni(dni);
            unPerito1.setNombre(nombre);
            unPerito1.setApellido(apellido);
            unPerito1.setTelefono(telefono);
            unPerito1.setDireccion(direccion);
            unPerito1.setCuil(cuil);
            cp.editarPerito(unPerito1);
        }    
    }
    public List<Perito> traerPeritos(boolean activo) throws Exception{
        return cp.traerPeritos(activo);
    }
    public void eliminarPerito(int codigo) throws Exception{
        Perito unPerito1 = (Perito) cp.traerPerito(codigo);
        unPerito1.setActivo(false);
        cp.editarPerito(unPerito1);
    }
    public List<Perito> traerPeritosBusqueda(boolean activo, String apellido, int dni) throws Exception{
        return cp.traerPeritosBusqueda(activo, apellido, dni);
    }
    
    public Perito traerPerito(int codigo) throws Exception{
        return cp.traerPerito(codigo);
    }

    public void agregarInforme(InformePiezaPedido unInforme, int codigo) throws Exception{
        Perito unPerito1 = cp.traerPerito(codigo);
        unPerito1.getMisInformesPPedido().add(unInforme);
        cp.editarPerito(unPerito1);
    }
    public void quitarInforme(int miInforme, int codigo) throws Exception{
        Perito unPerito1 = cp.traerPerito(codigo);
        unPerito1.getMisInformesPPedido().remove(miInforme);
        cp.editarPerito(unPerito1);
    }
    
    
    ////////////////////// MÉTODOS DE INFORMES /////////////////////////////
    public void nuevoInforme(boolean aprobado, java.util.Date fecha, boolean activo, PiezaRecambio pieza) throws Exception{
        unInforme = new InformePiezaPedido(aprobado,fecha, true, pieza);
        cp.nuevoInforme(unInforme);
    }
    public void editarInforme(int codigo, boolean aprobado, java.util.Date fecha, boolean activo, PiezaRecambio pieza) throws Exception{
        unInforme = cp.traerInforme(codigo);
        unInforme.setAprobado(aprobado);
        unInforme.setFecha(fecha);
        unInforme.setUnaPieza(pieza);
        cp.editarInforme(unInforme);
    }
    public void eliminarInforme(int codigo) throws Exception{
        unInforme = cp.traerInforme(codigo);
        unInforme.setActivo(false);
        cp.editarInforme(unInforme);
       }
    
    public InformePiezaPedido recuperarUltimoInforme() throws Exception{
        int codigoUInf = cp.recuperarUltimoInforme();
        InformePiezaPedido unInf = this.cp.traerInforme(codigoUInf);
        return unInf;
    }
    public List<InformePiezaPedido> traerInformes(boolean activo){
        return this.cp.traerInformes(activo);
    }
     public List<InformePiezaPedido> traerInformeSinVinculo(Perito unPerito) {
        return cp.traerInformeSinVinculo(unPerito);
    }

    public List<InformePiezaPedido> traerInformesConVinculo(Perito unPerito) {
        return cp.traerInformesConVinculo(unPerito);
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
        Devolucion devolucion = new Devolucion(fecha, motivo, activo, miPiezaRecambio);
        cp.nuevaDevolucion(devolucion);
        Deposito deposito = cp.traerDeposito(codigoDeposito);
        int codigoDevolucion = cp.ultimaDevolcion();
        Devolucion devolucionU = cp.traerDevolucion(codigoDevolucion);
        deposito.getMisDevoluciones().add(devolucionU);
        cp.editarDeposito(deposito);
        
        
    }
    public void editarDevolucion(int codigo, Date fecha, String motivo, boolean activo, PiezaRecambio miPiezaRecambio) throws PreexistingEntityException, Exception{
        Devolucion devolucion = traerDevolucion(codigo);
        devolucion.setFecha(fecha);
        devolucion.setMotivo(motivo);
        devolucion.setMiPiezaRecambio(miPiezaRecambio);
        cp.editarDevolucion(devolucion);
    }
    public Devolucion traerDevolucion(int codigo) throws PreexistingEntityException, Exception{
        return cp.traerDevolucion(codigo);
    }
    public List<Devolucion> traerDevoluciones(boolean activo) throws PreexistingEntityException, Exception{
        return cp.traerDevoluciones(activo);
    }
    public void eliminarDevolucion(int codigo, int deposito) throws NonexistentEntityException, Exception{
        Devolucion devolucion = cp.traerDevolucion(codigo);
        devolucion.setActivo(false);
        cp.editarDevolucion(devolucion);
        Deposito miDeposito = cp.traerDeposito(deposito);
        List<Devolucion> devo = miDeposito.getMisDevoluciones();
        int tamanio = devo.size();
        int i = 0;
        for (i=0; i < tamanio; i++) {
            if(devo.get(i).getCodigo() == devolucion.getCodigo()){
                devo.remove(i);
                tamanio = tamanio - 1;
            }
        }
        cp.editarDeposito(miDeposito);
        
    }
    public List<Devolucion> traerDevolucionesBusqueda(boolean activo, java.util.Date fecha) throws PreexistingEntityException, Exception{
        return cp.traerDevolucionesBusqueda(activo, fecha);
    }
    public List<Devolucion> traerDevolucionesSinDeposito() throws PreexistingEntityException, Exception{
        return cp.traerDevolucionesSinDeposito();
    }
    public List<Devolucion> traerDevolucionesConDeposito(int deposito) throws PreexistingEntityException, Exception{
        return cp.traerDevolucionesConDeposito(deposito);
    }
    public List<Devolucion> traerDevolucionesConDeposito(int deposito, String fecha) throws PreexistingEntityException, Exception{
        return cp.traerDevolucionesConDeposito(deposito, fecha);
    }
   
    /////////////////////// METODOS DE TALLER ////////////////////////////////
    public void nuevoTaller(String nombre, String direccion, String telefono, String correo, Date horaEntrada, Date horaSalida, boolean activo, JefeTaller unJefeTaller, Localidad unaLocalidad) throws PreexistingEntityException, Exception{
        int codigoDeposito = this.ultimoDeposito();
        Deposito unDeposito = this.traerDeposito(codigoDeposito);
        Taller taller = new Taller(nombre, direccion, telefono, correo, horaEntrada, horaSalida, activo, unDeposito, unJefeTaller, unaLocalidad);
        cp.nuevoTaller(taller);
    }
    public void editarTaller(int codigo, String nombre, String direccion, String telefono, String correo, Date horaEntrada, Date horaSalida, boolean activo, Deposito unDeposito, JefeTaller unJefeTaller, Localidad unaLocalidad) throws PreexistingEntityException, Exception{
        Taller taller = traerTaller(codigo);
        taller.setNombre(nombre);
        taller.setDireccion(direccion);
        taller.setTelefono(telefono);
        taller.setCorreo(correo);
        taller.setHoraEntrada(horaEntrada);
        taller.setHoraSalida(horaSalida);
        taller.setActivo(activo);
        taller.setUnDeposito(unDeposito);
        taller.setUnJefeTaller(unJefeTaller);
        taller.setUnaLocalidad(unaLocalidad);
        cp.editarTaller(taller);
    }
  
    public List<Taller> traerTalleres(boolean activo) throws PreexistingEntityException, Exception{
        return cp.traerTalleres(activo);
    }
    public void eliminarTaller(int codigo) throws NonexistentEntityException, Exception{
        Taller taller = traerTaller(codigo);
        this.eliminarDeposito(taller.getUnDeposito().getCodigo());
        cp.eliminarTaller(codigo);
    }
    public List<Taller> traerTallerNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
        return cp.traerTallerNombre(activo, nombre);
    }   
    public Taller traerTaller(int codigo) throws PreexistingEntityException, Exception{
        return cp.traerTaller(codigo);
    }
    public void agregarZonaTaller(Localidad localidad, int codigo) throws Exception{
        Taller taller = this.traerTaller(codigo);
        taller.getZonasCubiertas().add(localidad);
        cp.editarTaller(taller);
    }
    public void quitarZonaTaller(int localidad, int codigo) throws Exception{
       Taller taller = this.traerTaller(codigo);
        List<Localidad> localidades = taller.getZonasCubiertas();
        int tamanio = localidades.size();
        int i = 0;
        for (i=0; i < tamanio; i++) {
            if(localidades.get(i).getCodigo() == localidad){
                localidades.remove(i);
                tamanio = tamanio - 1;
            }
        }
        taller.setZonasCubiertas(localidades);
        cp.editarTaller(taller);
    }
    
    /////////////////////// METODOS DE DEPOSITO ////////////////////////////////
    public void nuevoDeposito(String nombre, String correo, String telefono, boolean activo, JefeDeposito unJefeDeposito) throws PreexistingEntityException, Exception{
        Deposito deposito = new Deposito(nombre, correo, telefono, activo, unJefeDeposito);
        cp.nuevoDeposito(deposito);
    }
    public void editarDeposito(int codigo, String nombre, String correo, String telefono, boolean activo, JefeDeposito unJefeDeposito) throws PreexistingEntityException, Exception{
        Deposito deposito = cp.traerDeposito(codigo);
        deposito.setNombre(nombre);
        deposito.setCorreo(correo);
        deposito.setTelefono(telefono);
        deposito.setActivo(activo);
        deposito.setUnJefeDeposito(unJefeDeposito);
        cp.editarDeposito(deposito);
    }
    public void eliminarDeposito(int codigo) throws NonexistentEntityException, Exception{
        Deposito deposito = cp.traerDeposito(codigo);
        deposito.setActivo(false);
        cp.editarDeposito(deposito);
    }
    public Deposito traerDeposito(int codigo) throws NonexistentEntityException, Exception{
        return cp.traerDeposito(codigo);
    }
    public int ultimoDeposito() throws NonexistentEntityException, Exception{
        return cp.ultimoDeposito();
    }
    
     /////////////////////// METODOS DE AGENDA MENSUAL ////////////////////////////////
    public void nuevaAgendaMensual(String nombre, int anio, int nroMes, boolean activo, int codigoTaller) throws PreexistingEntityException, Exception{
        AgendaMensual agenda = new AgendaMensual(nombre, anio, nroMes, activo);
        cp.nuevaAgendaMensual(agenda);
        int codigoAgenda = cp.ultimoAgendaMensual();
        AgendaMensual agendaM = cp.traerAgendaMensual(codigoAgenda);
        Taller taller = cp.traerTaller(codigoTaller);
        taller.getMisAgendasMensuales().add(agendaM);
        List<Mecanico> mecanicos = taller.getMisMecanicos();
        cp.editarTaller(taller);
        int cantidadMecanicos = taller.getMisMecanicos().size();
        int diasTotal = this.diasDelMes(nroMes-1, anio);
        int domingos = CuantosDomingos(nroMes-1);
        int diasHabiles = diasTotal - domingos;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(taller.getHoraEntrada());
        int horaEntradaTaller = calendar.get(Calendar.HOUR_OF_DAY);
        int i = 0;
        int j = 0;
        int k = 0;

        for(i=0; i < diasTotal; i++){
//            System.out.println("Cantidad de mecanicos: "+cantidadMecanicos);
            for(j = 0; j < cantidadMecanicos; j++){
                String fechaInicio = i+1+"/"+nroMes+"/"+anio;
                Date fechaD = util.ParseFecha(fechaInicio, "Error");
//                System.out.println("que dia es: "+this.queDiaEs(fechaD));
                if(this.queDiaEs(fechaD) != 1){
                    
                    for(k = 0; k < 8; k++){
                        Date hInicio = util.hora((horaEntradaTaller+k)+":00:00", nombre);
                        Date hFin = util.hora((horaEntradaTaller+k+1)+":00:00", nombre);
                        Modulo modulo = new Modulo(hInicio, hFin, fechaD, k+1, true, true, mecanicos.get(j));
                        cp.nuevoModulo(modulo);
                        int codigoultimoModulo = cp.ultimoModulo();
                        Modulo ultimoModulo = cp.traerModulo(codigoultimoModulo);
                        this.agregarModuloAgenda(ultimoModulo, codigoAgenda);
                    }
                }else{
                    
                }
            }
        }
//        System.out.println("Dias total: "+diasTotal);
//        System.out.println("Dias habiles: "+diasHabiles);
//        System.out.println("Domingos: "+domingos);
//        System.out.println("Hora de entrada: "+horaEntradaTaller);
        
    }
    public void editarAgendaMensual(int codigo, String nombre, int anio, int nroMes, boolean activo) throws PreexistingEntityException, Exception{
        AgendaMensual agendaMensual = cp.traerAgendaMensual(codigo);
        agendaMensual.setNombre(nombre);
        agendaMensual.setAnio(anio);
        agendaMensual.setNroMes(nroMes);  
        cp.editarAgendaMensual(agendaMensual);
        
    }
    public void eliminarAgendaMensual(int codigoAgenda, int codigoTaller) throws NonexistentEntityException, Exception{
        AgendaMensual agenda = cp.traerAgendaMensual(codigoAgenda);
        agenda.setActivo(false);
        cp.editarAgendaMensual(agenda);
        Taller taller = this.traerTaller(codigoTaller);
        List<AgendaMensual> agendas = taller.getMisAgendasMensuales();
        int tamanio = agendas.size();
        int i = 0;
        for (i=0; i < tamanio; i++) {
            if(agendas.get(i).getCodigo() == codigoAgenda){
                agendas.remove(i);
                tamanio = tamanio - 1;
            }
        }
        taller.setMisAgendasMensuales(agendas);
        cp.editarTaller(taller);
        
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
    public List<AgendaMensual> traerAgendaMensualSinTaller(){
        return cp.traerAgendaMensualSinTaller();
    }
    
    public List<AgendaMensual> traerAgendaMensualConTaller(int codigoTaller) throws NonexistentEntityException, Exception{
        return cp.traerAgendaMensualConTaller(codigoTaller);
    }
    public void agregarModuloAgenda(Modulo modulo, int codigoAgenda) throws NonexistentEntityException, Exception{
        AgendaMensual agenda = cp.traerAgendaMensual(codigoAgenda);
        agenda.getMisModulos().add(modulo);
        cp.editarAgendaMensual(agenda);
    }
    
    
    ///////////////// MÉTODOS DE TIPO DIAGNOSTICO ///////////////////
    public void nuevoTipoDiagnostico(String nombre, String descripcion,  boolean activo) throws Exception{
        unTipoDiagnostico = new TipoDiagnostico(nombre, descripcion,  true);
        cp.nuevoTipoDiagnostico(unTipoDiagnostico);
    }
    public void editarTipoDiagnostico(int codigo, String nombre, String descripcion, int cantModulos, boolean activo) throws Exception{
        unTipoDiagnostico = cp.traerTD(codigo);
        unTipoDiagnostico.setNombre(nombre);
        unTipoDiagnostico.setDescripcion(descripcion);
        unTipoDiagnostico.setCatidadModulos(cantModulos);
        cp.editarTipoDiagnostico(unTipoDiagnostico);
    }
    public List<TipoDiagnostico> traerTipoDiagnostico(boolean activo) throws Exception{
        return cp.traerTipoDiagnostico(activo);
    }
    public void eliminarTipoDiagnostico(int codigo) throws Exception{
        unTipoDiagnostico = cp.traerTD(codigo);
        unTipoDiagnostico.setActivo(false);
        cp.editarTipoDiagnostico(unTipoDiagnostico);
    }
    public List<TipoDiagnostico> traerTipoDiagnosticoNombre(boolean activo, String nombre) throws Exception{
        return cp.traerTipoDiagnosticoNombre(activo, nombre);
    }
    public TipoDiagnostico traerTD(int codigo) throws Exception{
        return cp.traerTD(codigo);
    }
    public void agregarProcesoADiagnostico(TipoDiagnostico unTD, Proceso unProceso) throws Exception{
        unTD.getMisProcesos().add(unProceso);
        int totalM = unTD.getCatidadModulos();
        totalM = totalM + unProceso.getCantidadModulos();
        unTD.setCatidadModulos(totalM);
        cp.editarTipoDiagnostico(unTD);
    }
    
    ////////////////////// MÉTODOS DE PROCESO /////////////////////////////
    public void nuevoProceso(String nombre, String descripcion, int cantModulos, boolean activo, Especialidad unaEsp) throws Exception{
        unProceso = new Proceso(nombre, descripcion, cantModulos, activo, unaEsp);
        cp.nuevoProceso(unProceso);
    }
    public void editarProceso(int codigo, String nombre, String descripcion, int cantModulos, boolean activo, Especialidad unaEsp) throws Exception{
        unProceso = cp.traerProceso(codigo);
        unProceso.setNombre(nombre);
        unProceso.setDescripcion(descripcion);
        unProceso.setCantidadModulos(cantModulos);
        unProceso.setActivo(activo);
        unProceso.setUnaEspecialidad(unaEsp);
        cp.editarProceso(unProceso);
    }
    public List<Proceso> traerProcesos(boolean activo) throws Exception{
        return cp.traerProcesos(activo);
    }
    public void eliminarProceso(int codigo) throws Exception{
        unProceso = cp.traerProceso(codigo);
        unProceso.setActivo(false);
        cp.editarProceso(unProceso);
    }
    public List<Proceso> traerProcesosNombre(boolean activo, String nombre) throws Exception{
        return cp.traerProcesosNombre(activo, nombre);
    }
    public Proceso traerProceso(int codigo) throws Exception{
        return cp.traerProceso(codigo);
    }
    public void agregarPiezaAProceso(PiezaRecambio unaPieza, int codigo) throws Exception {
       unProceso = this.cp.traerProceso(codigo);
        unProceso.getMisPiezasRecambios().add(unaPieza);
        cp.editarProceso(unProceso);
    }
    public void quitarPiezaDeProceso(int codigoPieza, int codigoProceso) throws Exception{
        Proceso unProceso = cp.traerProceso(codigoProceso);
        List<PiezaRecambio> miLista = unProceso.getMisPiezasRecambios();
        int i = 0;
        int tamanio = miLista.size();
        for(i=0; i<tamanio; i++){
            if(miLista.get(i).getCodigo() == codigoPieza){
//                unProceso.getMisPiezasRecambios().remove(i);
                miLista.remove(i);
                tamanio = tamanio - 1;
            }
        }        
        unProceso.setMisPiezasRecambios(miLista);
        cp.editarProceso(unProceso);
    }
    
    public List<Proceso> traerProcesosConTipoDiagnostico(int diagnostico){
       return this.cp.traerProcesosConTipoDiagnostico(diagnostico);
    }
    public Proceso recuperarUltimoProceso() throws Exception{
        int codigoP = this.cp.recuperarUltimoProceso();
        return this.cp.traerProceso(codigoP);
    }
    

///////////////// MÉTODOS DE DIAGNOSTICO ///////////////////
    public void nuevoDiagnostico(TipoDiagnostico unTipo, String nombre, String descripcion, double costo, double impuesto,  boolean activo) throws Exception{
        unDiagnostico = new Diagnostico(unTipoDiagnostico, nombre, descripcion, costo, impuesto, activo);
        cp.nuevoDiagnostico(unDiagnostico);
    }
    public void editarDiagnostico(int codigo, TipoDiagnostico unTipo, String nombre, String descripcion, double costo, double impuesto,  boolean activo) throws Exception{
        unDiagnostico = cp.traerDiagnostico(codigo);
        unDiagnostico.setNombre(nombre);
        unDiagnostico.setDescripcion(descripcion);
        unDiagnostico.setCosto(costo);
        unDiagnostico.setImpuesto(impuesto);
        unDiagnostico.setUnTipoDiagnostico(unTipo);
        cp.editarDiagnostico(unDiagnostico);
    }
    public List<Diagnostico> traerDiagnostico(boolean activo) throws Exception{
        return cp.traerDiagnostico(activo);
    }
    public void eliminarDiagnostico(int codigo) throws Exception{
        unDiagnostico = cp.traerDiagnostico(codigo);
        unDiagnostico.setActivo(false);
        cp.editarDiagnostico(unDiagnostico);
    }
    public List<Diagnostico> traerDiagnosticoNombre(boolean activo, String nombre) throws Exception{
        return cp.traerDiagnosticoNombre(activo, nombre);
    }
    public Diagnostico traerDiagnostico(int codigo) throws Exception{
        return cp.traerDiagnostico(codigo);
    }
    public void agregarAnomaliaADiagnostico(Diagnostico unDiagnostico, Anomalia unaAnomalia) throws Exception{
        unDiagnostico.getMisAnomalias().add(unaAnomalia);
        cp.editarDiagnostico(unDiagnostico);
    }
    public void quitarAnomaliaDeDiagnostico(int codigoAnomalia, int codigoDiag) throws Exception{
        Diagnostico unDiagnostico = cp.traerDiagnostico(codigoDiag);
        List<Anomalia> miLista = unDiagnostico.getMisAnomalias();
        int i = 0;
        int tamanio = miLista.size();
        for(i=0; i<tamanio; i++){
            if(miLista.get(i).getCodigo() == codigoAnomalia){
                miLista.remove(i);
                tamanio = tamanio - 1;
            }
        }        
        unDiagnostico.setMisAnomalias(miLista);
        cp.editarDiagnostico(unDiagnostico);
    }
    
    
    ///////////////// METODOS DE TURNO ////////////////////////
    public void nuevoTurno(java.util.Date fecha, java.util.Date hora, Trazabilidad unaTrazabilidad, Servicio unServicio, Vehiculo unVehiculo, Cliente unCliente, boolean activo) throws Exception {
        unTurno = new Turno(fecha, hora, unaTrazabilidad, unServicio, unVehiculo, unCliente, true);
        cp.nuevoTurno(unTurno);
    }

    public void editarTurno(int codigo, java.util.Date fecha, java.util.Date hora, Trazabilidad unaTrazabilidad, Servicio unServicio, Vehiculo unVehiculo, Cliente unCliente, boolean activo) throws Exception {
        unTurno.setFecha(fecha);
        unTurno.setHora(hora);
        unTurno.setUnaTrazabilidad(unaTrazabilidad);
        unTurno.setUnServicio(unServicio);
        unTurno.setUnVehiculo(unVehiculo);
        unTurno.setUnCliente(unCliente);
        unTurno.setActivo(activo);
        cp.editarTurno(unTurno);
    }

    public List<Turno> traerTurnos(boolean activo, int codigoAg) throws Exception {
        return cp.traerTurnos(activo, codigoAg);
    }
    public int diasDelMes(int mes, int año){
        switch(mes){
            case 0:  // Enero
            case 2:  // Marzo
            case 4:  // Mayo
            case 6:  // Julio
            case 7:  // Agosto
            case 9:  // Octubre
            case 11: // Diciembre
                return 31;
            case 3:  // Abril
            case 5:  // Junio
            case 8:  // Septiembre
            case 10: // Noviembre
                return 30;
            case 1:  // Febrero
                if ( ((año%100 == 0) && (año%400 == 0)) ||
                        ((año%100 != 0) && (año%  4 == 0))   )
                    return 29;  // Año Bisiesto
                else
                    return 28;
            default:
                throw new java.lang.IllegalArgumentException("El mes debe estar entre 0 y 11");
        }
    }
    public int CuantosDomingos(int mes) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        //int mes = cal.get(Calendar.MONTH);
        int diaAContar = 7;
        int cuenta = 0;
        String strDia = "Domingos";
        switch (diaAContar) {
        case 2:
        strDia = "Lunes";
        break;
        case 3:
        strDia = "Martes";
        break;
        case 4:
        strDia = "Miércoles";
        break;
        case 5:
        strDia = "Miércoles";
        break;
        case 6:
        strDia = "Viernes";
        break;
        case 7:
        strDia = "Sábados";
        break;
    } // end switch

    while (cal.get(Calendar.MONTH) == mes){
        if (cal.get(Calendar.DAY_OF_WEEK) == diaAContar)
            cuenta++;
        // end if
        cal.add(Calendar.DAY_OF_MONTH, 1);
    } // end while
    //JOptionPane.showMessageDialog(null, "Este mes tiene " + cuenta + " " + strDia);
    return cuenta;
    } // end 
    public void eliminarTurno(int codigo) throws Exception {
        unTurno = cp.traerTurno(codigo);
        unTurno.setActivo(false);
        cp.editarTurno(unTurno);
    }
    public Turno traerTurno(int codigo) throws Exception{
        return cp.traerTurno(codigo);
    }
    public List<Turno> traerTurnosDelVehiculo(String dominio, int codigoAg) throws Exception{
        Vehiculo unVehiculo = cp.traerVehiculoDominio(dominio);
        
        return cp.traerTurnosDelVehiculo(unVehiculo, codigoAg);
    }
   
    //////////////////////////////METODOS DE SERVICIO//////////////////////////
    public List<Servicio> traerServicios(boolean activo){
       return cp.traerServicios(activo);
    }
    
 /////////////////// METODO MAIN ///////////////////////////
        public static void main(String[] args) {
            frmMenu miMenuPrincipal = new frmMenu();
            miMenuPrincipal.setVisible(true);
    }


    
    public int queDiaEs(Date d){
	GregorianCalendar cal = new GregorianCalendar();
	cal.setTime(d);
	return cal.get(Calendar.DAY_OF_WEEK);		
}
}
