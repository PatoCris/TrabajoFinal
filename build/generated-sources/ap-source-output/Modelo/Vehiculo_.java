package Modelo;

import Modelo.Accesorio;
import Modelo.EstadoVehiculo;
import Modelo.Garantia;
import Modelo.Modelo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:29")
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile SingularAttribute<Vehiculo, String> nroChasis;
    public static volatile SingularAttribute<Vehiculo, Date> fechaCompra;
    public static volatile SingularAttribute<Vehiculo, Integer> codigo;
    public static volatile SingularAttribute<Vehiculo, String> dominio;
    public static volatile SingularAttribute<Vehiculo, String> nroMotor;
    public static volatile SingularAttribute<Vehiculo, Modelo> unModelo;
    public static volatile SingularAttribute<Vehiculo, Garantia> unaGarantia;
    public static volatile ListAttribute<Vehiculo, Accesorio> misAccesorios;
    public static volatile SingularAttribute<Vehiculo, Integer> anio;
    public static volatile SingularAttribute<Vehiculo, Long> kmRecorrido;
    public static volatile SingularAttribute<Vehiculo, Boolean> activo;
    public static volatile ListAttribute<Vehiculo, EstadoVehiculo> misEstados;

}