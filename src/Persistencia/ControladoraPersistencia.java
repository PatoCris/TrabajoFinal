/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.Accesorio;
import Modelo.Anomalia;
import Modelo.Cliente;
import Modelo.Ejemplar;
import Modelo.Empleado;
import Modelo.Equipamiento;
import Modelo.Especialidad;
import Modelo.Estado;
import Modelo.Marca;
import Modelo.Mecanico;
import Modelo.Modelo;
import Modelo.Pedido;
import Modelo.PiezaRecambio;
import Modelo.Proveedor;
import Modelo.Segmento;
import Modelo.TipoAnomalia;
import Modelo.TipoReparacion;
import Modelo.Vehiculo;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
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
        return empleadoJpa.exiteEmpleado(dni);
    }
    public boolean existeEmpleado(int dni, int codigo) throws NonexistentEntityException, Exception{
        return empleadoJpa.exiteEmpleado(dni, codigo);
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
    public Vehiculo traerVehiculo(int codigo) throws PreexistingEntityException, Exception{
        return vehiculoJpa.findVehiculo(codigo);
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

    
    ///////////////// METODOS DE MECANICO//////////////////////
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
        return mecanicoJpa.exiteMecanico(dni);
    }
    public boolean existeMecanico(int dni, int codigo) throws NonexistentEntityException, Exception{
        return mecanicoJpa.exiteMecanico(dni, codigo);
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
    
}
