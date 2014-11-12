package Modelo;

import Modelo.InformePiezaPedido;
import Modelo.PiezaRecambio;
import Modelo.Proveedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:29")
@StaticMetamodel(SolicitudPiezaRecambio.class)
public class SolicitudPiezaRecambio_ { 

    public static volatile SingularAttribute<SolicitudPiezaRecambio, Integer> codigo;
    public static volatile SingularAttribute<SolicitudPiezaRecambio, PiezaRecambio> unaPiezaRecambio;
    public static volatile SingularAttribute<SolicitudPiezaRecambio, String> tiempoEspera;
    public static volatile SingularAttribute<SolicitudPiezaRecambio, String> nivelImportancia;
    public static volatile SingularAttribute<SolicitudPiezaRecambio, Integer> cantidad;
    public static volatile SingularAttribute<SolicitudPiezaRecambio, InformePiezaPedido> unInformePiezaPedido;
    public static volatile SingularAttribute<SolicitudPiezaRecambio, String> nombre;
    public static volatile SingularAttribute<SolicitudPiezaRecambio, Proveedor> unProveedor;
    public static volatile SingularAttribute<SolicitudPiezaRecambio, Boolean> activo;

}