/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Persistencia.ControladoraPersistencia;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
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
    private Cliente unCliente = new Cliente();
    private PiezaRecambio unaPiezaRecambio = new PiezaRecambio();
    private Proveedor unProveedor = new Proveedor();
    private Ejemplar unEjemplar = new Ejemplar();
    private Mecanico unMecanico = new Mecanico();
    private Pedido unPedido = new Pedido();
 
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
        unCliente = new Cliente(dni, nombre, apellido, direccion, telefono, usuario, clave, cuil, activo, localidad);
        cp.nuevoCliente(unCliente);
    }
    public void editarCliente(int codigo, int dni, String nombre, String apellido, String direccion, String telefono, String usuario, String clave, long cuil, boolean activo, Localidad localidad) throws Exception{
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
            }
        }
        System.out.println(vehiculo.getCodigo());
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
    public void nuevoEjemplar(java.util.Date fechaIng, PiezaRecambio unaPRecambio, Proveedor unProveedor) throws Exception{
        unEjemplar = new Ejemplar(fechaIng, unaPRecambio, unProveedor, true);
        cp.nuevoEjemplar(unEjemplar);
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
    public void eliminarEjemplar(int codigo) throws Exception{
        unEjemplar = cp.traerEjemplar(codigo);
        unEjemplar.setActivo(false);
        cp.editarEjemplar(unEjemplar);
    }
    public List<Ejemplar> traerEjemplarCodigo(boolean activo, int codigo) throws Exception{
        return cp.traerEjemplarCodigo(activo, codigo);
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
        Mecanico unMecanico = cp.traerMecanico(codigo);
        unMecanico.getMisEspecialidades().add(unaEspecialidad);
        cp.editarMecanico(unMecanico);
    }
    public void quitarEspecialidad(int especialidad, int codigo) throws Exception{
        Mecanico unMecanico = cp.traerMecanico(codigo);
        unMecanico.getMisEspecialidades().remove(especialidad);
        cp.editarMecanico(unMecanico);
    }
    
    public void agregarPedido(Pedido unPedido, int codigo) throws Exception{
        Mecanico unMecanico = cp.traerMecanico(codigo);
        unMecanico.getMisPedidos().add(unPedido);
        cp.editarMecanico(unMecanico);
    }
    public void quitarPedido(int pedido, int codigo) throws Exception{
        Mecanico unMecanico = cp.traerMecanico(codigo);
        unMecanico.getMisPedidos().remove(pedido);
        cp.editarMecanico(unMecanico);
    }
    
    ///////////////// METODOS DE PEDIDO ///////////////////
    public void nuevoPedido(Date fecha, Date hora, String descripcion, int cantidad, boolean autorizado, boolean paraRecambio, boolean activo, Perito unPerito, JefeDeposito unJefeDeposito, JefeTaller unJefeTaller, Cliente unCliente) throws Exception{
        unPedido = new Pedido(fecha, hora, descripcion, cantidad, autorizado, paraRecambio,true, unPerito, unJefeDeposito, unJefeTaller, unCliente);
        cp.nuevoPedido(unPedido);
    }
    public void editarPedido(int codigo, Date fecha, Date hora, String descripcion, int cantidad, boolean autorizado, boolean paraRecambio, boolean activo, Perito unPerito, JefeDeposito unJefeDeposito, JefeTaller unJefeTaller, Cliente unCliente) throws Exception{
        unPedido = cp.traerPedido(codigo);
        unPedido.setFecha(fecha);
        unPedido.setHora(hora);
        unPedido.setDescripcion(descripcion);
        unPedido.setCantidad(cantidad);
        unPedido.setParaRecambio(paraRecambio);
        unPedido.setActivo(activo);
        unPedido.setUnPerito(unPerito);
        unPedido.setUnJefeDeposito(unJefeDeposito);
        unPedido.setUnJefeTaller(unJefeTaller);
        unPedido.setUnCliente(unCliente);
        //faltan todos los set
        cp.editarPedido(unPedido);
    }
    public List<Pedido> traerPedidos(boolean activo) throws Exception{
        return cp.traerPedidos(activo);
    }
    public List<Pedido> traerPedidosCodigo(boolean activo, int codigo)throws Exception{
        return cp.traerPedidosCodigo(activo, codigo);
    }
    public void eliminarPedido(int codigo) throws Exception{
        unPedido = cp.traerPedido(codigo);
        unPedido.setActivo(false);
        cp.editarPedido(unPedido);
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
    
    ///////////////////////// METODOS DE DEVOLUCION ////////////////////////////////
    public void nuevaDevolucion(Date fecha, String motivo, boolean activo, PiezaRecambio miPiezaRecambio) throws PreexistingEntityException, Exception{
        Devolucion devolucion = new Devolucion(fecha, motivo, activo, miPiezaRecambio);
        cp.nuevaDevolucion(devolucion);
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
    public void eliminarDevolucion(int codigo) throws NonexistentEntityException, Exception{
        cp.eliminarDevolucion(codigo);
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
    public List<Devolucion> traerDevolucionesConDeposito(int deposito, Date fecha) throws PreexistingEntityException, Exception{
        return cp.traerDevolucionesConDeposito(deposito, fecha);
    }
   
            /////////////////////// METODOS DE TALLER ////////////////////////////////
        public void nuevoTaller(String nombre, String direccion, String telefono, String correo, Date horaEntrada, Date horaSalida, boolean activo, Deposito unDeposito, JefeTaller unJefeTaller, Localidad unaLocalidad) throws PreexistingEntityException, Exception{
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
            cp.eliminarTaller(codigo);
    }
    public List<Taller> traerTallerNombre(boolean activo, String nombre) throws PreexistingEntityException, Exception{
        return cp.traerTallerNombre(activo, nombre);
    }   
    public Taller traerTaller(int codigo) throws PreexistingEntityException, Exception{
        return cp.traerTaller(codigo);
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
        cp.eliminarDeposito(codigo);
    }
    
    /////////////////// METODO MAIN ///////////////////////////
        public static void main(String[] args) {
            frmMenu miMenuPrincipal = new frmMenu();
            miMenuPrincipal.setVisible(true);
    }

}
