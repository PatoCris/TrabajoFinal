package Modelo;

import Modelo.Anomalia;
import Modelo.Proceso;
import Modelo.TipoReparacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:30")
@StaticMetamodel(Reparacion.class)
public class Reparacion_ extends Servicio_ {

    public static volatile SingularAttribute<Reparacion, Boolean> cubiertoGarantia;
    public static volatile ListAttribute<Reparacion, Proceso> misProcesos;
    public static volatile ListAttribute<Reparacion, Anomalia> misAnomalias;
    public static volatile SingularAttribute<Reparacion, Integer> cantidadTotalModulos;
    public static volatile SingularAttribute<Reparacion, TipoReparacion> unTipoReparacion;

}