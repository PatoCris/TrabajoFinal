package Modelo;

import Modelo.PiezaRecambio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-11T20:46:30")
@StaticMetamodel(Devolucion.class)
public class Devolucion_ { 

    public static volatile SingularAttribute<Devolucion, Date> fecha;
    public static volatile SingularAttribute<Devolucion, Integer> codigo;
    public static volatile SingularAttribute<Devolucion, String> motivo;
    public static volatile SingularAttribute<Devolucion, PiezaRecambio> miPiezaRecambio;
    public static volatile SingularAttribute<Devolucion, Boolean> activo;

}