package Modelo;

import Modelo.EstadoVehiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:29")
@StaticMetamodel(Servicio.class)
public class Servicio_ { 

    public static volatile SingularAttribute<Servicio, String> descripcion;
    public static volatile SingularAttribute<Servicio, Integer> codigo;
    public static volatile SingularAttribute<Servicio, Double> impuesto;
    public static volatile ListAttribute<Servicio, EstadoVehiculo> misEstadosVehiculo;
    public static volatile SingularAttribute<Servicio, Double> costo;
    public static volatile SingularAttribute<Servicio, String> nombre;
    public static volatile SingularAttribute<Servicio, Boolean> activo;

}