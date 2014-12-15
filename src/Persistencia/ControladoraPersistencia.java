/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.Accesorio;
import Modelo.AgendaMensual;
import Modelo.Anomalia;
import Modelo.Cliente;
import Modelo.Deposito;
import Modelo.Detalle;
import Modelo.Devolucion;
import Modelo.Diagnostico;
import Modelo.Ejemplar;
import Modelo.Empleado;
import Modelo.Equipamiento;
import Modelo.Especialidad;
import Modelo.Estado;
import Modelo.EstadoVehiculo;
import Modelo.InformePiezaPedido;
import Modelo.JefeDeposito;
import Modelo.JefeTaller;
import Modelo.Localidad;
import Modelo.Marca;
import Modelo.Mecanico;
import Modelo.Modelo;
import Modelo.Modulo;
import Modelo.Pedido;
import Modelo.Perito;
import Modelo.PiezaRecambio;
import Modelo.Proceso;
import Modelo.Proveedor;
import Modelo.Segmento;
import Modelo.Servicio;
import Modelo.Taller;
import Modelo.TipoAnomalia;
import Modelo.TipoDiagnostico;
import Modelo.TipoReparacion;
import Modelo.Turno;
import Modelo.Vehiculo;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author cristian
 */
public class ControladoraPersistencia {
    private AccesorioJpaController accesorioJpa = new AccesorioJpaController();
    private MarcaJpaController marcaJpa = new MarcaJpaController();
    private TipoReparacionJpaController tipoReparacionJpa = new TipoReparacionJpaController();
    private AnomaliaJpaController anomaliaJpa = new AnomaliaJpaController();
    private TipoAnomaliaJpaController tipoAnomaliaJpa = new TipoAnomaliaJpaController();
    private EquipamientoJpaController equipamientoJpa = new EquipamientoJpaController();
    private SegmentoJpaController segmentoJpa = new SegmentoJpaController();
    private ModeloJpaController modeloJpa = new ModeloJpaController();
    private EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();
    private EspecialidadJpaController especialidadJpa = new EspecialidadJpaController();
    private EstadoJpaController estadoJpa = new EstadoJpaController();
    private VehiculoJpaController vehiculoJpa = new VehiculoJpaController();
    private ClienteJpaController clienteJpa = new ClienteJpaController();
    private PiezaRecambioJpaController piezaRecambioJpa = new PiezaRecambioJpaController();
    private ProveedorJpaController proveedorJpa = new ProveedorJpaController();
    private EjemplarJpaController ejemplarJpa = new EjemplarJpaController();
    private MecanicoJpaController mecanicoJpa = new MecanicoJpaController();
    private PedidoJpaController pedidoJpa = new PedidoJpaController();

    private JefeTallerJpaController jefeTallerJpa = new JefeTallerJpaController();
    private JefeDepositoJpaController jefeDepositoJpa = new JefeDepositoJpaController();
    private PeritoJpaController peritoJpa = new PeritoJpaController();
    private InformePiezaPedidoJpaController informeJpa = new InformePiezaPedidoJpaController();

    private LocalidadJpaController localidadJpa = new LocalidadJpaController();
    private DevolucionJpaController devolucionJpa = new DevolucionJpaController();
    private TallerJpaController tallerJpa = new TallerJpaController();
    private DepositoJpaController depositoJpa = new DepositoJpaController();

    private TipoDiagnosticoJpaController tipoDiagnosticoJpa = new TipoDiagnosticoJpaController();
    private ProcesoJpaController procesoJpa = new ProcesoJpaController();
    private DiagnosticoJpaController diagnosticoJpa = new DiagnosticoJpaController();
    private TurnoJpaController turnoJpa = new TurnoJpaController();
    private ServicioJpaController servicioJpa = new ServicioJpaController();
            

    private AgendaMensualJpaController agendaMensualJpa = new AgendaMensualJpaController();
    private ModuloJpaController moduloJpa = new ModuloJpaController();

    private EstadoVehiculoJpaController estadoVJpa = new EstadoVehiculoJpaController();

