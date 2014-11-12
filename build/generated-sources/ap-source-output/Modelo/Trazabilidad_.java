package Modelo;

import Modelo.Detalle;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:29")
@StaticMetamodel(Trazabilidad.class)
public class Trazabilidad_ { 

    public static volatile SingularAttribute<Trazabilidad, String> descripcion;
    public static volatile SingularAttribute<Trazabilidad, Date> fecha;
    public static volatile SingularAttribute<Trazabilidad, Integer> codigo;
    public static volatile SingularAttribute<Trazabilidad, Date> hora;
    public static volatile ListAttribute<Trazabilidad, Detalle> misDetalles;
    public static volatile SingularAttribute<Trazabilidad, Boolean> activo;

}