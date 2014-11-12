package Modelo;

import Modelo.ReposicionCarburador;
import Modelo.Vehiculo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:29")
@StaticMetamodel(PruebaRodaje.class)
public class PruebaRodaje_ { 

    public static volatile SingularAttribute<PruebaRodaje, Date> fecha;
    public static volatile SingularAttribute<PruebaRodaje, Integer> codigo;
    public static volatile SingularAttribute<PruebaRodaje, Date> hora;
    public static volatile ListAttribute<PruebaRodaje, Vehiculo> misVehiculos;
    public static volatile ListAttribute<PruebaRodaje, ReposicionCarburador> misReposiciones;
    public static volatile SingularAttribute<PruebaRodaje, Long> kmRecorrido;
    public static volatile SingularAttribute<PruebaRodaje, Boolean> activo;

}