    private DetalleJpaController detalleJpa = new DetalleJpaController();



    
    ///////////////// METODOS DE ACCESORIO //////////////////////
    public void crearAccesorio(Accesorio accesorio) throws PreexistingEntityException, Exception{
        accesorioJpa.create(accesorio);
    }
    public void editarAccesorio(Accesorio unAccesorio) throws PreexistingEntityException, Exception{
        accesorioJpa.edit(unAccesorio);
    }
    public List<Accesorio> traerAccesorios(boolean activo) throws PreexistingEntityException, Exception{
        return accesorioJpa.traerAccesorios(activo);
    }
    public void eliminarAccesorio(int codigo) throws NonexistentEntityException, Exception{
            accesorioJpa.destroy(codigo);
    }
    public List<Accesorio> traerAccesoriosNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
        return accesorioJpa.traerAccesoriosNombre(activo, nombre);
    }   
    public Accesorio traerAccesorio(int codigo) throws PreexistingEntityException, Exception{
        return accesorioJpa.findAccesorio(codigo);
    }
    public List<Accesorio> traerAccesoriosSinVehiculo(Vehiculo vehiculo) throws PreexistingEntityException, Exception{
        return accesorioJpa.traerAccesoriosSinVehiculo(vehiculo);
    }
    public List<Accesorio> traerAccesoriosConVehiculo(Vehiculo vehiculo) throws PreexistingEntityException, Exception{
        return accesorioJpa.traerAccesoriosConVehiculo(vehiculo);
    }
    
    ///////////////// METODOS DE MARCA //////////////////////
    public void nuevaMarca(Marca marca) throws PreexistingEntityException, Exception{
        marcaJpa.create(marca);
    }
    public void editarMarca(Marca unaMarca) throws PreexistingEntityException, Exception{
        marcaJpa.edit(unaMarca);
    }
    public Marca traerMarca(int codigo) throws PreexistingEntityException, Exception{
        return marcaJpa.findMarca(codigo);
    }
    public List<Marca> traerMarcas(boolean activo) throws PreexistingEntityException, Exception{
        return marcaJpa.traerMarcas(activo);
    }
    public void eliminarMarca(int codigo) throws NonexistentEntityException, Exception{
        marcaJpa.destroy(codigo);
    }
    public List<Marca> traerMarcasNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
        return marcaJpa.traerMarcasNombre(activo, nombre);
    }
 
    ///////////////////////// TIPO REPARACION ////////////////////////////////
    public void nuevoTipoReparacion(TipoReparacion tipoReparacion) throws PreexistingEntityException, Exception{
        tipoReparacionJpa.create(tipoReparacion);
    }
    public void editarTipoReparacion(TipoReparacion unTipoReparacion) throws PreexistingEntityException, Exception{
        tipoReparacionJpa.edit(unTipoReparacion);
    }
    public TipoReparacion traerTR(int codigo) throws PreexistingEntityException, Exception{
        return tipoReparacionJpa.findTipoReparacion(codigo);
    }
    public List<TipoReparacion> traerTipoReparacion(boolean activo) throws PreexistingEntityException, Exception{
        return tipoReparacionJpa.traerTipoReparacion(activo);
    }
    public void eliminarTipoReparacion(int codigo) throws NonexistentEntityException, Exception{
        tipoReparacionJpa.destroy(codigo);
    }
    public List<TipoReparacion> traerTipoReparacionNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
        return tipoReparacionJpa.traerTipoReparacionNombre(activo, nombre);
    }
    
        ///////////////////////// ANOMALIA ////////////////////////////////
    public void nuevoAnomalia(Anomalia anomalia) throws PreexistingEntityException, Exception{
        anomaliaJpa.create(anomalia);
    }
    public void editarAnomalia(Anomalia unaAnomalia) throws PreexistingEntityException, Exception{
        anomaliaJpa.edit(unaAnomalia);
    }
    public Anomalia traerAnomalia(int codigo) throws PreexistingEntityException, Exception{
        return anomaliaJpa.findAnomalia(codigo);
    }
    public List<Anomalia> traerAnomalias(boolean activo) throws PreexistingEntityException, Exception{
        return anomaliaJpa.traerAnomalias(activo);
    }
    public void eliminarAnomalia(int codigo) throws NonexistentEntityException, Exception{
        anomaliaJpa.destroy(codigo);
    }
    public List<Anomalia> traerAnomaliasBusqueda(boolean activo, String nivel, TipoAnomalia tipo) throws PreexistingEntityException, Exception{
        return anomaliaJpa.traerAnomaliasBusqueda(activo, nivel, tipo);
    }
    public List<Anomalia> traerAnomaliasSinVinculoConDiagnostico(Diagnostico unDiagnostico){
        return anomaliaJpa.traerAnomaliasSinVinculoConDiagnostico(unDiagnostico);
    }
    
    public List<Anomalia> traerAnomaliasVinculadoDiagnostico(Diagnostico unDiagnostico){
        return anomaliaJpa.traerAnomaliasVinculadoDiagnostico(unDiagnostico);
    }
    
    ///////////////// METODOS DE TIPO DE ANOMALIA //////////////////////
    public void nuevoTipoAnomalia(TipoAnomalia tipoAnomalia) throws PreexistingEntityException, Exception{
        tipoAnomaliaJpa.create(tipoAnomalia);
    }
    public void editarTipoAnomalia(TipoAnomalia unTipoAnomalia) throws PreexistingEntityException, Exception{
        tipoAnomaliaJpa.edit(unTipoAnomalia);
    }
    public TipoAnomalia traerTA(int codigo) throws PreexistingEntityException, Exception{
        return tipoAnomaliaJpa.findTipoAnomalia(codigo);
    }
    public List<TipoAnomalia> traerTipoAnomalia(boolean activo) throws PreexistingEntityException, Exception{
        return tipoAnomaliaJpa.traerTipoAnomalia(activo);
    }
    public void eliminarTipoAnomalia(int codigo) throws NonexistentEntityException, Exception{
        tipoAnomaliaJpa.destroy(codigo);
    }
    public List<TipoAnomalia> traerTipoAnomaliaNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
        return tipoAnomaliaJpa.traerTipoAnomaliaNombre(activo, nombre);
    }
    
    ///////////////// METODOS DE EQUIPAMIENTO //////////////////////
    public void nuevoEquipamiento(Equipamiento equipamiento) throws PreexistingEntityException, Exception{
        equipamientoJpa.create(equipamiento);
    }
    public void editarEquipamiento(Equipamiento unEquipamiento) throws PreexistingEntityException, Exception{
        equipamientoJpa.edit(unEquipamiento);
    }
    public Equipamiento traerEquipamiento(int codigo) throws PreexistingEntityException, Exception{
        return equipamientoJpa.findEquipamiento(codigo);
    }
    public List<Equipamiento> traerEquipamientos(boolean activo) throws PreexistingEntityException, Exception{
        return equipamientoJpa.traerEquipamientos(activo);
    }
    public void eliminarEquipamiento(int codigo) throws NonexistentEntityException, Exception{
        equipamientoJpa.destroy(codigo);
    }
    public List<Equipamiento> traerEquipamientosNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
        return equipamientoJpa.traerEquipamientosNombre(activo, nombre);
    }
    public List<Equipamiento> traerEquipamientosSinVehiculo(Vehiculo vehiculo) throws PreexistingEntityException, Exception{
        return equipamientoJpa.traerEquipamientosSinVehiculo(vehiculo);
    }
    public List<Equipamiento> traerEquipamientosConVehiculo(Vehiculo vehiculo) throws PreexistingEntityException, Exception{
        return equipamientoJpa.traerEquipamientosConVehiculo(vehiculo);
    }
    
    ///////////////// METODOS DE SEGMENTO //////////////////////
    public void nuevoSegmento(Segmento segmento) throws PreexistingEntityException, Exception{
        segmentoJpa.create(segmento);
    }
    public void editarSegmento(Segmento unSegmento) throws PreexistingEntityException, Exception{
        segmentoJpa.edit(unSegmento);
    }
    public Segmento traerSegmento(int codigo) throws PreexistingEntityException, Exception{
        return segmentoJpa.findSegmento(codigo);
    }
    public List<Segmento> traerSegmentos(boolean activo) throws PreexistingEntityException, Exception{
        return segmentoJpa.traerSegmentos(activo);
    }
    public void eliminarSegmento(int codigo) throws NonexistentEntityException, Exception{
        segmentoJpa.destroy(codigo);
    }
    public List<Segmento> traerSegmentosNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
        return segmentoJpa.traerSegmentosNombre(activo, nombre);
    }
    
    ///////////////// METODOS DE MODELO //////////////////////
    public void nuevoModelo(Modelo modelo) throws PreexistingEntityException, Exception{
        modeloJpa.create(modelo);
    }
    public Modelo traerModelo(int codigo) throws PreexistingEntityException, Exception{
        return modeloJpa.findModelo(codigo);
    }
    
    public void editarModelo(Modelo modelo) throws PreexistingEntityException, Exception{
        modeloJpa.edit(modelo);
    }
    public List<Modelo> traerModelos(boolean activo) throws PreexistingEntityException, Exception{
        return modeloJpa.traerModelos(activo);
    }
    public void eliminarModelo(int codigo) throws NonexistentEntityException, Exception{
        modeloJpa.destroy(codigo);
    }
    public List<Modelo> traerModelosNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
        return modeloJpa.traerModelosNombre(activo, nombre);
    }
    public List<Modelo> traerModelosSinVinculo(PiezaRecambio pieza) throws PreexistingEntityException, Exception{
        return modeloJpa.traerModelosSinVinculo(pieza);
    }
    public List<Modelo> traerModelosConVinculo(PiezaRecambio pieza) throws PreexistingEntityException, Exception{
        return modeloJpa.traerModelosConVinculo(pieza);
    }
    
    ///////////////// METODOS DE EMPLEADO //////////////////////
    public void nuevoEmpleado(Empleado empleado) throws PreexistingEntityException, Exception{
        empleadoJpa.create(empleado);
    }
    public void editarEmpleado(Empleado empleado) throws PreexistingEntityException, Exception{
        empleadoJpa.edit(empleado);
    }
    public Empleado traerEmpleado(int codigo) throws PreexistingEntityException, Exception{
        return empleadoJpa.findEmpleado(codigo);
    }
    public List<Empleado> traerEmpleados(boolean activo) throws PreexistingEntityException, Exception{
        return empleadoJpa.traerEmpleados(activo);
    }
    public void eliminarEmpleado(int codigo) throws NonexistentEntityException, Exception{
        empleadoJpa.destroy(codigo);
    }
    public List<Empleado> traerEmpleadosBusqueda(boolean activo, String apellido, int dni) throws PreexistingEntityException, Exception{
        return empleadoJpa.traerEmpleadosBusqueda(activo, apellido, dni);
    }
    public boolean existeEmpleado(int dni) throws NonexistentEntityException, Exception{
        return empleadoJpa.existeEmpleado(dni);
    }
    public boolean existeEmpleado(int dni, int codigo) throws NonexistentEntityException, Exception{
        return empleadoJpa.existeEmpleado(dni, codigo);
    }
    
    ///////////////////////// METODOS ESPECIALIDAD ////////////////////////////////
    public void nuevaEspecialidad(Especialidad unaEspecialidad) throws PreexistingEntityException, Exception{
        especialidadJpa.create(unaEspecialidad);
    }

    public void editarEspecialidad(Especialidad unaEspecialidad) throws PreexistingEntityException, Exception{
        especialidadJpa.edit(unaEspecialidad);
    }
    public Especialidad traerEspecialidad(int codigo) throws PreexistingEntityException, Exception{
        return especialidadJpa.findEspecialidad(codigo);
    }
    public List<Especialidad> traerEspecialidades(boolean activo) throws PreexistingEntityException, Exception{
        return especialidadJpa.traerEspecialidades(activo);
    }
    
    public List<Especialidad> traerEspecialidadesNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
        return especialidadJpa.traerEspecialidadesNombre(activo, nombre);
    }
    
    public void eliminarEspecialidad(int codigo) throws NonexistentEntityException, Exception{
        especialidadJpa.destroy(codigo);
    }

    public List<Especialidad> traerEspecialidadesSinVinculo(Mecanico unMecanico) throws PreexistingEntityException, Exception{
        return especialidadJpa.traerEspecialidadesSinVinculo(unMecanico);
    }
    public List<Especialidad> traerEspecialidadesConVinculo(Mecanico unMecanico) throws PreexistingEntityException, Exception{
        return especialidadJpa.traerEspecialidadesConVinculo(unMecanico);
    }
    
        ///////////////////////// METODOS ESTADOS ////////////////////////////////
    public void nuevoEstado(Estado unEstado) throws PreexistingEntityException, Exception{
        estadoJpa.create(unEstado);
    }

    public void editarEstado(Estado unEstado) throws PreexistingEntityException, Exception{
        estadoJpa.edit(unEstado);
    }
    public Estado traerEstado(int codigo) throws PreexistingEntityException, Exception{
        return estadoJpa.findEstado(codigo);
    }
    public List<Estado> traerEstados(boolean activo) throws PreexistingEntityException, Exception{
        return estadoJpa.traerEstados(activo);
    }
    
    public List<Estado> traerEstadosNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
        return estadoJpa.traerEstadosNombre(activo, nombre);
    }
    public void eliminarEstado(int codigo) throws NonexistentEntityException, Exception{
        estadoJpa.destroy(codigo);
    }
    
    ///////////////////////// METODOS VEHICULO /////////////////////////////////
    public void crearVehiculo(Vehiculo unVehiculo) throws PreexistingEntityException, Exception{
        vehiculoJpa.create(unVehiculo);
    }
    public void editarVehiculo(Vehiculo unVehiculo) throws PreexistingEntityException, Exception{
        vehiculoJpa.edit(unVehiculo);
    }
    public List<Vehiculo> traerVehiculos(boolean activo) throws PreexistingEntityException, Exception{
        return vehiculoJpa.traerVehiculos(activo);
    }
    public void eliminarVehiculo(int codigo) throws NonexistentEntityException, Exception{
            vehiculoJpa.destroy(codigo);
    }
    public List<Vehiculo> traerVehiculoDominio(boolean activo, String dominio) throws PreexistingEntityException, Exception{
        return vehiculoJpa.traerVehiculoDominio(activo, dominio);
    }  
    public Vehiculo traerVehiculoDominio(String dominio) throws PreexistingEntityException, Exception{
        return vehiculoJpa.traerVehiculoDominio(dominio);
    }
    public Vehiculo traerVehiculo(int codigo) throws PreexistingEntityException, Exception{
        return vehiculoJpa.findVehiculo(codigo);
    }
    public List<Vehiculo> traerVehiculosSinCliente() throws PreexistingEntityException, Exception{
        return vehiculoJpa.traerVehiculosSinCliente();
    }
    public List<Vehiculo> traerVehiculosConCliente(Cliente cliente) throws PreexistingEntityException, Exception{
        return vehiculoJpa.traerVehiculosConCliente(cliente);
    }
    
    ///////////////////////// METODOS CLIENTE /////////////////////////////////
    public void nuevoCliente(Cliente unCliente) throws PreexistingEntityException, Exception{
        clienteJpa.create(unCliente);
    }
    public void editarCliente(Cliente cliente) throws PreexistingEntityException, Exception{
        clienteJpa.edit(cliente);
    }
    public Cliente traerCliente(int codigo) throws PreexistingEntityException, Exception{
        return clienteJpa.findCliente(codigo);
    }
    public List<Cliente> traerClientes(boolean activo) throws PreexistingEntityException, Exception{
        return clienteJpa.traerClientes(activo);
    }
    public void eliminarCliente(int codigo) throws NonexistentEntityException, Exception{
            clienteJpa.destroy(codigo);
    }
    public List<Cliente> traerClientesBusqueda(boolean activo, String apellido, int dni) throws PreexistingEntityException, Exception{
        return clienteJpa.traerClientesBusqueda(activo, apellido, dni);
    }   
    public void borrarClienteVehiculo(int codigoCliente, int codigoVehiculo) throws PreexistingEntityException, Exception{
        clienteJpa.borrarClienteVehiculo(codigoCliente, codigoVehiculo);
    }
    public boolean existeCliente(int dni) throws PreexistingEntityException, Exception{
        return clienteJpa.exiteCliente(dni);
    }
    public boolean existeCliente(int dni, int codigo) throws PreexistingEntityException, Exception{
        return clienteJpa.exiteCliente(dni, codigo);
    }

    
    ///////////////////////// METODOS DE PIEZA RECAMBIO ///////////////////////////////
    public void nuevaPiezaRecambio(PiezaRecambio piezaRecambio) throws PreexistingEntityException, Exception{
        piezaRecambioJpa.create(piezaRecambio);
    }
    public void editarPiezaRecambio(PiezaRecambio piezaRecambio) throws PreexistingEntityException, Exception{
        piezaRecambioJpa.edit(piezaRecambio);
    }
    public PiezaRecambio traerPiezaRecambio(int codigo) throws PreexistingEntityException, Exception{
        return piezaRecambioJpa.findPiezaRecambio(codigo);
    }
    public List<PiezaRecambio> traerPiezaRecambios(boolean activo) throws PreexistingEntityException, Exception{
        return piezaRecambioJpa.traerPiezaRecambios(activo);
    }
    public void eliminarPiezaRecambio(int codigo) throws NonexistentEntityException, Exception{
        marcaJpa.destroy(codigo);
    }
    public List<PiezaRecambio> traerPiezaRecambiosBusqueda(boolean activo, String nombre, TipoReparacion tipo) throws PreexistingEntityException, Exception{
        return piezaRecambioJpa.traerPiezaRecambiosBusqueda(activo, nombre, tipo);
    }
    public List<PiezaRecambio> traerPiezasSinVinculoConProceso(Proceso unProceso) {
        return piezaRecambioJpa.traerPiezasSinVinculoConProceso(unProceso);
    }
    public List<PiezaRecambio> traerPiezasConVinculoConProceso(Proceso unProceso) {
        return piezaRecambioJpa.traerPiezasConVinculoSinProceso(unProceso);
    }

        ///////////////// METODOS DE PROVEEDOR //////////////////////
    public void nuevoProveedor(Proveedor unProveedor) throws PreexistingEntityException, Exception{
        proveedorJpa.create(unProveedor);
    }
    public void editarProveedor(Proveedor unProveedor) throws PreexistingEntityException, Exception{
        proveedorJpa.edit(unProveedor);
    }
    public List<Proveedor> traerProveedores(boolean activo) throws PreexistingEntityException, Exception{
        return proveedorJpa.traerProveedores(activo);
    }
    public void eliminarProveedor(int codigo) throws NonexistentEntityException, Exception{
            proveedorJpa.destroy(codigo);
    }
    public List<Proveedor> traerProveedorNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
        return proveedorJpa.traerProveedorNombre(activo, nombre);
    }   
    public Proveedor traerProveedor(int codigo) throws PreexistingEntityException, Exception{
        return proveedorJpa.findProveedor(codigo);
    }
    
    ///////////////// METODOS DE EJEMPLAR //////////////////////
    public void nuevoEjemplar(Ejemplar unEjemplar) throws PreexistingEntityException, Exception{
        ejemplarJpa.create(unEjemplar);
    }
    public void editarEjemplar(Ejemplar unEjemplar) throws PreexistingEntityException, Exception{
        ejemplarJpa.edit(unEjemplar);
    }
    public List<Ejemplar> traerEjemplares(boolean activo) throws PreexistingEntityException, Exception{
        return ejemplarJpa.traerEjemplares(activo);
    }
    public void eliminarEjemplar(int codigo) throws NonexistentEntityException, Exception{
            ejemplarJpa.destroy(codigo);
    }
    public List<Ejemplar> traerEjemplarCodigo(boolean activo, int codigo) throws PreexistingEntityException, Exception{
        return ejemplarJpa.traerEjemplarCodigo(activo, codigo);
    }   
    public Ejemplar traerEjemplar(int codigo) throws PreexistingEntityException, Exception{
        return ejemplarJpa.findEjemplar(codigo);
    }

    public List<Ejemplar> traerEjemplaresSinDeposito(boolean activo){
        return ejemplarJpa.traerEjemplaresSinDeposito(activo);
    }
    public List<Ejemplar> traerEjemplaresConDeposito(int deposito, boolean activo){
        return ejemplarJpa.traerEjemplaresConDeposito(deposito, activo);
    }
    public List<Ejemplar> traerEjemplaresConDeposito(int deposito, boolean activo, PiezaRecambio pieza){
        return ejemplarJpa.traerEjemplaresConDeposito(deposito, activo, pieza);
    }
    public int ultimaEjemplar(){
        return ejemplarJpa.ultimoEjemplar();
    }
    public List<Ejemplar> traerEjemplaresSinDetalle(boolean activo){
        return ejemplarJpa.traerEjemplaresSinDetalle(activo);
    }
    
    public List<Ejemplar> traerEjemplaresConDetalle(boolean activo, int detalle){
        return ejemplarJpa.traerEjemplaresConDetalle(detalle, activo);
    }

    
    ////////////////////// METODOS DE MECANICO //////////////////////
    public void nuevoMecanico(Mecanico unMecanico)throws PreexistingEntityException, Exception{
        mecanicoJpa.create(unMecanico);
    }
    public void editarMecanico(Mecanico unMecanico) throws PreexistingEntityException, Exception{
        mecanicoJpa.edit(unMecanico);
    }
    public Mecanico traerMecanico(int codigo) throws PreexistingEntityException, Exception{
        return mecanicoJpa.findMecanico(codigo);
    }
    public List<Mecanico> traerMecanicos(boolean activo) throws PreexistingEntityException, Exception{
        return mecanicoJpa.traerMecanicos(activo);
    }
    public void eliminarMecanico(int codigo) throws NonexistentEntityException, Exception{
        mecanicoJpa.destroy(codigo);
    }
    public List<Mecanico> traerMecanicosBusqueda(boolean activo, String apellido, int dni) throws PreexistingEntityException, Exception{
        return mecanicoJpa.traerMecanicosBusqueda(activo, apellido, dni);
    }
    public boolean existeMecanico(int dni) throws NonexistentEntityException, Exception{
        return mecanicoJpa.existeMecanico(dni);
    }
    public boolean existeMecanico(int dni, int codigo) throws NonexistentEntityException, Exception{
        return mecanicoJpa.existeMecanico(dni, codigo);
    }
    public List<Mecanico> traerMecanicoSinTaller(){
        return mecanicoJpa.traerMecanicoSinTaller();
    }
    public List<Mecanico> traerMecanicoConCliente(int codigoTaller){
        return mecanicoJpa.traerMecanicoConCliente(codigoTaller);
    }
    
        ///////////////////////// METODOS PEDIDOS ////////////////////////////////
    public void nuevoPedido(Pedido unPedido) throws PreexistingEntityException, Exception{
        pedidoJpa.create(unPedido);
    }

    public void editarPedido(Pedido unPedido) throws PreexistingEntityException, Exception{
        pedidoJpa.edit(unPedido);
    }
    public Pedido traerPedido(int codigo) throws PreexistingEntityException, Exception{
        return pedidoJpa.findPedido(codigo);
    }
    public List<Pedido> traerPedidos(boolean activo) throws PreexistingEntityException, Exception{
        return pedidoJpa.traerPedidos(activo);
    }
    
    public List<Pedido> traerPedidosCodigo(boolean activo, int codigo) throws PreexistingEntityException, Exception{
        return pedidoJpa.traerPedidosCodigo(activo, codigo);
    }
    
    public void eliminarPedido(int codigo) throws NonexistentEntityException, Exception{
        pedidoJpa.destroy(codigo);
    }

    public List<Pedido> traerPedidosSinVinculo(Mecanico unMecanico) throws PreexistingEntityException, Exception{
        return pedidoJpa.traerPedidosSinVinculo(unMecanico);
    }
    public List<Pedido> traerPedidosConVinculo(Mecanico unMecanico) throws PreexistingEntityException, Exception{
        return pedidoJpa.traerPedidosConVinculo(unMecanico);
    }
    public List<Pedido> traerPedidosDeVehiculo(String dominio){
        return pedidoJpa.traerPedidosDeVehiculo(dominio);
    }
    

    ///////////////// METODOS DE JEFE DE TALLER //////////////////////
    public void nuevoJefeTaller(JefeTaller unJefe) throws PreexistingEntityException, Exception{
        jefeTallerJpa.create(unJefe);
    }
    public void editarJefeTaller(JefeTaller unJefe) throws PreexistingEntityException, Exception{
        jefeTallerJpa.edit(unJefe);
    }
    public JefeTaller traerJefeTaller(int codigo) throws PreexistingEntityException, Exception{
        return jefeTallerJpa.findJefeTaller(codigo);
    }
    public List<JefeTaller> traerJefesTaller(boolean activo) throws PreexistingEntityException, Exception{
        return jefeTallerJpa.traerJefesTaller(activo);
    }
    public void eliminarJefeTaller(int codigo) throws NonexistentEntityException, Exception{
        jefeTallerJpa.destroy(codigo);
    }
    public List<JefeTaller> traerJefesTallerBusqueda(boolean activo, String apellido, int dni) throws PreexistingEntityException, Exception{
        return jefeTallerJpa.traerJefesTallerBusqueda(activo, apellido, dni);
    }
    public boolean existeJefeTaller(int dni) throws NonexistentEntityException, Exception{
        return jefeTallerJpa.existeJefeTaller(dni);
    }
    public boolean existeJefeTaller(int dni, int codigo) throws NonexistentEntityException, Exception{
        return jefeTallerJpa.existeJefeTaller(dni, codigo);
    }
    
    ///////////////// METODOS DE JEFE DE DEPOSITO //////////////////////
    public void nuevoJefeDeposito(JefeDeposito unJefe) throws PreexistingEntityException, Exception{
        jefeDepositoJpa.create(unJefe);
    }
    public void editarJefeDeposito(JefeDeposito unJefe) throws PreexistingEntityException, Exception{
        jefeDepositoJpa.edit(unJefe);
    }
    public JefeDeposito traerJefeDeposito(int codigo) throws PreexistingEntityException, Exception{
        return jefeDepositoJpa.findJefeDeposito(codigo);
    }
    public List<JefeDeposito> traerJefeDeposito(boolean activo) throws PreexistingEntityException, Exception{
        return jefeDepositoJpa.traerJefesDeposito(activo);
    }
    public void eliminarJefeDeposito(int codigo) throws NonexistentEntityException, Exception{
        jefeDepositoJpa.destroy(codigo);
    }
    public List<JefeDeposito> traerJefesDepositoBusqueda(boolean activo, String apellido, int dni) throws PreexistingEntityException, Exception{
        return jefeDepositoJpa.traerJefesDepositoBusqueda(activo, apellido, dni);
    }
    public JefeDeposito existeJefeDeposito(int dni) throws NonexistentEntityException, Exception{
        return jefeDepositoJpa.existeJefeDeposito(dni);
    }
    public boolean existeJefeDeposito(int dni, int codigo) throws NonexistentEntityException, Exception{
        return jefeDepositoJpa.existeJefeDeposito(dni, codigo);
    }
    
    ///////////////// METODOS DE PERITO//////////////////////
    public void nuevoPerito(Perito unPerito)throws PreexistingEntityException, Exception{
        peritoJpa.create(unPerito);
    }
    public void editarPerito(Perito unPerito) throws PreexistingEntityException, Exception{
        peritoJpa.edit(unPerito);
    }
    public Perito traerPerito(int codigo) throws PreexistingEntityException, Exception{
        return peritoJpa.findPerito(codigo);
    }
    public List<Perito> traerPeritos(boolean activo) throws PreexistingEntityException, Exception{
        return peritoJpa.traerPeritos(activo);
    }
    public void eliminarPerito(int codigo) throws NonexistentEntityException, Exception{
        peritoJpa.destroy(codigo);
    }
    public List<Perito> traerPeritosBusqueda(boolean activo, String apellido, int dni) throws PreexistingEntityException, Exception{
        return peritoJpa.traerPeritosBusqueda(activo, apellido, dni);
    }
    public boolean existePerito(int dni) throws NonexistentEntityException, Exception{
        return peritoJpa.existePerito(dni);
    }
    public boolean existePerito(int dni, int codigo) throws NonexistentEntityException, Exception{
        return peritoJpa.existePerito(dni, codigo);
    }

    ///////////////// METODOS DE INFORME PIEZA PEDIDO //////////////////////
    public void nuevoInforme(InformePiezaPedido unInforme) throws PreexistingEntityException, Exception{
        informeJpa.create(unInforme);
    }
    public void editarInforme(InformePiezaPedido unInforme) throws PreexistingEntityException, Exception{
        informeJpa.edit(unInforme);
    }
    public void eliminarInforme(int codigo) throws NonexistentEntityException, Exception{
        informeJpa.destroy(codigo);
    }
    public InformePiezaPedido traerInforme(int codigo) throws PreexistingEntityException, Exception{
        return informeJpa.findInformePiezaPedido(codigo);
    }

    public List<InformePiezaPedido> traerInformeSinVinculo(Perito unPerito) {
        return informeJpa.traerInformeSinVinculo(unPerito);
    }

    public List<InformePiezaPedido> traerInformesConVinculo(Perito unPerito) {
        return informeJpa.traerInformesConVinculo(unPerito);
    }
    public int recuperarUltimoInforme(){
        return informeJpa.ultimoInformePiezaPedido();
        
    }
    public List<InformePiezaPedido> traerInformes(boolean activo){
        return informeJpa.traerInformes(activo);
    }

        ///////////////////// METODOS DE LOCALIDAD ////////////////////////////

    public List<Localidad> traerLocalidades(boolean activo) throws PreexistingEntityException, Exception{
        return localidadJpa.traerLocalidades(activo);
    }

    public List<Localidad> traerLocalidadesNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
        return localidadJpa.traerLocalidades(activo, nombre);
    }
    public List<Localidad> traerLocalidadesSinTaller(int taller) throws PreexistingEntityException, Exception{
        return localidadJpa.traerLocalidadesSinTaller(taller);
    }
    public List<Localidad> traerLocalidadesConTaller(int taller) throws PreexistingEntityException, Exception{
        return localidadJpa.traerLocalidadesConTaller(taller);
    }
    
    
    ///////////////////////// METODOS DE DEVOLUCION ////////////////////////////////
    public void nuevaDevolucion(Devolucion devolucion) throws PreexistingEntityException, Exception{
        devolucionJpa.create(devolucion);
    }
    public void editarDevolucion(Devolucion devolucion) throws PreexistingEntityException, Exception{
        devolucionJpa.edit(devolucion);
    }
    public Devolucion traerDevolucion(int codigo) throws PreexistingEntityException, Exception{
        return devolucionJpa.findDevolucion(codigo);
    }
    public List<Devolucion> traerDevoluciones(boolean activo) throws PreexistingEntityException, Exception{
        return devolucionJpa.traerDevoluciones(activo);
    }
    public void eliminarDevolucion(int codigo) throws NonexistentEntityException, Exception{
        devolucionJpa.destroy(codigo);
    }
    public List<Devolucion> traerDevolucionesBusqueda(boolean activo, java.util.Date fecha) throws PreexistingEntityException, Exception{
        return devolucionJpa.traerDevoluciones(activo, fecha);
    }
    public List<Devolucion> traerDevolucionesSinDeposito() throws PreexistingEntityException, Exception{
        return devolucionJpa.traerDevolucionesSinDeposito();
    }
    public List<Devolucion> traerDevolucionesConDeposito(int deposito) throws PreexistingEntityException, Exception{
        return devolucionJpa.traerDevolucionesConDeposito(deposito);
    }
    public List<Devolucion> traerDevolucionesConDeposito(int deposito, String fecha) throws PreexistingEntityException, Exception{
        return devolucionJpa.traerDevolucionesConDeposito(deposito, fecha);
    }
    public int ultimaDevolcion() throws PreexistingEntityException, Exception{
        return devolucionJpa.ultimaDevolucion();
    }
    
        /////////////////////// METODOS DE TALLER ////////////////////////////////
    public void nuevoTaller(Taller taller) throws PreexistingEntityException, Exception{
        tallerJpa.create(taller);
    }
    public void editarTaller(Taller taller) throws PreexistingEntityException, Exception{
        tallerJpa.edit(taller);
    }
    public List<Taller> traerTalleres(boolean activo) throws PreexistingEntityException, Exception{
        return tallerJpa.traerTalleres(activo);
    }
    public void eliminarTaller(int codigo) throws NonexistentEntityException, Exception{
            Taller taller = traerTaller(codigo);
            taller.setActivo(false);
            tallerJpa.edit(taller);
    }
    public List<Taller> traerTallerNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
        return tallerJpa.traerTalleresNombre(activo, nombre);
    }   
    public Taller traerTaller(int codigo) throws PreexistingEntityException, Exception{
        return tallerJpa.findTaller(codigo);
    }
    
    /////////////////////// METODOS DE DEPOSITO ////////////////////////////////
    public void nuevoDeposito(Deposito deposito) throws PreexistingEntityException, Exception{
        depositoJpa.create(deposito);
    }
    public void editarDeposito(Deposito deposito) throws PreexistingEntityException, Exception{
        depositoJpa.edit(deposito);
    }
    public void eliminarDeposito(int codigo) throws NonexistentEntityException, Exception{
        Deposito deposito = traerDeposito(codigo);
        deposito.setActivo(false);
        depositoJpa.edit(deposito);
    }
    public Deposito traerDeposito(int codigo) throws NonexistentEntityException, Exception{
        return depositoJpa.findDeposito(codigo);
    }
    public int ultimoDeposito() throws NonexistentEntityException, Exception{
        return depositoJpa.ultimoDeposito();
    }
    
    /////////////////////// METODOS DE DEPOSITO ////////////////////////////////
    public void nuevaAgendaMensual(AgendaMensual agendaMensual) throws PreexistingEntityException, Exception{
        agendaMensualJpa.create(agendaMensual);
    }
    public void editarAgendaMensual(AgendaMensual agendaMensual) throws PreexistingEntityException, Exception{
        agendaMensualJpa.edit(agendaMensual);
    }
    public void eliminarAgendaMensual(int codigo) throws NonexistentEntityException, Exception{
        agendaMensualJpa.destroy(codigo);
    }
    public AgendaMensual traerAgendaMensual(int codigo) throws NonexistentEntityException, Exception{
        return agendaMensualJpa.findAgendaMensual(codigo);
    }
    public int ultimoAgendaMensual() throws NonexistentEntityException, Exception{
        return agendaMensualJpa.ultimoAgendaMensual();
    }
    
    public List<AgendaMensual> traerAgendaMensual(boolean activo) throws NonexistentEntityException, Exception{
        return agendaMensualJpa.traerAgendaMensual(activo);
    }
    
    public List<AgendaMensual> traerAgendaMensualAnio(boolean activo, int anio) throws NonexistentEntityException, Exception{
        return agendaMensualJpa.traerAgendaMensualAnio(activo, anio);
    }
    public List<AgendaMensual> traerAgendaMensualSinTaller(){
        return agendaMensualJpa.traerAgendaMensualSinTaller();
    }
    
    public List<AgendaMensual> traerAgendaMensualConTaller(int codigoTaller) throws NonexistentEntityException, Exception{
        return agendaMensualJpa.traerAgendaMensualConTaller(codigoTaller);
    }
    
    //////////////////////////////////// METODOS DE MODULO ///////////////////////////////////////////
    public void nuevoModulo(Modulo modulo) throws NonexistentEntityException, Exception{
        moduloJpa.create(modulo);
    }
    public void editarModulo(Modulo modulo) throws NonexistentEntityException, Exception{
        moduloJpa.edit(modulo);
    }
    public int ultimoModulo() throws NonexistentEntityException, Exception{
        return moduloJpa.ultimoModulo();
    }
    
    public Modulo traerModulo(int codigo) throws NonexistentEntityException, Exception{
        return moduloJpa.findModulo(codigo);
    }
    public List<Modulo> traerModulosLibres(boolean activo, int codigoAg, int cantidadModulos){
        return moduloJpa.traerModulosLibres(activo, codigoAg, cantidadModulos);
    }
    public List<Modulo> traerModulosTuno(boolean activo, int codigoTurno){
        return moduloJpa.traerModulosTuno(activo, codigoTurno);
    }

    ///////////////////////// TIPO DIAGNOSTICO ////////////////////////////////
    public void nuevoTipoDiagnostico(TipoDiagnostico unTipoDiagnostico) throws PreexistingEntityException, Exception{
        tipoDiagnosticoJpa.create(unTipoDiagnostico);
    }
    public void editarTipoDiagnostico(TipoDiagnostico unTipoDiagnostico) throws PreexistingEntityException, Exception{
        tipoDiagnosticoJpa.edit(unTipoDiagnostico);
    }
    public TipoDiagnostico traerTD(int codigo) throws PreexistingEntityException, Exception{
        return tipoDiagnosticoJpa.findTipoDiagnostico(codigo);
    }
    public List<TipoDiagnostico> traerTipoDiagnostico(boolean activo) throws PreexistingEntityException, Exception{
        return tipoDiagnosticoJpa.traerTipoDiagnostico(activo);
    }
    public void eliminarTipoDiagnostico(int codigo) throws NonexistentEntityException, Exception{
        tipoDiagnosticoJpa.destroy(codigo);
    }
    public List<TipoDiagnostico> traerTipoDiagnosticoNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
        return tipoDiagnosticoJpa.traerTipoDiagnosticoNombre(activo, nombre);
    }
    
    //////////////////////// METODOS DE PROCESO /////////////////////////////
    public void nuevoProceso(Proceso unProceso) throws PreexistingEntityException, Exception{
        procesoJpa.create(unProceso);
    }
    public void editarProceso(Proceso unProceso) throws PreexistingEntityException, Exception{
        procesoJpa.edit(unProceso);
    }
    public Proceso traerProceso(int codigo) throws PreexistingEntityException, Exception{
        return procesoJpa.findProceso(codigo);
    }
    public List<Proceso> traerProcesos(boolean activo) throws PreexistingEntityException, Exception{
        return procesoJpa.traerProcesos(activo);
    }
    public void eliminarProceso(int codigo) throws NonexistentEntityException, Exception{
        procesoJpa.destroy(codigo);
    }
    public List<Proceso> traerProcesosNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
        return procesoJpa.traerProcesoNombre(activo, nombre);
    }
    public List<Proceso> traerProcesosConTipoDiagnostico(int diagnostico){
        return procesoJpa.traerProcesosConTipoDiagnostico(diagnostico);
    }
    public int recuperarUltimoProceso(){
        return procesoJpa.recuperarUltimoProceso();
    }
    
    /////////////////////////  DIAGNOSTICO ////////////////////////////////
    public void nuevoDiagnostico(Diagnostico unDiagnostico) throws PreexistingEntityException, Exception{
        diagnosticoJpa.create(unDiagnostico);
    }
    public void editarDiagnostico(Diagnostico unDiagnostico) throws PreexistingEntityException, Exception{
        diagnosticoJpa.edit(unDiagnostico);
    }
    public Diagnostico traerDiagnostico(int codigo) throws PreexistingEntityException, Exception{
        return diagnosticoJpa.findDiagnostico(codigo);
    }
    public List<Diagnostico> traerDiagnostico(boolean activo) throws PreexistingEntityException, Exception{
        return diagnosticoJpa.traerDiagnostico(activo);
    }
    public void eliminarDiagnostico(int codigo) throws NonexistentEntityException, Exception{
        diagnosticoJpa.destroy(codigo);
    }
    public List<Diagnostico> traerDiagnosticoNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
        return diagnosticoJpa.traerDiagnosticoNombre(activo, nombre);
    }
    
   ///////////////// METODOS DE TURNO //////////////////////
    public void nuevoTurno(Turno unTurno) throws PreexistingEntityException, Exception{
        turnoJpa.create(unTurno);
    }
    public void editarTurno(Turno unTurno) throws PreexistingEntityException, Exception{
        turnoJpa.edit(unTurno);
    }
    public List<Turno> traerTurnos(boolean activo, int codigoAg) throws PreexistingEntityException, Exception{
        return turnoJpa.traerTurnos(activo, codigoAg);
    }
    public void eliminarTurno(int codigo) throws NonexistentEntityException, Exception{
            turnoJpa.destroy(codigo);
    }
