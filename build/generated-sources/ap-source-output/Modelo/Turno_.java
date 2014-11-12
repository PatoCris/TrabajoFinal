package Modelo;

import Modelo.Cliente;
import Modelo.Modulo;
import Modelo.Servicio;
import Modelo.Trazabilidad;
import Modelo.Vehiculo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:29")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, Date> fecha;
    public static volatile SingularAttribute<Turno, Trazabilidad> unaTrazabilidad;
    public static volatile SingularAttribute<Turno, Integer> codigo;
    public static volatile SingularAttribute<Turno, Date> hora;
    public static volatile SingularAttribute<Turno, Servicio> unServicio;
    public static volatile ListAttribute<Turno, Modulo> misModulos;
    public static volatile SingularAttribute<Turno, Cliente> unCliente;
    public static volatile SingularAttribute<Turno, Boolean> activo;
    public static volatile SingularAttribute<Turno, Vehiculo> unVehiculo;

}