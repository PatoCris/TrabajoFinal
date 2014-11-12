package Modelo;

import Modelo.EstadoVehiculo;
import Modelo.Vehiculo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:30")
@StaticMetamodel(EstadoVehiculo.class)
public class EstadoVehiculo_ { 

    public static volatile SingularAttribute<EstadoVehiculo, Boolean> motor;
    public static volatile SingularAttribute<EstadoVehiculo, Integer> codigo;
    public static volatile SingularAttribute<EstadoVehiculo, Date> hora;
    public static volatile SingularAttribute<EstadoVehiculo, Boolean> amortiguacion;
    public static volatile SingularAttribute<EstadoVehiculo, Boolean> luminaria;
    public static volatile SingularAttribute<EstadoVehiculo, String> detalle;
    public static volatile SingularAttribute<EstadoVehiculo, Boolean> electronica;
    public static volatile SingularAttribute<EstadoVehiculo, Date> fecha;
    public static volatile SingularAttribute<EstadoVehiculo, Long> kilometraje;
    public static volatile SingularAttribute<EstadoVehiculo, Boolean> neumatico;
    public static volatile SingularAttribute<EstadoVehiculo, Boolean> electricidad;
    public static volatile SingularAttribute<EstadoVehiculo, Boolean> carroceria;
    public static volatile SingularAttribute<EstadoVehiculo, EstadoVehiculo> miEstadoIngreso;
    public static volatile SingularAttribute<EstadoVehiculo, Boolean> activo;
    public static volatile SingularAttribute<EstadoVehiculo, Vehiculo> unVehiculo;

}