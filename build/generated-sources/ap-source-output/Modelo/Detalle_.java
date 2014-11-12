package Modelo;

import Modelo.Ejemplar;
import Modelo.Estado;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:30")
@StaticMetamodel(Detalle.class)
public class Detalle_ { 

    public static volatile SingularAttribute<Detalle, Date> fecha;
    public static volatile SingularAttribute<Detalle, Integer> codigo;
    public static volatile SingularAttribute<Detalle, Date> hora;
    public static volatile SingularAttribute<Detalle, Boolean> activo;
    public static volatile SingularAttribute<Detalle, Estado> unEstado;
    public static volatile ListAttribute<Detalle, Ejemplar> misEjemplares;

}