//    public List<Turno> traerTurnosNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
//        return turnoJpa.traerTurnosNombre(activo, nombre);
//    }   
    public Turno traerTurno(int codigo) throws PreexistingEntityException, Exception{
        return turnoJpa.findTurno(codigo);
    }
    public List<Turno> traerTurnosDelVehiculo(Vehiculo vehiculo, int codigoAgenda) throws PreexistingEntityException, Exception{
        return turnoJpa.traerTurnosDelVehiculo(vehiculo, codigoAgenda);
    } 
    public int ultimoTurno() throws PreexistingEntityException, Exception{
        return turnoJpa.ultimaTuno();
    }
    
     ///////////////// METODOS DE ACCESORIO //////////////////////
    public void nuevoEstadoVehiculo(EstadoVehiculo unEstadoV) throws PreexistingEntityException, Exception{
        estadoVJpa.create(unEstadoV);
    }
    public void editarEstadoVehiculo(EstadoVehiculo unEstadoV) throws PreexistingEntityException, Exception{
        estadoVJpa.edit(unEstadoV);
    }
    public void eliminarEstadoVehiculo(int codigo) throws NonexistentEntityException, Exception{
            estadoVJpa.destroy(codigo);
    }
    public List<EstadoVehiculo> traerEstDelVehiculo(Vehiculo unVehiculo) throws PreexistingEntityException, Exception{
        return estadoVJpa.traerEstDelVehiculo(unVehiculo);
    }   
    public EstadoVehiculo traerUltimoEstVehiculo(Vehiculo unVehiculo){
        int codigoUltimo = estadoVJpa.traerUltimoEstVehiculo(unVehiculo);
        return estadoVJpa.traerEstDelVehiculo(codigoUltimo);
    }
    
    //////////////////////////////METODOS DE SERVICIO//////////////////////////
    public List<Servicio> traerServicios(boolean activo){
       return servicioJpa.traerServicios(activo);
    }
    
        /////////////////////////  DETALLE ////////////////////////////////
    public void nuevoDetalle(Detalle detalle) throws PreexistingEntityException, Exception{
        detalleJpa.create(detalle);
    }
    public void editarDetalle(Detalle detalle) throws PreexistingEntityException, Exception{
        detalleJpa.edit(detalle);
    }
    public Detalle traerDetalle(int codigo) throws PreexistingEntityException, Exception{
        return detalleJpa.findDetalle(codigo);
    }
    public List<Detalle> traerDetallesTurno(boolean activo, int codigoTurno) throws PreexistingEntityException, Exception{
        return detalleJpa.traerDetallesTurno(activo, codigoTurno);
    }
    
    public int ultimoDetalle(){
        return detalleJpa.ultimoDetalle();
    }

}
